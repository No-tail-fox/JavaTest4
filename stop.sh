#!\bin\bash
docker logs java-1
read
docker stop java-1
docker stop mysql-1
docker rm java-1
docker rm mysql-1
docker rmi springboot
docker rmi mysqltest
