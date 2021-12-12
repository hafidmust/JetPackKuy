package com.hafidmust.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hafidmust.academy.R
import com.hafidmust.academy.data.CourseEntity
import com.hafidmust.academy.databinding.ActivityDetailCourseBinding
import com.hafidmust.academy.databinding.ContentDetailCourseBinding
import com.hafidmust.academy.ui.reader.CourseReaderActivity
import com.hafidmust.academy.utils.DataDummy

class DetailCourseActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var binding: ContentDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)

        binding = activityDetailCourseBinding.detailContent
        setContentView(binding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailCourseAdapter()
        val extras = intent.extras
        if(extras != null){
            val courseId = extras.getString(EXTRA_COURSE)
            if (courseId!= null){
                val modules = DataDummy.generateDummyModules(courseId)
                adapter.setModules(modules)
                for (course in DataDummy.generateDummyCouse()){
                    if (course.courseId == courseId){
                        populateCourse(course)
                    }
                }
            }
        }
        with(binding.rvModule){
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }


    }

    private fun populateCourse(courseEntity: CourseEntity) {
        binding.textTitle.text = courseEntity.title
        binding.textDescription.text = courseEntity.description
        binding.textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

        Glide.with(this)
            .load(courseEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(binding.imagePoster)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            startActivity(intent)
        }
    }
}