# Fixture 와 다이나믹 테스트

## TestFixture란?
- 테스트 코드에서 공유되는 초기 상태나 리소스를 설정하는 데 사용되는 개념
- 테스트 코드를 작성할 때마다 반복적으로 실행되는 코드를 줄이고, 테스트 코드의 가독성을 높이기 위해 사용


### TestFixture 예시
```java
    public static Car 가격이_100000인_테슬라() {
      return Car.builder()
      .name("Tesla")
      .price(100000)
      .build();
      }
```
* 사용 
```java
  @Test
  @DisplayName("가격이_100000인_테슬라 주문 생성")
  void createOrder() {
      // given
      Car car = CarFixture.가격이_100000인_테슬라();
      int quantity = 2;

      // when
      Order order = Order.builder()
              .car(car)
              .quantity(quantity)
              .build();

      // then
      assertEquals(car, order.getCar());
      assertEquals(order.getCar().getName(), "Tesla");
      assertEquals(quantity, order.getQuantity());
  }
 ```

### 멀티 모듈 환경에서 TestFixture를 공유 하는 방법 (gradle)
* 경로
  * testFixtures/java/패키지명/파일명.java

* TestFixture 플러그인 추가 (build.gradle)
```groovy
plugins {
    id 'java-test-fixtures'
}
```

* 공유할 모듈에 TestFixtures 추가 (build.gradle)
```groovy
project(':order') {
    dependencies {
        implementation project(':Car')
        testImplementation(testFixtures(project(':Car')))
    }
}
```



