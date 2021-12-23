package com.hafidmust.academy.data.source

import com.hafidmust.academy.data.remote.RemoteDataSource
import com.hafidmust.academy.data.source.response.ContentResponse
import com.hafidmust.academy.data.source.response.CourseResponse
import com.hafidmust.academy.data.source.response.ModuleResponse
import com.hafidmust.academy.utils.DataDummy
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class AcademyRepositoryTest{
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepository = FakeAcademyRepository(remote)

    private val courseResponses = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponses[0].id
    private val moduleResponses = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponses[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourses(){
        Mockito.`when`(remote.getAllCourses()).thenReturn(courseResponses)
        val courseEntites = academyRepository.getAllCourses()
        Mockito.verify(remote).getAllCourses()
        assertNotNull(courseEntites)
        assertEquals(courseResponses.size.toLong(), courseEntites.size.toLong())
    }

    @Test
    fun getAllModulesByCourse() {
        `when`<List<ModuleResponse>>(remote.getModules(courseId)).thenReturn(moduleResponses)
        val moduleEntities = academyRepository.getAllModulesByCourse(courseId)
        verify<RemoteDataSource>(remote).getModules(courseId)
        assertNotNull(moduleEntities)
        assertEquals(moduleResponses.size.toLong(), moduleEntities.size.toLong())
    }

    @Test
    fun getBookmarkedCourses() {
        `when`<List<CourseResponse>>(remote.getAllCourses()).thenReturn(courseResponses)
        val courseEntities = academyRepository.getBookmarkedCourses()
        verify<RemoteDataSource>(remote).getAllCourses()
        assertNotNull(courseEntities)
        assertEquals(courseResponses.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getContent() {
        `when`<List<ModuleResponse>>(remote.getModules(courseId)).thenReturn(moduleResponses)
        `when`<ContentResponse>(remote.getContent(moduleId)).thenReturn(content)
        val resultModule = academyRepository.getContent(courseId, moduleId)
        verify<RemoteDataSource>(remote).getContent(moduleId)
        assertNotNull(resultModule)
        assertEquals(content.content, resultModule.contentEntity?.content)
    }

    @Test
    fun getCourseWithModules() {
        `when`<List<CourseResponse>>(remote.getAllCourses()).thenReturn(courseResponses)
        val resultCourse = academyRepository.getCourseWithModules(courseId)
        verify<RemoteDataSource>(remote).getAllCourses()
        assertNotNull(resultCourse)
        assertEquals(courseResponses[0].title, resultCourse.title)
    }
}