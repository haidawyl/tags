export PATH=/opt/jdk1.8.0_151/bin:$PATH
export CLASSPATH=/opt/jdk1.8.0_151/lib
export TZ=Asia/Shanghai
export LANG=zh_CN.UTF-8
export SPRING_PROFILES_ACTIVE=prod

nohup java -jar tags-0.1-SNAPSHOT.jar --server.port=8080 &
