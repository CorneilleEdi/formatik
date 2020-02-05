package com.byteslabs.formatik.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.byteslabs.formatik.R
import com.byteslabs.formatik.databinding.ActivityMainBinding
import com.byteslabs.formatik.ui.viewmodel.MainViewModel
import com.byteslabs.formatik.utils.hideKeyboard
import com.byteslabs.formatik.utils.toast

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            viewModel = mainViewModel
            lifecycleOwner = this@MainActivity
        }

        binding.handler = object : MainActivityHandler {
            override fun onSignUp() {
                binding.root.hideKeyboard()
                // At this point you can be sure that the email is not null and is a valid email
                toast("${mainViewModel.getEmail()}")
            }
        }

    }

    interface MainActivityHandler {
        fun onSignUp()
    }
}
