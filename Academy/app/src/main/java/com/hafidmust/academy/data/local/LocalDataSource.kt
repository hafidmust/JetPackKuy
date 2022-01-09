package com.hafidmust.academy.data.local

import androidx.lifecycle.LiveData
import com.hafidmust.academy.data.CourseEntity
import com.hafidmust.academy.data.CourseWithModule
import com.hafidmust.academy.data.ModuleEntity
import com.hafidmust.academy.data.local.room.AcademyDao

class LocalDataSource private constructor(private val academyDao: AcademyDao){
    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(academyDao: AcademyDao) : LocalDataSource = INSTANCE ?: LocalDataSource(academyDao)
    }

    fun getAllCourse(): LiveData<List<CourseEntity>> = academyDao.getCourse()
    fun getBookmarkedCourse() : LiveData<List<CourseEntity>> = academyDao.getBookmarkedCourse()
    fun getCourseWithModules(courseId: String): LiveData<CourseWithModule> =
        academyDao.getCourseWithModuleById(courseId)

    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>> =
        academyDao.getModulesByCourseId(courseId)

    fun insertCourses(courses: List<CourseEntity>) = academyDao.insertCourses(courses)

    fun insertModules(modules: List<ModuleEntity>) = academyDao.insertModules(modules)

    fun setCourseBookmark(course: CourseEntity, newState: Boolean) {
        course.bookmarked = newState
        academyDao.updateCourse(course)
    }

    fun getModuleWithContent(moduleId: String): LiveData<ModuleEntity> =
        academyDao.getModuleById(moduleId)

    fun updateContent(content: String, moduleId: String) {
        academyDao.updateModuleByContent(content, moduleId)
    }

    fun setReadModule(module: ModuleEntity) {
        module.read = true
        academyDao.updateModule(module)
    }
}