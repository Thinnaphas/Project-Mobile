package com.example.projectmobile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class addshirtDB (
    @Expose
@SerializedName("name_shirt") val name_shirt: String,

@Expose
@SerializedName("detail") val detail: String,

    @Expose
    @SerializedName("price") val price: String,

@Expose
@SerializedName("img_shirt") val img_shirt: String,

@Expose
@SerializedName("id_usr") val id_usr: String){}