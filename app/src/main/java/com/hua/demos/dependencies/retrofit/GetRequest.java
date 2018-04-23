package com.hua.demos.dependencies.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetRequest {

    // title=&smode=&pagesize=&offset=&dtype=&key=1cf516750242a0d14278404dca735df4
    @GET("movie/index")
    Call<Movie> getCall(@Query("key") String key,@Query("title") String title,@Query("smode") String smode,
                        @Query("pagesize") String pagesize,@Query("offset") String offset,@Query("dtype") String dtype);
    // 注解里传入 网络请求 的部分URL地址
    // Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
    // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
    // getCall()是接受网络请求数据的方法


}
