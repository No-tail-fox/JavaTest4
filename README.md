# ��Ŀ��ΪJavaTest4 ��ģ��ΪExam1
## build.sh���ڱ���maven��Ŀ�͹�������
## start.sh��������docker-compose��iȥ
## curl.sh ������java������������
## stop.sh ����ֹͣsocker-compose
### ��½ curl -v http://localhost:18080/login?password=SMITH\&name=MARY 
### ��ѯ curl -v http://localhost:18080/listall?page=1
### ���� result=`curl -X POST -d "first_name=test\&last_name=123\&email=873062356\&address=47 MySakila Drive" http://localhost:18080/insert`
### ���� curl -X PUT http://localhost:18080/updatebyid?first_name=test\&last_name=456\&email=873062356\&customerid=${result}\&address=47 MySakila Drive
### ɾ�� curl -X DELETE  http://localhost:18080/deletebyid?customerid=${result}