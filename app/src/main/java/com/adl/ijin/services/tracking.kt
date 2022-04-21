package com.adl.ijin.services

import com.adl.ijin.model.ResponsePostData
import retrofit2.Call
import retrofit2.http.*

interface tracking {



    @FormUrlEncoded
    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @POST("api/tracking/add")
    fun addDataForm(@Field("id_user") id_user:String,@Field("latitude") latitude:String,
                    @Field("longitude") longitude:String,@Field("timestamp") time:String): Call<ResponsePostData>




}