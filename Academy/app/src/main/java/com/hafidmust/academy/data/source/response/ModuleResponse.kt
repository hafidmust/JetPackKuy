package com.hafidmust.academy.data.source.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModuleResponse(
    var moduleId : String,
    var courseId: String,
    var title: String,
    var position: Int
) : Parcelable
