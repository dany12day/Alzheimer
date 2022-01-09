package com.example.alzheimer.Documents

import android.net.Uri
import java.io.Serializable

class DocumentModel(
    var title: String,
    var imageUri: Uri
        ) : Serializable