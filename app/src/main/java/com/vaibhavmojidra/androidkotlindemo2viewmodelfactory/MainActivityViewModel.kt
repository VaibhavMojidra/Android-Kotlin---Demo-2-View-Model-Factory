package com.vaibhavmojidra.androidkotlindemo2viewmodelfactory

import androidx.lifecycle.ViewModel

class MainActivityViewModel(defaultName:String): ViewModel() {
    private var name=""

    init {
        name=defaultName
    }

    fun getName()=name

    fun setName(name:String){
        this.name=name
    }

    fun greetWithName()="Hello $name"


}