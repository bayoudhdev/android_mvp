package com.mvp.project.networks.interfaces;


import com.mvp.project.networks.ParamsWebService;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by bayoudh on 25/10/2016.
 */

public interface IRUserService {
    @FormUrlEncoded
    @POST(ParamsWebService.KEY_WS_LOGIN)
    Call<Object> postLogin(@Field(ParamsWebService.WS_PARMS_INPUT_USER_PASSWORD) String password);
}
