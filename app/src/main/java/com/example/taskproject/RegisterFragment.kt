package com.example.taskproject

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskproject.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        val countryCodes = resources.getStringArray(R.array.country_codes)
        binding.otpButton.apply {
            text = getString(R.string.otp_button_text)
            setOnClickListener {
                if (binding.phoneNumber.text.length == 10) {
                    findNavController().navigate(R.id.action_registerFragment_to_passwordFragment)
                } else Toast.makeText(requireContext(), " Invalid Mobile number", Toast.LENGTH_LONG)
                    .show()
            }
        }
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item, countryCodes)
        binding.countryCode.setAdapter(arrayAdapter)
    }

}