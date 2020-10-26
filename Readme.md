docker run -p 3306:3306 --name springboot_mariadb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=root -e  MYSQL_PASSWORD=root -e MYSQL_DATABASE=springboot_mariadb  -d mariadb

docker container start #container_id

http://localhost:8080/swagger-ui.html