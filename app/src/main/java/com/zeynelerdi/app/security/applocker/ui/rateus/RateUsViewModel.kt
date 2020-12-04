package com.zeynelerdi.app.security.applocker.ui.rateus

import com.zeynelerdi.app.security.applocker.repository.UserPreferencesRepository
import com.zeynelerdi.app.security.applocker.ui.RxAwareViewModel
import javax.inject.Inject

class RateUsViewModel @Inject constructor(val userPreferencesRepository: UserPreferencesRepository) :
    RxAwareViewModel() {

    fun setUserRateUs() = userPreferencesRepository.setUserRateUs()
}