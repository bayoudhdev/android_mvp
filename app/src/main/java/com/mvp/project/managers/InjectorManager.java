package com.mvp.project.managers;


import com.mvp.project.BuildConfig;
import com.mvp.project.commons.bases.applications.BaseApplication;
import com.mvp.project.commons.utils.DebugLog;
import com.mvp.project.networks.ParamsWebService;
import com.mvp.project.networks.interceptors.CacheInterceptor;
import com.mvp.project.networks.interceptors.OfflineCacheInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Bayoudh on 10/08/2016.
 */
public class InjectorManager {


    private static InjectorManager mRetrofitManager;
    private Retrofit mRetrofit;

    private InjectorManager(String baseUrl) {
        mRetrofit = provideRetrofit(baseUrl);
    }

    public static synchronized InjectorManager getInstance(String baseUrl, Boolean isRefreshBaseUrl) {
        if (mRetrofitManager == null || (mRetrofitManager != null && isRefreshBaseUrl)) {
            mRetrofitManager = new InjectorManager(baseUrl);
        }
        return mRetrofitManager;
    }

    /**
     * Retrofit adapts a Java interface to HTTP calls by using annotations on the declared methods to
     * define how requests are made. Create instances using {@linkplain Retrofit.Builder
     * the builder} and pass your interface to generate an implementation.
     * <p>
     * For example,
     * <pre><code>
     * Retrofit retrofit = new Retrofit.Builder()
     *     .baseUrl("https://api.example.com/")
     *     .addConverterFactory(GsonConverterFactory.create())
     *     .build();
     *
     * MyApi api = retrofit.create(MyApi.class);
     * Response&lt;User&gt; user = api.getUser().execute();
     * </code></pre>
     */
    public Retrofit provideRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(provideOkHttpClient())
                .build();
    }


    /**
     * Returns a modifiable list of interceptors that observe the full span of each call: from
     * before the connection is established (if any) until after the response source is selected
     * (either the origin server, cache, or both).
     */
    private OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(provideHttpLoggingInterceptor())
                .addInterceptor(new CacheInterceptor())
                .addNetworkInterceptor(new OfflineCacheInterceptor())
                .cache(provideCache())
                .connectTimeout(ParamsWebService.INJECTOR_CONFIG.CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(ParamsWebService.INJECTOR_CONFIG.READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(ParamsWebService.INJECTOR_CONFIG.WRITE_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    /**
     * Make cache provide to save offline data
     *
     * @return
     */
    private Cache provideCache() {
        Cache cache = null;
        try {
            File file = new File(BaseApplication.getInstance().getCacheDir(), ParamsWebService.CONFIG_RETROFIT.KEY_CACHE_DATA);
            file.setReadable(true);
            cache = new Cache(file,
                    ParamsWebService.CONFIG_RETROFIT.KEY_MAX_SIZE_CACHE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cache;
    }

    /**
     * An OkHttp interceptor which logs request and response information. Can be applied as an
     * {@linkplain OkHttpClient#interceptors() application interceptor} or as a {@linkplain
     * OkHttpClient#networkInterceptors() network interceptor}. <p> The format of the logs created by
     * this class should not be considered stable and may change slightly between releases. If you need
     * a stable logging format, use your own interceptor.
     */
    private HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        DebugLog.v(message);
                    }
                });
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return httpLoggingInterceptor;
    }

    public <T> T createReq(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }


}
