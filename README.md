# Microservice Course

### Endpoints

#### Save Product

```
POST /api/product HTTP/1.1
Host: localhost:3333
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json

{
    "name": "Nike-Air",
    "vendor": "Nike",
    "category": 1,
    "price": 200
}
```

#### Get Products

````
GET /api/product HTTP/1.1
Host: localhost:3333
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
````

#### Delete Product

````
DELETE /api/product/1 HTTP/1.1
Host: localhost:3333
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
````

#### Docker commands

````
1.Create jar file
mvn clean install -Dmaven.test.skip

2.Run app with mvn
mvn spring-boot:run

3.Create docker image
docker build . -t subo8/mini2-product

4.Docker run
docker run -d --network=backend --name=product -p 3333:3333 subo8/mini2-product

5. Push images to docker hub
docker login
//optional
docker tag mini2/eureka:latest subo8/mini2-eureka:latest

docker push subo8/mini2-product

Optional
4.Create docker file automaticaly by paketobuildpacks
mvn spring-boot:build-image
````
