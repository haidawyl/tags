package org.hdwyl.tags.datasource;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoClient extends DataSourceConfig {

    protected static final Logger logger = LoggerFactory.getLogger(MongoClient.class);

    MongoDatabase mongoDatabase = null;

    public MongoClient(String host, int port, String username, String password, String schema) {
        super(host, port, username, password, schema);

        ServerAddress serverAddress = new ServerAddress(super.host, super.port);
        List<ServerAddress> addressList = new ArrayList<ServerAddress>();
        addressList.add(serverAddress);

        MongoCredential credential = MongoCredential.createScramSha1Credential(super.username, super.schema, new String(Base64.decodeBase64(super.password.getBytes())).toCharArray());
        List<MongoCredential> credentialList = new ArrayList<MongoCredential>();
        credentialList.add(credential);

        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(50); // 与目标数据库能够建立的最大connection数量为50
        builder.threadsAllowedToBlockForConnectionMultiplier(50); // 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
        /*
         * 一个线程访问数据库的时候，在成功获取到一个可用数据库连接之前的最长等待时间为2分钟
         * 这里比较危险，如果超过maxWaitTime都没有获取到这个连接的话，该线程就会抛出Exception
         * 故这里设置的maxWaitTime应该足够大，以免由于排队线程过多造成的数据库访问失败
         */
        builder.maxWaitTime(1000 * 60 * 2);
        builder.connectTimeout(1000 * 60 * 1); // 与数据库建立连接的timeout设置为1分钟

        MongoClientOptions options = builder.build();
        // 通过连接认证获取MongoDB连接
        com.mongodb.MongoClient mongoClient = new com.mongodb.MongoClient(serverAddress, credentialList, options);

        // 连接到数据库
        mongoDatabase = mongoClient.getDatabase(super.schema);
    }

    public Document findOne(String collectionName, Map<String, Object> queryMap, String[] fieldNames) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        BasicDBObject query = new BasicDBObject();
        for (String key : queryMap.keySet()) {
            if (StringUtils.equalsIgnoreCase(key, "id")) {
                query.append("_id", new ObjectId(queryMap.get(key).toString()));
            } else {
                query.append(key, queryMap.get(key));
            }
        }
        BasicDBObject fields = new BasicDBObject();
        for (String fieldName : fieldNames) {
            fields.put(fieldName, 1);
        }
        FindIterable<Document> iterables = collection.find(query).projection(fields);
        return iterables.iterator().next();
    }
}
