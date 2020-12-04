package com.zeynelerdi.app.security.applocker.di.component

import com.zeynelerdi.app.security.applocker.di.module.ActivityBuilderModule
import com.zeynelerdi.app.security.applocker.di.module.AppModule
import com.zeynelerdi.app.security.applocker.AppLockerApplication
import com.zeynelerdi.app.security.applocker.data.database.DatabaseModule
import com.zeynelerdi.app.security.applocker.di.module.BroadcastReceiverBuilderModule
import com.zeynelerdi.app.security.applocker.di.module.ServiceBuilderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ServiceBuilderModule::class,
        BroadcastReceiverBuilderModule::class,
        AppModule::class,
        DatabaseModule::class]
)
interface AppComponent : AndroidInjector<AppLockerApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppLockerApplication>()
}