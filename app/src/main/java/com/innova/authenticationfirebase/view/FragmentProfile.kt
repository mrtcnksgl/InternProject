package com.innova.authenticationfirebase.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.innova.authenticationfirebase.R
import com.innova.authenticationfirebase.login.LoginActivity

class FragmentProfile : Fragment() {

    private lateinit var signOutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        signOutButton = view.findViewById(R.id.signOutButton)

        signOutButton.setOnClickListener {
            // Oturumu kapat
            FirebaseAuth.getInstance().signOut()

            // Login ekranına yönlendir
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }
}
