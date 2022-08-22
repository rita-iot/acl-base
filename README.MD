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

### 2022-03-26

- 移除swagger-bootstrap-ui组件，引入knife4j文档组件
- 学习项目，建议有点基础的可以随意自定义相关实现
- 新增EasyCaptcha验证码组件
- 新增地区新增接口，验证swagger文档是否生成正确
- 修复用户验证码或密码错误提示
- 自定义异常逻辑学习
- 注销登录接口更改，基本没啥大问题
- 处理统一结果返回类

------

### 项目技术栈

- Java 1.8
- Mybatis Plus 3.0.5
- SpringBoot 2.3.4
- Mysql 5.7
- Redis 3.0+
- Swagger 2.7.0
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

请求地址：http://localhost:8080/admin/login

提交方式：POST

consumes ["application/json"]

produces ["*/*"]

接口示例:

```
{
    "username":"admin",
    "password": "123456",
    "captcha":"6yxp7"
}
```

**User对象**

| 参数名称    | 参数说明                                    | 请求类型 | 是否必须 | 数据类型          |
| ----------- | ------------------------------------------- | -------- | -------- | ----------------- |
| captcha     | 验证码                                      | body     | true    | string            |
| gmtCreate   | 创建时间                                    | body     | false    | string(date-time) |
| gmtModified | 更新时间                                    | body     | false    | string(date-time) |
| id          | 会员id                                      | body     | false    | string            |
| isDeleted   | 逻辑删除 1（true）已删除， 0（false）未删除 | body     | false    | boolean           |
| nickName    | 昵称                                        | body     | false    | string            |
| password    | 密码                                        | body     | true    | string            |
| salt        | 用户头像                                    | body     | false    | string            |
| token       | 用户签名                                    | body     | false    | string            |
| username    | 微信openid                                  | body     | true    | string            |

### 注销登录

请求地址：http://localhost:8080/admin/logout

提交方式：GET

consumes ["application/json"]

produces ["*/*"]

请求头Header:  toke:获取到的token值

### 获取当前用户信息：

请求地址：http://localhost:8080/index/info

提交方式：GET

consumes `["application/json"]`

produces `["*/*"]`

请求头Header:  toke:获取到的token值

其余接口可以通过api文档查看。
