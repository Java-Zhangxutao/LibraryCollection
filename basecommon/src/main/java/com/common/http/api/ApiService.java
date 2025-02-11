package com.common.http.api;


import com.common.http.base.BaseResponse;
import com.common.http.bean.ExampleBean;
import com.common.http.bean.ExampleFileBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

/**
 * @Author: 张鹏飞
 * @Email: 1271396448@qq.com
 * <p>
 * @Desc: BaseResponse<T> 是后台返回的数据,T代表Data里面的数据 无数据返回可直接写BaseReponse
 */
public interface ApiService {

    /**
     * Get请求
     *
     * @param map
     * @return
     */
    @GET("api/get")
    Observable<BaseResponse<ExampleBean>> testGet(@QueryMap HashMap<String, Object> map);

    /**
     * Post请求
     *
     * @param map
     * @return
     */
    @POST("api/post")
    @FormUrlEncoded
    Observable<BaseResponse> testPost(@FieldMap HashMap<String, Object> map);

    /**
     * Put请求
     *
     * @param map
     * @return
     */
    @PUT("api/put")
    @FormUrlEncoded
    Observable<BaseResponse> testPut(@FieldMap HashMap<String, Object> map);

    /**
     * Delete请求
     *
     * @param map
     * @return
     */
    @DELETE("api/delete")
    Observable<BaseResponse<ExampleBean>> testDelete(@QueryMap HashMap<String, Object> map);

    /**
     * post提交json格式数据
     * @param body
     * @return
     */
    @POST("api/postJson")
    Observable<BaseResponse<ExampleBean>> testPostJson(@Body RequestBody body);

    /**
     * 文件上传
     * @param file
     * @param map
     * @return
     */
    @POST("api/uploadFile")
    @Multipart
    Observable<BaseResponse<ExampleFileBean>> testUploadFile(@Part MultipartBody.Part file, @PartMap HashMap<String, Object> map);

    /**
     * 例子1: GET
     *
     * @return
     */
    @GET("example/1")
    Observable<BaseResponse<ExampleBean>> example1(@QueryMap HashMap<String, Object> map);

    /**
     * 例子2: POST
     *
     * @return
     */
    @POST("example/2")
    @FormUrlEncoded
    Observable<BaseResponse<ExampleBean>> example2(@FieldMap HashMap<String, Object> map);

    /**
     * 例子3: RequestBody
     *
     * @return
     */
    @POST("example/3")
    Observable<BaseResponse<ExampleBean>> example3(@Body RequestBody body);

    /**
     * 例子4: 文件上传
     *
     * @return
     */
    @POST("example/4")
    @Multipart
    Observable<BaseResponse<ExampleBean>> example4(@Part MultipartBody.Part file, @PartMap HashMap<String, Object> map);
}
