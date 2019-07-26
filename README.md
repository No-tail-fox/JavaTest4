# 项目名为JavaTest4 子模块为Exam1，最终版的代码是third分支的代码

# 注意这里，因为第二次提交的时候不小心按到了-f，所以整个仓库被覆盖了，因此重传了代码，但是仓库历史还在
# dev是第一次提交的时候的代码，可以查看dev分支的commit，最早的那一次就是12点传的那次
# master，是第二次提交修改后的代码
# third，是第三次提交修改后的代码，也是最终代码分支
# dev分支的代码是最早提交的，其次才是master分支<br><br><br><br>
## build.sh用于编译maven项目和构建镜像
## start.sh用于启动docker-compose容器
## 启动容器后需要等待直到mysql加载完成后
## curl.sh 用于向java容器发起请求
## stop.sh 用于停止socker-compose，并且打开日志
### 登陆 curl -v http://localhost:18080/login?password=SMITH\&name=MARY 
### 查询 curl -v http://localhost:18080/listall?page=1
### 插入 result=`curl -X POST -d "first_name=test\&last_name=123\&email=873062356\&address=47 MySakila Drive" http://localhost:18080/insert`
### 更新 curl -X PUT http://localhost:18080/updatebyid?first_name=test\&last_name=456\&email=873062356\&customerid=${result}\&address=47 MySakila Drive
### 删除 curl -X DELETE  http://localhost:18080/deletebyid?customerid=${result}
