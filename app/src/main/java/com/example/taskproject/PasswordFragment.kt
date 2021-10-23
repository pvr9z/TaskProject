package com.example.taskproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskproject.databinding.FragmentPasswordBinding
import com.example.taskproject.utils.GenerateOTP


class PasswordFragment : Fragment(R.layout.fragment_password) {

    private lateinit var binding: FragmentPasswordBinding
    private var getEnteredOtp: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPasswordBinding.bind(view)

        val otp = GenerateOTP.createFourDigitNumber()

        Toast.makeText(requireContext(), "Your OTP is : $otp", Toast.LENGTH_SHORT).show()


        /*  Library class is not providing the interface to get pin, need to revisit

         binding.pinEntrySimple.setOnPinEnteredListener(object : OnPinEnteredListener() {
              fun onPinEntered(pin: String) {
                  getEnteredOtp = pin
              }
          })
          binding.verifyButton.setOnClickListener {
              if (getEnteredOtp.equals(otp)) {
                  findNavController().navigate(R.id.action_passwordFragment_to_homeFragment)
              } else Toast.makeText(requireContext(), "Invalid OTP", Toast.LENGTH_SHORT).show()
          }*/

        binding.verifyButton.setOnClickListener {
            findNavController().navigate(R.id.action_passwordFragment_to_homeFragment)
        }
    }
}