package com.hafidmust.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
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
import com.hafidmust.academy.viewmodel.ViewModelFactory
import com.hafidmust.academy.vo.Status

class DetailCourseActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var activityDetailCourseBinding: ActivityDetailCourseBinding
    private lateinit var viewModel : DetailCourseViewModel
    private var menu: Menu? = null
    private lateinit var detailContentBinding: ContentDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailCourseViewModel::class.java]

        val adapter = DetailCourseAdapter()

        val extras = intent.extras
        if (extras != null) {
            val courseId = extras.getString(EXTRA_COURSE)
            if (courseId != null) {
                viewModel.setSelectedCourse(courseId)
                viewModel.courseModule.observe(this,{courseWithModuleResources ->
                    if (courseWithModuleResources != null){
                        when(courseWithModuleResources.status){
                            Status.LOADING -> activityDetailCourseBinding.progressBarDetail.visibility = View.VISIBLE
                            Status.SUCCESS ->{
                                if (courseWithModuleResources.data != null){
                                    activityDetailCourseBinding.progressBarDetail.visibility = View.GONE
                                    activityDetailCourseBinding.content.visibility = View.VISIBLE
                                    adapter.setModules(courseWithModuleResources.data.mModules)
                                    adapter.notifyDataSetChanged()
                                    populateCourse(courseWithModuleResources.data.mCourse)
                                }
                            }
                            Status.ERROR -> {
                                activityDetailCourseBinding.progressBarDetail.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.courseModule.observe(this, {courseWithModule->
            if (courseWithModule != null){
                when(courseWithModule.status){
                    Status.LOADING -> activityDetailCourseBinding.progressBarDetail.visibility = View.VISIBLE
                    Status.SUCCESS -> if (courseWithModule.data != null){
                        activityDetailCourseBinding.progressBarDetail.visibility = View.GONE
                        val state = courseWithModule.data.mCourse.bookmarked
                        setBookmarkState(state)
                    }
                    Status.ERROR ->{
                        activityDetailCourseBinding.progressBarDetail.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark){
            viewModel.setBookmark()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state : Boolean){
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state){
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white)
        }else{
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        detailContentBinding.textTitle.text = courseEntity.title
        detailContentBinding.textDescription.text = courseEntity.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

        Glide.with(this)
            .load(courseEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStart.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            startActivity(intent)
        }
    }
}