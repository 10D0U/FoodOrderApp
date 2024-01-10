package com.projects.foodorderapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.projects.foodorderapp.R
import com.projects.foodorderapp.databinding.ActivitySignupBinding

class SignupActivity : BaseActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVariable()
    }

    private fun setVariable() {
        binding.signupButton.setOnClickListener {
            val email: String = binding.emailEditText.text.toString()
            val password: String = binding.passwordEditText.text.toString()

            if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isComplete) {
                        Log.i(TAG, "onComplete: ")
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Log.i(TAG, "Failure: ${it.exception}")
                        Toast.makeText(this, "Authentication Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}