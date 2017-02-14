package com.proxym_it.app.structure_app.networks.interceptors;


import com.proxym_it.app.structure_app.commons.bases.applications.BaseApplication;
import com.proxym_it.app.structure_app.commons.utils.NetworkUtils;
import com.proxym_it.app.structure_app.networks.ParamsWebService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by bayoudh on 25/10/2016.
 */

public class OfflineCacheInterceptor implements Interceptor {
    /**
     * A Cache-Control header with cache directives from a server or client. These directives set policy
     * on what responses can be stored, and which requests can be satisfied by those stored responses.
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (NetworkUtils.isInternetExist(BaseApplication.getInstance())) {
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxStale(ParamsWebService.CONFIG_RETROFIT.MAX_STALE_CACHE_CONTROL, TimeUnit.DAYS)
                    .build();
            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();
        }
        return chain.proceed(request);
    }
}
