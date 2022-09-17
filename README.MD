## 前后端分离后端模块脚手架 SpringBoot+Security+Jwt

<p align="left">
	<a target="_blank" href="https://www.apache.org/licenses/LICENSE-2.0.html">
		<img src="https://img.shields.io/:license-apache-blue.svg" ></img>
	</a>
	<a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/JDK-1.8-green.svg" ></img>
	</a>
    <a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/SpringBoot-2.3.4-blue.svg" ></img>
	</a>
    <a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/Mysql-5.7-green.svg" ></img>
	</a>
    <a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/MybatisPlus-3.0-yellow.svg" ></img>
	</a>
	<a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/Redis-3.0-pink.svg" ></img>
	</a>
		<a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/Jwt-0.9.1-red.svg" ></img>
	</a>
</p>

### 项目技术栈

- Java 1.8
- Mybatis Plus 3.0.5
- SpringBoot 2.7.0
- Mysql 5.7
- Redis 5.7.0
- Swagger 2.9.0
- Jwt Token

------

### 项目概述

项目采用前后端分离的形式开发，这里只是一个后端项目的基础模块， 试用于单体项目的快速开发，基本的权限系统接口都有，用户只需要关注具体的业务模块即可。 目前项目会持续维护中。。。

### 项目功能

- 首页功能
- 用户管理
- 角色管理
- 权限管理
- 日志管理（待开发）

------

### 登录接口：

请求地址：http://localhost:8080/user/login

提交方式：POST

consumes ["application/json"]

produces ["*/*"]

接口示例:

```
{
    "username":"admin",
    "password": "123456"
}
```
### 注销登录

请求地址：http://localhost:8080/user/logout

提交方式：GET

consumes ["application/json"]

produces ["*/*"]

请求头Header:  Authorization:获取到的Authorization值

### 获取当前用户信息：

请求地址：http://localhost:8080/user/info

提交方式：GET

consumes `["application/json"]`

produces `["*/*"]`

请求头Header:  Authorization:获取到的Authorization值

其余接口可以通过api文档查看。
