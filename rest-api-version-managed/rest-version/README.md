> Spring REST API를 작성할때 API에 대하여 버전 관리 필요성을 느낄때가 있다.


## 버전 관리 방법
> 버전 관리 방법에 조사에 따르면 총 4가지에 방식이 있다.


1. **URI에 버전을 포함시키는 방법** : [트위터](https://developer.twitter.com/en/docs/twitter-api/v1/tweets/curate-a-collection/api-reference/get-collections-entries), [아마존](https://docs.aws.amazon.com/apigatewayv2/latest/api-reference/apis-apiid.html)에서 방식을 채택중

```http 
GET /api/v1/call
```

*  Spring 소스
```java
@RestController  
@RequestMapping("/api")  
@RequiredArgsConstructor  
public class HelloController {  
 
   private final NewVersionService newVersionService;  
   private final OldVersionService oldVersionService;  
 
   @GetMapping("v1/version")  
   public String version() {  
       return oldVersionService.findName();  
 
   }  
 
   @GetMapping("v2/version")  
   public String version2() {  
       return newVersionService.findName();  
   }  
}
```

**2. 파라미터로 버전을 표기하는 방법 :**
    
```http 
    GET /api/call?version=v1
```
* Spring 소스
```java
@RestController  
@RequestMapping("/api")  
@RequiredArgsConstructor  
public class ParamVersionController {  
    private final NewVersionService newVersionService;  
    private final OldVersionService oldVersionService;  
    @GetMapping("/version")  
    public String api(@RequestParam String version){  
        if (version.equals("V2")) {  
            return newVersionService.findName();  
        }  
        return oldVersionService.findName();  
    }  
  
}
```

3. 커스텀 header값으로 분기 하는 방법 
```http 
GET /api/call
X-API-VERSION: V1
```

* Spring 소스
```java
@GetMapping(path = "header", headers = {"X-API-VERSION=V1"})  
public String v1() {  
    return oldVersionService.findName();  
}  
@GetMapping(path = "header", headers = {"X-API-VERSION=V2"})  
public String v2() {  
    return newVersionService.findName();  
}
```

4. MIME 타입 으로 분기하는 방법 :
```http 
GET /api/call
Accept: application/vnd.benggrae.com.v1+json #vnd는 벤더를 의미 
```

```java
public class BengMimeType {  
  
    public static final String V1_JSON =  "application/vnd.benggrae.com.v1+json";  
    public static final String V2_JSON =  "application/vnd.benggrae.com.v2+json";  
}

@GetMapping(path = "name", produces = BengMimeType.V1_JSON)  
public String v1() {  
    return oldVersionService.findName();  
}  
@GetMapping(path = "name", produces = BengMimeType.V2_JSON)  
public String v2() {  
    return newVersionService.findName();  
}
```
