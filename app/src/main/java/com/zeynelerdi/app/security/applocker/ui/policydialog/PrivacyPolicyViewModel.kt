package com.zeynelerdi.app.security.applocker.ui.policydialog

import com.zeynelerdi.app.security.applocker.data.AppLockerPreferences
import com.zeynelerdi.app.security.applocker.ui.RxAwareViewModel
import javax.inject.Inject

class PrivacyPolicyViewModel @Inject constructor(val appLockerPreferences: AppLockerPreferences) : RxAwareViewModel() {

    fun acceptPrivacyPolicy() {
        appLockerPreferences.acceptPrivacyPolicy()
    }

}