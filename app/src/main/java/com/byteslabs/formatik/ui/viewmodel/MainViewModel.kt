package com.byteslabs.formatik.ui.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.byteslabs.formatik.utils.Tools

class MainViewModel : ObservableViewModel() {
    val areInputsReady = MediatorLiveData<Boolean>()

    val email = MutableLiveData("")

    val password = MutableLiveData("")

    init {
        areInputsReady.addSource(email) { areInputsReady.value = checkInputs() }
        areInputsReady.addSource(password) { areInputsReady.value = checkInputs() }
    }


    private fun checkInputs(): Boolean {
        return (Tools.isEmailValid(email.value.toString().trim()) &&
                Tools.isLenthValid(password.value.toString().trim()))
    }

    // This functions are not necessary. the logic of sign up that will be performed
    // can directly use the email and password from the viewmodel because they are safe

    fun getEmail() = email.value
    fun getPassword() = password.value


}