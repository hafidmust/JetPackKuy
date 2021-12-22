package com.hafidmust.academy.data.remote

import com.hafidmust.academy.data.source.response.ContentResponse
import com.hafidmust.academy.data.source.response.CourseResponse
import com.hafidmust.academy.data.source.response.ModuleResponse
import com.hafidmust.academy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper : JsonHelper){
    companion object{
        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(helper: JsonHelper) : RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }

    }
    fun getAllCourses() : List<CourseResponse> = jsonHelper.loadCourse()

    fun getModules(courseId : String) : List<ModuleResponse> = jsonHelper.loadModule(courseId)

    fun getContent(moduleId : String) : ContentResponse = jsonHelper.loadContent(moduleId)
}