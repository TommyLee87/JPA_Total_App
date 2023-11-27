package com.kh.jpatotalapp.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.security.Key;


@Component
@Slf4j
public class TokenProvider {
    // 토큰 생성, 토큰 검증, 토큰에서 회원정보 추출
    private static final String AUTHOITIES_KEY = "auth";  // 토큰에 저장되는 권한 정보의 key
    private static final String BEARER_TYPE = "Bearer";  // 토큰의 타입
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24L;  // 24시간
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7L;  // 7일
//    private final Key key;  // 토큰을 서명하기 위한 Key

    // 주의점 : @Value 어노테이션은 springframework의 어노테이션이다.
    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
//        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);  // HS512 알고리즘을 사용하는 키 생성
    }

}
