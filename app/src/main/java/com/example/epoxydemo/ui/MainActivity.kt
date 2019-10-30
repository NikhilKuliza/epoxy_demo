package com.example.epoxydemo.ui

import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.epoxydemo.R
import com.example.epoxydemo.repositories.HomeRepository
import com.example.epoxydemo.ui.controller.HomeDataController
import com.example.epoxydemo.viewmodels.HomeScreenViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    private lateinit var viewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = HomeScreenViewModel.HomeScreenViewModelFactory(HomeRepository())
        viewModel = ViewModelProviders.of(this, factory).get(HomeScreenViewModel::class.java)
        viewModel.getHomeLiveData()
        initView()
    }


    private fun initView() {
        val controller : HomeDataController = HomeDataController(this)
        epoxy_recycler_view.setController(controller)
        controller.setData(listOf())

        viewModel.homeData.observe(this, Observer {
            controller.setData(it)
        })

    }
}
