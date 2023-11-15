package com.innova.authenticationfirebase.home_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.innova.authenticationfirebase.R
import com.innova.authenticationfirebase.databinding.FragmentHomeBinding
import com.innova.authenticationfirebase.maps.MapsActivity
import com.innova.authenticationfirebase.view.BillDetailsFragment

class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // ViewModel'den verileri gözlemle
        viewModel.navigateToBillDetails.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                // BillDetailsFragment'a geçiş yap
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, BillDetailsFragment())
                    .addToBackStack(null) // Geri tuşu ile geri dönülebilmesi için
                    .commit()

                // Geçiş tamamlandığında ViewModel'deki işareti sıfırla
                viewModel.onNavigationComplete()
            }
        }

        // BillButton tıklama işlemi
        binding.billButton.setOnClickListener {
            viewModel.onBillButtonClick()
        }

        // MapsButton tıklama işlemi
        binding.addressButton.setOnClickListener {
            viewModel.onMapsButtonClick()
        }

        // FragmentHome içinde iDriveButton'a tıklama işlemi
        binding.iDriveButton.setOnClickListener {
            val url = "https://idrive.innova.com.tr/index.php/login"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // ViewModel'den MapsActivity geçişini gözlemle
        viewModel.navigateToMaps.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                // MapsActivity'ye geçiş yap
                val intent = Intent(requireContext(), MapsActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }
}
