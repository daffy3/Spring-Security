package com.example.ioc;

public class Main {

    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // 첫 번째 요구사항: Base64로 인코딩하기
        Encoder encoder = new Encoder();
        String result = encoder.encode(url);

        // 두 번째 요구사항: URL 인코딩하기
        UrlEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);

        // 1. Encoder와 UrlEncoder가 같은 역할을 하고 있다. (클래스를 살펴보면)
        // 2. 따라서 interface를 생성하여 관리할 수 있다.

        System.out.println(result);
        System.out.println(urlResult);

    }

}

