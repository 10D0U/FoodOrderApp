package com.projects.foodorderapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.projects.foodorderapp.R
import com.projects.foodorderapp.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVariable()
    }

    private fun setVariable() {
        binding.loginButton.setOnClickListener {  }

        binding.registerButton.setOnClickListener {  }
    }
}