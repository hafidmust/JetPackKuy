package com.hafidmust.academy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.hafidmust.academy.data.CourseEntity
import com.hafidmust.academy.data.CourseWithModule
import com.hafidmust.academy.data.ModuleEntity
import com.hafidmust.academy.data.source.AcademyRepository
import com.hafidmust.academy.utils.DataDummy
import com.hafidmust.academy.vo.Resource

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    val courseId = MutableLiveData<String>()

    fun setSelectedCourse(courseId : String){
        this.courseId.value = courseId
    }

    var courseModule : LiveData<Resource<CourseWithModule>> = Transformations.switchMap(courseId){mCourseId ->
        academyRepository.getCourseWithModules(mCourseId)
    }

    fun setBookmark(){
        val moduleResource = courseModule.value
        if (moduleResource != null){
            val courseWithModule = moduleResource.data
            if (courseWithModule != null){
                val courseEntity = courseWithModule.mCourse
                val newState = !courseEntity.bookmarked
                academyRepository.setCourseBookmark(courseEntity, newState)
            }
        }
    }

//    fun getCourse() : LiveData<CourseEntity> = academyRepository.getCourseWithModules(courseId)
//
//    fun getModules() : LiveData<List<ModuleEntity>> = academyRepository.getAllModulesByCourse(courseId)
}