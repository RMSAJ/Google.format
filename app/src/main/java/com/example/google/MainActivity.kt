package com.example.google

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.google.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signIn.setOnClickListener {

            Intent(this, MainActivity2::class.java)
            startActivity(MainActivity2().intent)
            Toast.makeText(this, " you clicked", Toast.LENGTH_SHORT).show()
        }
        binding.checkShowpassword.setOnClickListener {
            if (binding.checkShowpassword.isChecked){  binding.password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.repassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.checkShowpassword.text = "Hide"
            }else {binding.password.transformationMethod = PasswordTransformationMethod.getInstance()
                    binding.repassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    binding.checkShowpassword.text = "show"
            }
        }
        binding.nextButton.setOnClickListener {
            letTry()
        }
    }

fun letTry() {
    val name = binding.firstNameEditText.text.toString()
//    val email = binding.userName.text.toString()
    val pass1 = binding.password.text
    val pass2 = binding.repassword.text
    val showPass = binding.checkShowpassword.isChecked
//    var passCondetion = binding.passConditions.text

    val anser = if (showPass == true && pass1 == pass2 ) {"here is your pass ${pass1}"}
                    else " I dare you to sign in "



    binding.careateAccountView.text = when (name) {

        "" -> "whyyy"
       binding.lasttName.text.toString() -> " they shouldnt be the same"
       else -> "great job "
    }

    binding.passConditions.text = anser


}


}