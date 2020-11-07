package com.example.projectmobile

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface tshirtAPI {
    @GET("allshirt")
    fun retrieveshirt(): Call<List<shirtDB>>

    companion object{
        fun create(): tshirtAPI{
            val shirtClient : tshirtAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(tshirtAPI ::class.java)
            return shirtClient
        }
    }

    @DELETE("delete/{img_shirt}")
    fun deleteshirt(
        @Path("img_shirt") img_shirt:String): Call<shirtDB>

    @FormUrlEncoded
    @POST("/addshirt")
    fun insertshirt(
        @Field("name_shirt") name_shirt:String,
        @Field("detail") detail:String,
        @Field("price") price:String,
        @Field("img_shirt") img_shirt:String,
        @Field("usr_id") usr_id:String):retrofit2.Call<addshirtDB>
}