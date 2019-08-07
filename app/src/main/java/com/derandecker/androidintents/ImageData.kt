package com.derandecker.androidintents

import android.net.Uri
import java.io.Serializable

class ImageData(imageUri: Uri) : Serializable {
    val imageUriString: String? = imageUri.toString()
    val imageUri = imageUri

    val name = "test"

}