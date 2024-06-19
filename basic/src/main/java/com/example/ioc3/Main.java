package com.example.ioc3;

public class Main {

    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // 첫 번째 요구사항: Base64로 인코딩하기
        // 두 번째 요구사항: URL 인코딩하기

        // 1. Encoder와 UrlEncoder가 같은 역할을 하고 있다. (클래스를 살펴보면)
        // 2. 따라서 interface를 생성하여 관리할 수 있다.
        // 3. interface로 변경하여 관리하였지만, 코드상으로 큰 차이는 없어 보인다.
        // 4. DI 활용

        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);
        System.out.println(result);
    }

}

