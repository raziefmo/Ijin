package com.adl.ijin.services

import com.adl.ijin.model.GetIjinRespon
import com.adl.ijin.model.ResponsePostData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ijin {
    @Headers("X-Api-Key:C1B5A29AB04F4C1C5AAE44AFF305ECA5")
    @GET("api/ijin/all")
    fun getAllIjin(): Call<GetIjinRespon>

    @FormUrlEncoded
    @Headers("X-Api-Key:C1B5A29AB04F4C1C5AAE44AFF305ECA5")
    @GET("api/ijin/all")
    fun addDataForm(@Field("kategori")kategori:String,@Field("dari")dari:String,
                    @Field("sampai")sampai:String,@Field("perihal")perihal:String,
                    @Field("keterangan")keterangan:String,
    )

    @Multipart
    @Headers("X-Api-Key:C1B5A29AB04F4C1C5AAE44AFF305ECA5")
    @POST("api/ijin/add")
    fun addDataAndImage(@Part("kategori") kategori: RequestBody, @Part("dari") dari:RequestBody,
                        @Part("sampai") sampai:RequestBody, @Part("perihal") perihal:RequestBody,
                        @Part("keterangan") keterangan:RequestBody,
                        @Part file: MultipartBody.Part):Call<ResponsePostData>


}
