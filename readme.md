# Mr.Monitor
实现远程监控服务器状态的简单应用
# 计划
-[x] 简单实现远程查看linux系统信息
-[x] 实现查看windows系统信息
-[ ] 多线程优化
-[ ] 局域网状态查看
-[ ] WOL！

# 食用方式
1. TestUtils配置监控服务器信息.
2. 对于可使用账号密码进行ssh登录的服务器.只需要配置账号密码即可通过jsch获取服务器运行数据
3. 对于不能使用账号密码进行ssh登录的服务器,例如只允许证书登录的ssh,或者win服务器.则需要配合MrMonMini项目食用 https://github.com/HelloMrK/MrMonMini
4. 启动项目,访问 http://127.0.0.1:60000 即可

## Still In Developing
1. 想多线程去连接查询服务器状态。但是没有测试用的机器了。所以搁置 (2022-08-27)
2. 做个局域网信息查看，WOL唤醒功能等(2022-08-27)
3. 引入一个数据库(2022-08-27)

## Notice
1. 因为前端用的是静态页面.请求地址为绝对地址.所以更改了后端端口的时候,记得把请求地址也改了.
2. 两种食用方式择情选择 
