package com.zeroyip.zero.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtil {
    // 设置token过期时间为12小时
    private static final long EXPIRE_TIME = 720*60*1000;

    /*
     *
     * 生成签名，并在规定时间后过期
     * @param userEmail 用户账号
     * @param secret 用户密码
     * @return 加密的token
     *
     * */
    public static String sign(String userEmail, String secret) {
        try {
            // 计算出token的过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 使用HMAC256加密算法
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带userEmail信息
            return JWT.create()
                    .withClaim("userEmail", userEmail)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /*
     *
     * 校验token是否正确
     * @param token 密钥
     * @param secret 加密后的用户信息
     * @return 是否正确
     *
     * */
    public static boolean verify(String token, String secret, String userPsw) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(userPsw);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userEmail", secret)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("This is jwt: " + jwt);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    /*
     *
     * 获得token中的信息无需secret解密亦可获得
     * @return token中包含的用户名
     *
     * */
    public static String getuserEmail(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userEmail").asString();
        }
        catch (JWTDecodeException e) {
            return null;
        }
    }
}
