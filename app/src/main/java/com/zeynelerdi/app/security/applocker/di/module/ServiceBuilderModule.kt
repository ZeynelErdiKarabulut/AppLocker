package com.zeynelerdi.app.security.applocker.di.module

import com.zeynelerdi.app.security.applocker.service.AppLockerService
import com.zeynelerdi.app.security.applocker.ui.callblocker.service.CallBlockerScreeningService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilderModule {

    @ContributesAndroidInjector
    abstract fun appLockerService(): AppLockerService

    @ContributesAndroidInjector
    abstract fun callBlockerService(): CallBlockerScreeningService
}