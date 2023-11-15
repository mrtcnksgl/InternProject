package com.innova.authenticationfirebase.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.innova.authenticationfirebase.R
import com.innova.authenticationfirebase.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var rememberMeCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val loginButton = findViewById<Button>(R.id.loginButton)
        val loginEmailLayout = findViewById<TextInputLayout>(R.id.loginEmailLayout)
        val loginPasswordLayout = findViewById<TextInputLayout>(R.id.loginPasswordLayout)

        rememberMeCheckBox = findViewById(R.id.loginRememberMeCheckBox)
        rememberMeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.rememberMeChecked.value = isChecked
        }

        loginButton.setOnClickListener {
            val email = loginEmailLayout.editText?.text.toString()
            val password = loginPasswordLayout.editText?.text.toString()

            // ViewModel üzerinden giriş işlemi yapılıyor
            viewModel.signInWithEmailAndPassword(email, password)
        }

        // ViewModel'den gelen sonuçları izle
        viewModel.loginSuccess.observe(this) { success ->
            if (success) {
                // Giriş başarılı, ana sayfaya yönlendir
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        viewModel.errorMessage.observe(this) { message ->
            // Giriş başarısız, hatayı göster
            Toast.makeText(baseContext, "Giriş başarısız: $message", Toast.LENGTH_SHORT).show()
        }
    }
}
