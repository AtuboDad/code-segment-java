package com.mundo.netty.demo.constants;

public class Constants {

    public final static String SUCCESS = "success";
    public final static String TOKEN_PREFIX = "MundoToken_";

    public final static String TOKEN_NAME = TOKEN_PREFIX + "1";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

}
