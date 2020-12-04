package com.zeynelerdi.app.security.applocker.util.encryptor

import com.zeynelerdi.app.security.applocker.util.helper.file.DirectoryType
import com.zeynelerdi.app.security.applocker.util.helper.file.FileExtension

data class EncryptFileOperationRequest(
    val fileName: String,
    val fileExtension: FileExtension,
    val directoryType: DirectoryType
)