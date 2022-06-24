
##docker打包
##编译容器
```shell
docker build -t acl .
```
##运行容器
```shell
docker run -d -it -p 8080:8080 --name acl-test acl
```

##docker-compose打包
##编译容器
```shell
docker build -t acl .
```
##运行容器
```shell
docker run -d -it -p 8080:8080 --name acl-test acl
```
