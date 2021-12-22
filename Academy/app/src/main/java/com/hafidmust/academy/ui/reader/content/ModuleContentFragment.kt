package com.hafidmust.academy.ui.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hafidmust.academy.data.ModuleEntity
import com.hafidmust.academy.databinding.FragmentModuleContentBinding
import com.hafidmust.academy.ui.reader.CourseReaderViewModel
import com.hafidmust.academy.viewmodel.ViewModelFactory


class ModuleContentFragment : Fragment() {

    companion object{
        val TAG : String = ModuleContentFragment::class.java.simpleName
        fun newInstance() : ModuleContentFragment = ModuleContentFragment()
    }

    private lateinit var fragmentModuleContentBinding: FragmentModuleContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentModuleContentBinding = FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), factory)[CourseReaderViewModel::class.java]
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }
    }

    private fun populateWebView(content: ModuleEntity) {
        fragmentModuleContentBinding.webView.loadData(content.contentEntity?.content ?: "","text/html","UTF-8")
    }
}
