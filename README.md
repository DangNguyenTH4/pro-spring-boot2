# Pro spring boot 2 - Practice and improvement


1, run prometheus & granfana:
cd metric/
docker-compose up -d
2, package application
./mvnw package
#./mvnw package&& java -jar target/actuator-0.0.1-SNAPSHOT.jar
2, build & run todo app by docker
docker build -t todoapp .   
docker run -p 8080:8080 todoapp   
