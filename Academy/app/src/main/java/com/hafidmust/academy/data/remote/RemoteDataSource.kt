package com.hafidmust.academy.data.remote

import android.os.Handler
import android.os.Looper
import com.hafidmust.academy.data.source.response.ContentResponse
import com.hafidmust.academy.data.source.response.CourseResponse
import com.hafidmust.academy.data.source.response.ModuleResponse
import com.hafidmust.academy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper : JsonHelper){

    private val handler = Handler(Looper.getMainLooper())
    companion object{
        private const val SERVICE_LATENCY_IN_MILLIS : Long = 2000
        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(helper: JsonHelper) : RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }

    }
    fun getAllCourses(callback : LoadCoursesCallback) {
        handler.postDelayed({callback.onAllCoursesReceived(jsonHelper.loadCourse())}, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getModules(courseId : String, callback : LoadModulesCallback) {
        handler.postDelayed({callback.onAllModulesReceived(jsonHelper.loadModule(courseId))}, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getContent(moduleId : String, callback : LoadContentCallback) {
        handler.postDelayed({callback.onContentReceived(jsonHelper.loadContent(moduleId))}, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadCoursesCallback{
        fun onAllCoursesReceived(courseResponses: List<CourseResponse>)
    }

    interface LoadModulesCallback{
        fun onAllModulesReceived(moduleResponses : List<ModuleResponse>)
    }

    interface LoadContentCallback{
        fun onContentReceived(contentResponse : ContentResponse)
    }
}