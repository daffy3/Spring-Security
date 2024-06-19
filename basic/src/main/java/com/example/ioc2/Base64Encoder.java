package com.example.ioc2;

import java.util.Base64;

// DI 전
//public class Base64Encoder implements IEncoder{
//
//    public String encode(String message) {
//        return Base64.getEncoder().encodeToString(message.getBytes());
//    }
//
//}

// DI 후
public class Base64Encoder implements IEncoder {

    private IEncoder iEncoder;

    public Base64Encoder() {
        this.iEncoder = new Base64Encoder();
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }

}




