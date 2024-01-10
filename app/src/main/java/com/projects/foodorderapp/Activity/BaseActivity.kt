package com.projects.foodorderapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.projects.foodorderapp.R

open class BaseActivity : AppCompatActivity() {
    protected lateinit var auth: FirebaseAuth
    protected lateinit var database: FirebaseDatabase
    public val TAG: String = "FOODORDER"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

    }
}