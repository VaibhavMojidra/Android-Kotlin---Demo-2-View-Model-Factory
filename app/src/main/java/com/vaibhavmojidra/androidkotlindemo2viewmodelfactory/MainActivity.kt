package com.vaibhavmojidra.androidkotlindemo2viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.vaibhavmojidra.androidkotlindemo2viewmodelfactory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private  lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory= MainActivityViewModelFactory("User")
        mainActivityViewModel=ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)
        binding.nameEditTextText.setText(mainActivityViewModel.getName())
        binding.messageTextView.text=mainActivityViewModel.greetWithName()

        binding.nameEditTextText.addTextChangedListener {
            mainActivityViewModel.setName(binding.nameEditTextText.text.toString())
        }

        binding.showMessageBtn.setOnClickListener {
            binding.messageTextView.text=mainActivityViewModel.greetWithName()
        }
    }
}