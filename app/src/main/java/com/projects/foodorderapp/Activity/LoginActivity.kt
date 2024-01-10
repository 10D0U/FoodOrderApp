package com.projects.foodorderapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projects.foodorderapp.R
import com.projects.foodorderapp.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVariables()
    }

    private fun setVariables() {
        binding.loginButton.setOnClickListener {
            val email: String = binding.emailEditText.text.toString()
            val password: String = binding.passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) {
                        if (it.isSuccessful)
                            startActivity(Intent(this, MainActivity::class.java))
                        else
                            Toast.makeText(this, "Authentication Failed!", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Please fill email and password!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}