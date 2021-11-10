package kr.couchcoding.tennis_together.util;

public class RequestUtil {

    // 헤더값 검증
    public static String getAuthorizationToken(String header){

        // 헤더값에 Authorization 값이 없거나 유효하지 않은경우
        if (header == null || !header.startsWith("Bearer ")){
            throw new IllegalArgumentException("Invalid authorization header");
        }

        // parts[0] : bearer, parts[1] : token
        String[] parts = header.split(" ");
        if (parts.length != 2){
            throw new IllegalArgumentException("Invalid authorization header");
        }

        // Token return
        return parts[1];

    }
}
