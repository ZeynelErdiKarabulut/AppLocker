package com.zeynelerdi.app.security.applocker.ui.vault

import com.zeynelerdi.app.security.applocker.repository.UserPreferencesRepository
import com.zeynelerdi.app.security.applocker.ui.RxAwareViewModel
import javax.inject.Inject

class VaultViewModel @Inject constructor(val userPreferencesRepository: UserPreferencesRepository) : RxAwareViewModel() {

    fun shouldShowRateUs(): Boolean {
        return userPreferencesRepository.isUserRateUs().not()
    }

    fun setRateUsAsked() {
        userPreferencesRepository.setRateUsAsked()
    }
}