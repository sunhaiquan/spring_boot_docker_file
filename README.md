# debian 运行spring boot项目
[TOC]

# 1、nexus 已搭建
# 2、基于debian orcele.jdk镜像

# 3、创建spring boot 工程

(项目地址)[https://github.com/sunhaiquan/spring_boot_docker_file]

# 4、构建镜像
构建
```python
cd /opt/jenkins-data/workspace/test
```
```python
ls
Dockerfile  pom.xml  src
```
```
mvn clean deploy -Dmaven.test.skip=true dockerfile:build
```

上传镜像到nexus
pom.xml中配置了上传镜像地址,maven在deploy时，会自动上传镜像
```python
#登录私服
docker login 212.18.35.20:8082

#手动上传镜像
docker push 212.18.35.20:8082/test:0.0.1-SNAPSHOT
```
# 5、下载运行
下载镜像
```python
docker pull 212.18.35.20:8082/test:0.0.1-SNAPSHOT
```
运行
```python
docker run -it --rm -p 9081:9081  212.18.35.20:8082/test:0.0.1-SNAPSHOT  /bin/bash

#删除    
docker images| grep 8082/test |awk '{print $3 }' |xargs docker rmi
    
docker rmi `docker images | grep  '8082/test' | awk '{print $3}'`
#容器内查看端口

netstat -anp |grep 9081
tcp        0      0 0.0.0.0:9081            0.0.0.0:*               LISTEN      16/java
```
# 6、测试
浏览器访问
http://localhost:9081/

