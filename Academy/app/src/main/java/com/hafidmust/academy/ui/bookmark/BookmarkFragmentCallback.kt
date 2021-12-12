package com.hafidmust.academy.ui.bookmark

import com.hafidmust.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course : CourseEntity)
}
