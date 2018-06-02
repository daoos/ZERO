## ZERO (Webpack+Vue+Vuetify+Maven+Spring Boot+MyBatis+Shiro+JWT+CORS+RESTful API) ##

### 系统说明 ###
一个基于前后端分离的任务事项列表及管理系统。前端基于Webpack+vue-cli构建的基础架构，并运用了vue-router+vuex+axios；后端基于Maven构建的基础架构，运用了Spring Boot+MyBatis框架，并采用JWT+Shiro实现用户权限管理；前端服务器为Node.js，后端服务器使用Apache Tomcat；使用CORS解决跨域访问的问题；URL进行RESTful风格化。

  
### 开发环境配置 ###
> 操作系统：Windows 10 Professional Edition  
> 开发工具：Microsoft Visual Studio Code, JetBrains IntelliJ IDEA, JetBrains DataGrips

### 系统相关技术 ###
> 前端  
> -设计架构：MVVM  
> -Webpack  
> -Vue.js (vue-cli + vue-router + vuex + axios)  
> -Vuetify  
> -服务器:Node.js  
> -设计风格:Material Design  
  
> 后端  
> -设计框架：MVC  
> -Maven  
> -Spring Boot + MyBatis  
> -JWT + Shiro  
> -服务器：Apache Tomcat  
> -数据库：MySQL  

> 跨域解决  
> -CORS  
> -RESTful API 

> 版本管理  
> -Git  
> -GitHub  

### 实现功能 ###
- [x] ~~前后端分离~~
- [x] ~~前后端无状态~~
- [x] ~~跨域访问~~
- [x] ~~路由跳转认证(当token无效或过期的情况下，页面跳转至登录界面)~~
- [x] ~~用户权限认证~~
- [x] ~~token的存储(本系统将token存储于localStorage)~~
- [x] ~~保持登录~~
- [x] ~~用户信息查看(管理员)~~
- [x] ~~发布公告(管理员)~~
- [ ] 过滤器管理(管理员)
- [ ] 备忘录功能模块
- [x] ~~快速查找功能~~
- [x] ~~接收公告功能~~
- [x] ~~待办事项功能模块~~
- [x] ~~清单功能模块~~
- [x] ~~过滤器功能模块~~
- [x] ~~个人设置功能模块~~
- [x] ~~团队协作功能模块~~


### 准备工作 ###
- Webpack相关概念及操作(vue-cli中所使用的Webpack版本为v3.x，其部分操作与v4.x有所区别)。详情请参阅：https://www.webpackjs.com/concepts/
- Vue.js全家桶相关概念。详情请参阅：https://cn.vuejs.org/v2/guide/
- Axios相关操作。详情请参阅：https://www.kancloud.cn/yunye/axios/234845
- Vuetify样式库。详情请参阅：https://vuetifyjs.com/zh-Hans/getting-started/quick-start
- Maven教程。详情请参阅：https://www.yiibai.com/maven/
- Maven中POM官方标准配置。详情请参阅：http://maven.apache.org/guides/introduction/introduction-to-the-pom.html
- Spring Boot + MyBatis相关配置，自行百度
- JWT(JSON Web Token)相关概念。可参阅：https://www.jianshu.com/p/576dbf44b2ae
- Shiro相关概念。可参阅：https://www.ibm.com/developerworks/cn/web/wa-apacheshiro/index.html
- RESTful API相关概念。可参阅：http://www.ruanyifeng.com/blog/2014/05/restful_api.html

### 程序逻辑 ###
1. 用户键入用户名及密码，前端将数据传输至后端，后端先将其与数据库进行比对，比对成功(即存在该数据)则生成相应的token，否则返回错误状态码；
2. 当用户进行相应的操作(需要验证token)时，验证localStorage中的token是否存在，再抽取并将其与后端进行比对(可能存在后端的token过期的情况)，若验证成功则继续进行相应操作，否则返回相应的状态码；

### 前后端部署 ###
前端
``` bash
# 开发环境(由于项目特殊性，仅进行了生产环境下的测试)
# (生产环境需要进行相关的配置，有所不同)
cnpm run dev / npm run dev

```
后端
``` bash
使用IDEA打开，将自动进行Maven构建

```