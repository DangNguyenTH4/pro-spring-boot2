# Pro spring boot 2 - Practice and improvement


1, run prometheus & granfana:
```docker
cd metric/
docker-compose up -d
```

2, package application
```maven
./mvnw package
#./mvnw package&& java -jar target/actuator-0.0.1-SNAPSHOT.jar
```
3, build & run todo app by docker
## Code blocks
```docker
docker build -t todoapp .   
docker run -p 8080:8080 todoapp
```
   
