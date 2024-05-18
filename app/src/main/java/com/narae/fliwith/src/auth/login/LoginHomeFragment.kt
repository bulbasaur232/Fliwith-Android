package com.narae.fliwith.src.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.narae.fliwith.R
import com.narae.fliwith.config.BaseFragment
import com.narae.fliwith.databinding.FragmentLoginBinding
import com.narae.fliwith.databinding.FragmentLoginHomeBinding

class LoginHomeFragment :
    BaseFragment<FragmentLoginHomeBinding>(FragmentLoginHomeBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()


    }

    private fun setListeners() {
        // 카카오
        binding.btnsignUpKakaotalk.setOnClickListener {
            TODO("카카오 소셜 로그인")
        }

        // 회원가입
        binding.btnsignUpEmail.setOnClickListener {
            navController.navigate(R.id.action_loginHomeFragment_to_createAccountFragment)
        }

        // 로그인
        binding.btnLogin.setOnClickListener {
            navController.navigate(R.id.action_loginHomeFragment_to_loginFragment)
        }
    }

}