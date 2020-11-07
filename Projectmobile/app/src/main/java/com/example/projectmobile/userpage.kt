package com.example.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_shirtpage.*
import kotlinx.android.synthetic.main.activity_userpage.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class userpage : AppCompatActivity() {
    var shirtList = arrayListOf<shirtDB>()
    var mUname: String? = null
    var mUid: String? = null
    var mSername: String? = null
    var mPhone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userpage)

        mUid = intent.getStringExtra("mUid")
        mUname = intent.getStringExtra("mUname")
        mSername = intent.getStringExtra("mSername")
        mPhone = intent.getStringExtra("mPhone")
        unameText.setText(mUname)
        sernameText.setText(mSername)

        recycler_view.adapter = shirtAdapter(this.shirtList,applicationContext)
        recycler_view.layoutManager = GridLayoutManager(this,2)
        recycler_view.addItemDecoration(DividerItemDecoration(recycler_view.getContext(),DividerItemDecoration.VERTICAL))

    }


    override fun onResume() {
        super.onResume()
        callshirtdata() }

    fun callshirtdata(){
        shirtList.clear();
        val serv : tshirtAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(tshirtAPI ::class.java)

        serv.retrieveshirt()
            .enqueue(object : Callback<List<shirtDB>>{

                override fun onResponse(call: Call<List<shirtDB>>, response: Response<List<shirtDB>>) {
                    response.body()?.forEach{
                        shirtList.add(shirtDB(it.name_shirt,it.price,it.detail,it.img_shirt,mUname.toString(),mSername.toString(),mPhone.toString())) }
                    recycler_view.adapter = shirtAdapter(shirtList,applicationContext)
                }

                override fun onFailure(call: Call<List<shirtDB>>, t: Throwable) = t.printStackTrace()
            }) }

    fun home(item:MenuItem){
        val intent = Intent(this, userpage::class.java)
        intent.putExtra("mUid",mUid)
        intent.putExtra("mUname",mUname)
        intent.putExtra("mSername",mSername)
        intent.putExtra("mPhone",mPhone)
        startActivity(intent)
    }

    fun product(item:MenuItem){
        val intent = Intent(this, addproduct::class.java)
        intent.putExtra("mUid",mUid)
        intent.putExtra("mUname",mUname)
        intent.putExtra("mSername",mSername)
        intent.putExtra("mPhone",mPhone)
        startActivity(intent)
    }

    fun account(item:MenuItem){
        val intent = Intent(this, account::class.java)
        intent.putExtra("mUid",mUid)
        intent.putExtra("mUname",mUname)
        intent.putExtra("mSername",mSername)
        intent.putExtra("mPhone",mPhone)
        startActivity(intent)
    }



    }
