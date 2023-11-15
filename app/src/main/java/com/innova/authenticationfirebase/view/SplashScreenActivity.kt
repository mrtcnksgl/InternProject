package com.innova.authenticationfirebase.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.imageview.ShapeableImageView
import com.innova.authenticationfirebase.R
import com.innova.authenticationfirebase.login.LoginActivity
import com.innova.authenticationfirebase.login.LoginViewModel
import com.innova.authenticationfirebase.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logo: ShapeableImageView = findViewById(R.id.splashLogo)
        val background: ConstraintLayout = findViewById(R.id.splashScreenLayout)

        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)
        val backgroundAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_background)

        logo.startAnimation(slideAnimation)
        background.startAnimation(backgroundAnimation)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        Handler().postDelayed({
            // Bu blok, belirtilen süre (ms cinsinden) sonra çalışacaktır
            checkRememberMeAndRedirect()
        }, 5000)

    }

    private fun checkRememberMeAndRedirect() {
        viewModel.checkUserLoggedInAndRememberMe().observe(this) { (isLoggedIn, rememberMeChecked) ->
            if (isLoggedIn || rememberMeChecked) {
                // Kullanıcı daha önce giriş yapmış veya "Remember Me" işaretliyse, ana sayfaya yönlendir
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Kullanıcı daha önce giriş yapmamış ve "Remember Me" işaretsizse, giriş ekranına yönlendir
                if (viewModel.isFirstRun) {
                    // Eğer ilk çalıştırma ise giriş ekranına git
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    // Eğer ilk çalıştırma değilse ana sayfaya git
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            finish()
        }
    }

}
