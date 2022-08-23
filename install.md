## coding部署


### 后端
登录coding后，拉取镜像，运行如下命令启动

启动redis
```
docker run -itd --name redis5 -p 8082:6379 redis:5.0 --requirepass "4redis@Invariable"
```

启动mysql5.7
```
```

登录coding
```

```

启动服务
```
docker run -itd -p 8080:8080 --name=acl nayo-docker.pkg.coding.net/acl_base/docker/acl-base
```

## 前端
首先安装下nginx
执行命令打包后文件夹，上传到如下路径下
```
/usr/local/nginx/
```
复制本仓库的nginx配置信息，覆盖nginx的原始配置信息
