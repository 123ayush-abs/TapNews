package com.example.mynews;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiutility {
    private static Retrofit retrofit=null;
    public static APIinterface getAPI()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(APIinterface.baseurl).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIinterface.class);
    }

}
