package com.example.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_addproduct.*
import kotlinx.android.synthetic.main.activity_registerpage.*
import kotlinx.android.synthetic.main.activity_registerpage.bt_reset
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class addproduct : AppCompatActivity() {
    var mUname: String? = null
    var mUid: String? = null
    var mSername: String? = null
    var mPhone: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addproduct)
        bt_reset.setOnClickListener() {
            name_product.text.clear()
            price.text.clear()
            detail.text.clear()
            url_img.text.clear()

        }
        mUid = intent.getStringExtra("mUid")
        mUname = intent.getStringExtra("mUname")
        mSername = intent.getStringExtra("mSername")
        mPhone = intent.getStringExtra("mPhone")
    }
    fun home(item: MenuItem) {
        val intent = Intent(this, userpage::class.java)
        intent.putExtra("mUid",mUid)
        intent.putExtra("mUname",mUname)
        intent.putExtra("mSername",mSername)
        intent.putExtra("mPhone",mPhone)
        startActivity(intent)
    }

    fun product(item: MenuItem) {
        val intent = Intent(this, addproduct::class.java)
        intent.putExtra("mUid",mUid)
        intent.putExtra("mUname",mUname)
        intent.putExtra("mSername",mSername)
        intent.putExtra("mPhone",mPhone)
        startActivity(intent)
    }

    fun account(item: MenuItem) {
        val intent = Intent(this, account::class.java)
        intent.putExtra("mUid", mUid)
        intent.putExtra("mUname", mUname)
        intent.putExtra("mSername", mSername)
        intent.putExtra("mPhone", mPhone)
        startActivity(intent)
    }
    fun addproduct(view: View){
        val intent = Intent(this, userpage::class.java)
        val serv : tshirtAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(tshirtAPI::class.java)

        serv.insertshirt(
            name_product.text.toString(),
            detail.text.toString(),
            price.text.toString(),
            url_img.text.toString(),
            mUid.toString()).enqueue(object : Callback<addshirtDB> {

            override fun onResponse(call: retrofit2.Call<addshirtDB>, response: retrofit2.Response<addshirtDB>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, "Successfully inserted", Toast.LENGTH_SHORT).show()
                    intent.putExtra("mUid",mUid)
                    intent.putExtra("mUname",mUname)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<addshirtDB>, t: Throwable) {
                Toast.makeText(applicationContext, "errrrr", Toast.LENGTH_LONG).show()

            }
        })
    }
}