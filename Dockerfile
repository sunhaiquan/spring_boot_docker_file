FROM 172.18.35.20:8082/oracle_jdk8_debian:v1
#FROM openjdk:latest
ADD target/test.jar /opt/app.jar
#暴露端口
EXPOSE 9081

#指定容器工作空间
WORKDIR  /opt

# 设置JAVA变量环境
ENV JAVA_HOME=/usr/local/jdk1.8.0_231
ENV CLASSPATH=.:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib
ENV PATH=$JAVA_HOME/bin:$PATH
#ENTRYPOINT ["java -version"]
ENTRYPOINT ["java","-jar","/opt/app.jar"]