package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {

        SpringApplication.run(IocApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        // ==========================================================================================

        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);


        Encoder encoder = new Encoder(base64Encoder);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String result = encoder.encode(url);
        System.out.println(result);

        encoder.setiEncoder(urlEncoder);
        result = encoder.encode(url);

        System.out.println(result);

        // ==========================================================================================

        Encoder encoder2 = context.getBean("base64Encode", Encoder.class);
        String url2 = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String result2 = encoder2.encode(url2);
        System.out.println(result2);

    }

}

@Configuration // 한 개의 클래스에서 여러 개의 bean을 등록하겠다는 애너테이션
class AppConfig {

    // @Bean 옆에 이름을 붙여주어 구분짓는다.
    @Bean("base64Encode")
    public Encoder encoder (Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder (UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }

}
