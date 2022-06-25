#指定JDK版本
FROM openjdk:8


ENV HOME /home/server
RUN mkdir $HOME
#设置控制台字符集编码
ENV LANG C.UTF-8
#设置docker容器的时间
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD **/target/*.jar $HOME/acl.jar
#拷贝 配置文件和lib到镜像
#COPY config/kfws/  $HOME/config/kfws/

WORKDIR $HOME
#声明使用的端口，需要-p去绑定宿主机否则将随机绑定
EXPOSE 8080

ENTRYPOINT ["java","-jar","acl.jar"]
