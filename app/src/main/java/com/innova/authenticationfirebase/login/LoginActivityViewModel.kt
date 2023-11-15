package com.innova.authenticationfirebase.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val loginSuccess = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val rememberMeChecked = MutableLiveData<Boolean>()

    var isFirstRun = false

    fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Giriş başarılı
                    loginSuccess.value = true
                } else {
                    // Giriş başarısız
                    errorMessage.value = task.exception?.message ?: "Bir hata oluştu."
                }
            }
    }

    fun checkUserLoggedInAndRememberMe(): LiveData<Pair<Boolean, Boolean>> {
        val user = auth.currentUser
        val rememberMe = rememberMeChecked.value ?: false
        val isLoggedIn = user != null

        return MutableLiveData<Pair<Boolean, Boolean>>().apply {
            value = Pair(isLoggedIn, rememberMe)
        }
    }
}
