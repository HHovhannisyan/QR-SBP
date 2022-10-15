package ru.mertech.sbpskb.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OtherSettingsViewModel : ViewModel() {
    var mText: MutableLiveData<String> = MutableLiveData()

    init {
        mText.value = "Вход и безопасность"
    }

    fun getText(): LiveData<String> {
        return mText
    }
}