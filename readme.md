# Mr.Monitor
实现远程监控服务器状态的简单应用
# 食用方式
1. TestUtils配置监控服务器信息.
2. 对于可使用账号密码进行ssh登录的服务器.只需要配置账号密码即可通过jsch获取服务器运行数据
3. 对于不能使用账号密码进行ssh登录的服务器,例如只允许证书登录的ssh,或者win服务器.则需要配合MrMonMini项目食用
4. 启动项目,访问 http://127.0.0.1 即可


## Still In Developing

## Notice
1.因为前端用的是静态页面.请求地址为绝对地址.所以更改了后端端口的时候,记得把请求地址也改了.
2.两种食用方式择情选择 
