package com.proxym_it.app.structure_app.networks.interceptors;


import com.proxym_it.app.structure_app.networks.ParamsWebService;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by bayoudh on 2016/9/18.
 */

public class CacheInterceptor implements Interceptor {
    /**
     * An HTTP response. Instances of this class are not immutable: the response body is a one-shot
     * value that may be consumed only once and then closed. All other properties are immutable.
     * <p>
     * <p>This class implements {@link Closeable}. Closing it simply closes its response body. See
     * {@link ResponseBody} for an explanation and examples.
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        // re-write response header to force use of cache
        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(ParamsWebService.CONFIG_RETROFIT.MAX_CACHE_CONTROL, TimeUnit.SECONDS)
                .build();
        return response.newBuilder()
                .header(ParamsWebService.CONFIG_RETROFIT.CACHE_CONTROL, cacheControl.toString())
                .build();
    }
}
