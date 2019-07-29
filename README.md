# 项目名为JavaTest4 子模块为Exam1，最终版的代码是third分支的代码

# 注意这里，因为第二次提交的时候不小心按到了-f，所以整个仓库被覆盖了，因此重传了代码，但是仓库历史还在
# dev是第一次提交的时候的代码，可以查看dev分支的commit，最早的那一次就是12点传的那次.已经可以合理运行
# master，是第二次提交修改后的代码，完善了代码，添加了参数解析器
# third，是第三次提交修改后的代码，也是最终代码分支，添加了Pagehelper
# dev分支的代码是最早提交的，其次才是master分支<br><br><br><br>
## 在最早的dev分支下，因为build.sh加载后，没有把jar文件放到指定位置就进行了镜像构建，会导致找不到jar包，所以dev分支下，也就是上午提交的代码中，需要## 手动进行```mvn clean package```把jar包放到docker/java文件下，然后```docker-compose build docker-compose up```来生成镜像和容器
## 在第一次提交之后的提交，都针对这个问题进行了处理。第一次提交的代码在可以完整运行的
## build.sh用于编译maven项目和构建镜像
## 构建完项目，要把项目放在docker目录的java文件夹下
## start.sh用于启动docker-compose容器
## 启动容器后需要等待直到mysql加载完成后，显示端口成功时，
## curl.sh 用于向java容器发起请求
## stop.sh 用于停止socker-compose，并且打开日志
### 登陆 curl -v http://localhost:18080/login?password=SMITH\&name=MARY 
### 查询 curl -v http://localhost:18080/listall?page=1
### 插入 result=`curl -X POST -d "first_name=test\&last_name=123\&email=873062356\&address=47 MySakila Drive" http://localhost:18080/insert`
### 更新 curl -X PUT http://localhost:18080/updatebyid?first_name=test\&last_name=456\&email=873062356\&customerid=${result}\&address=47 MySakila Drive
### 删除 curl -X DELETE  http://localhost:18080/deletebyid?customerid=${result}
# 本地运行的网址
### http://localhost:18080/login?password=SMITH&name=MARY 登录
### http://localhost:18080/listall?page=1 查询
### http://localhost:18080/insert?first_name=test&last_name=123&email=873062356&address=47 MySakila Drive 插入
### http://localhost:18080/updatebyid?first_name=test&last_name=456&email=873062356&customerid=100&address=47 MySakila Drive 更新
### http://localhost:18080/deletebyid?customerid=100  删除
