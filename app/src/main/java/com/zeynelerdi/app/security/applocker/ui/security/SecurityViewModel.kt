package com.zeynelerdi.app.security.applocker.ui.security

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zeynelerdi.app.security.applocker.data.AppDataProvider
import com.zeynelerdi.app.security.applocker.data.database.lockedapps.LockedAppEntity
import com.zeynelerdi.app.security.applocker.data.database.lockedapps.LockedAppsDao
import com.zeynelerdi.app.security.applocker.ui.RxAwareViewModel
import com.zeynelerdi.app.security.applocker.ui.security.function.AddSectionHeaderViewStateFunction
import com.zeynelerdi.app.security.applocker.ui.security.function.LockedAppListViewStateCreator
import com.zeynelerdi.app.security.applocker.util.extensions.doOnBackground
import com.zeynelerdi.app.security.applocker.util.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SecurityViewModel @Inject constructor(
    appDataProvider: AppDataProvider,
    val lockedAppsDao: LockedAppsDao
) : RxAwareViewModel() {

    private val appDataViewStateListLiveData = MutableLiveData<List<AppLockItemBaseViewState>>()

    init {
        val installedAppsObservable = appDataProvider.fetchInstalledAppList().toObservable()
        val lockedAppsObservable = lockedAppsDao.getLockedApps().toObservable()

        disposables += LockedAppListViewStateCreator.create(installedAppsObservable, lockedAppsObservable)
            .map(AddSectionHeaderViewStateFunction())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                appDataViewStateListLiveData.value = it
            }
    }

    fun getAppDataListLiveData(): LiveData<List<AppLockItemBaseViewState>> = appDataViewStateListLiveData

    fun lockApp(appLockItemViewState: AppLockItemItemViewState) {
        disposables += doOnBackground {
            lockedAppsDao.lockApp(
                LockedAppEntity(
                    appLockItemViewState.appData.packageName
                )
            )
        }
    }

    fun unlockApp(appLockItemViewState: AppLockItemItemViewState) {
        disposables += doOnBackground {
            lockedAppsDao.unlockApp(appLockItemViewState.appData.packageName)
        }
    }
}