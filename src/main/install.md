## coding部署


### 后端
登录coding后，拉取镜像，运行如下命令启动
```
docker run -itd --name redis5 -p 8082:6379 redis:5.0 --requirepass "4redis@Invariable"
```

```
docker run -itd -p 8080:8080 --name=acl nayo-docker.pkg.coding.net/acl_base/docker/acl-base
```

1
