cd 'C:\Users\anuj.parmar'
docker run -v $PWD/mysqldbdata:/var/lib/mysql --name mysql-db -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql

cd 'C:\Anuj\Coursera\LinkedIn_Learning\microservice\TransportationPortal'
mvn clean install -DskipTests=True
docker build -f Dockerfile -t transporter:1
docker container run -d -p 9000:9000 --name transporter transporter:1