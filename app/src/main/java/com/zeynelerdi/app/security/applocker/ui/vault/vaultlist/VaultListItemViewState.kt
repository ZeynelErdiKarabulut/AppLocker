package com.zeynelerdi.app.security.applocker.ui.vault.vaultlist

import com.zeynelerdi.app.security.applocker.data.database.vault.VaultMediaEntity

data class VaultListItemViewState(val vaultMediaEntity: VaultMediaEntity) {

    fun getDecryptedCachePath() = vaultMediaEntity.decryptedPreviewCachePath
}