package com.example.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_account2.*

class account : AppCompatActivity() {
        var mUname: String? = null
        var mUid: String? = null
        var mSername: String? = null
        var mPhone: String? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_account2)

            mUid = intent.getStringExtra("mUid")
            mUname = intent.getStringExtra("mUname")
            mSername = intent.getStringExtra("mSername")
            mPhone = intent.getStringExtra("mPhone")

            usr_name.setText(mUname)
            sure_name.setText(mSername)
            phone.setText(mPhone)
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

    fun logout(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
