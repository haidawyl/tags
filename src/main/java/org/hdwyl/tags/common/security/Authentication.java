package org.hdwyl.tags.common.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.time.DateUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Authentication {

    // 秘钥
    private static final String SK = "YhoY47XixDrxy3ZMR8r=";

    public static String decodeUser(String token) {
        byte[] encodedKey = Base64.decodeBase64(SK);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();

            return (String) claims.get("account");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取token
     * @return
     * @throws Exception
     */
    public static String getToken(String usrCode) throws Exception {

        byte[] encodedKey = Base64.decodeBase64(SK);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Map<String, Object> claims = new HashMap<>();

        claims.put("account", usrCode);

        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(DateUtils.addHours(now, 24))
                .signWith(SignatureAlgorithm.HS256, key).setClaims(claims);
//                .addClaims(claims);

        return builder.compact();

    }

    public static String decrypt(String password) {
        return PwdEncryptor.decrypt(password);
    }

    public static void main(String[] args) throws Exception {
        String key = "0280086";
        System.out.println(Authentication.getToken(key));
        String token = Authentication.getToken(key);
        System.out.println(Authentication.decodeUser(token));
    }
}
