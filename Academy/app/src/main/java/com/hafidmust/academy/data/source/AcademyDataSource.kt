package com.hafidmust.academy.data.source

import androidx.lifecycle.LiveData
import com.hafidmust.academy.data.CourseEntity
import com.hafidmust.academy.data.CourseWithModule
import com.hafidmust.academy.data.ModuleEntity
import com.hafidmust.academy.vo.Resource

interface AcademyDataSource {
    fun getAllCourses() : LiveData<Resource<List<CourseEntity>>>

    fun getBookmarkedCourses() : LiveData<List<CourseEntity>>

    fun getCourseWithModules(courseId : String) : LiveData<Resource<CourseWithModule>>

    fun getAllModulesByCourse(courseId : String) : LiveData<Resource<List<ModuleEntity>>>

    fun getContent(moduleId : String) : LiveData<Resource<ModuleEntity>>

    fun setCourseBookmark(course: CourseEntity, state: Boolean)

    fun setReadModule(module: ModuleEntity)

}