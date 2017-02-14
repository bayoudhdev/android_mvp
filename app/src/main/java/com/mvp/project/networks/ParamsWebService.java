package com.mvp.project.networks;

/**
 * Created by bayoudh on 25/10/2016.
 */

public class ParamsWebService {
    public static final String DEFAULT_BASE_URL = "http://your-ws-url.com";
    public static final String WS_PARMS_INPUT_USER_PASSWORD = "pass";
    public static final String KEY_WS_LOGIN = "login";


    public static class ErrorMessageWS {
        public static int KEY_SUCCESS_WS = 1;
        public static int KEY_FAILD_WS = 0;
        public static int KEY_ERROR_SERVER = 400;
    }


    public class CONFIG_RETROFIT {
        public static final String CACHE_CONTROL = "Cache-Control";
        public static final int MAX_CACHE_CONTROL = 30;
        public static final int MAX_STALE_CACHE_CONTROL = 5;
        public static final String KEY_CACHE_DATA = "http-cache";
        public static final long KEY_MAX_SIZE_CACHE = 10 * 1024 * 1024;// 5 MB
    }


    public class INJECTOR_CONFIG {
        public static final int CONNECT_TIME_OUT = 15;
        public static final int WRITE_TIME_OUT = 20;
        public static final int READ_TIME_OUT = 20;
    }

}
