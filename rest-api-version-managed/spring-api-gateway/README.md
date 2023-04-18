# Spring Api Gateway로 버전 서비스 분기하기

YML에서 라우팅룰을 정의할 수 있다.

```yml
spring:
  cloud:
    gateway:
      routes:
```


1. **URI에 버전을 포함시키는 방법**
```http 
    GET /v1
```
* yaml 파일
```yaml
      routes:
        - id: v1-api-path
          uri: http://localhost:8081
          predicates:
            - Path=/v1/**
          filters:
            - RewritePath=/v1/(?<path>.*), /$\{path}
        - id: v2-api-path
          uri: http://localhost:8083
          predicates:
            - Path=/v2/**
          filters:
            - RewritePath=/v2/(?<path>.*), /$\{path}
```


2. **파라미터로 버전을 표기하는 방법**
```http 
    GET /?version=v1
```

* yaml 파일
```yaml
    - id: v1-api-param
      uri: http://localhost:8081
      predicates:
        - Query=version,v1
    - id: v1-api-param
      uri: http://localhost:8083
      predicates:
        - Query=version,v2
```

3. **커스텀 header값으로 분기 하는 방법**
```http 
GET /api/call
X-API-VERSION: V1
```
* yaml 파일
```
    - id: v1-api-header
      uri: http://localhost:8081
      predicates:
        - Header=X-API-VERSION,v1
    - id: v1-api-header
      uri: http://localhost:8081
      predicates:
        - Header=X-API-VERSION,v2
```

4. **MIME 타입 으로 분기하는 방법**
```http 
GET /api/call
Accept: application/vnd.benggrae.com.v1+json #vnd는 벤더를 의미 
```

* yaml 파일

```yaml
    - id: v1-api-accept
      uri: http://localhost:8081
      predicates:
        - Header=Accept, application/vnd.benggrae.com.v1\+json
    - id: v2-api-accept
      uri: http://localhost:8081
      predicates:
        - Header=Accept, application/vnd.benggrae.com.v1\+json
```