package com.zeynelerdi.app.security.applocker.di.module

import com.zeynelerdi.app.security.applocker.ui.callblocker.service.CallReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BroadcastReceiverBuilderModule {

    @ContributesAndroidInjector
    abstract fun callBroadcastReceiver(): CallReceiver

}