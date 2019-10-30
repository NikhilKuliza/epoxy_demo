package com.example.epoxydemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.epoxydemo.model.HomeModel
import com.example.epoxydemo.repositories.HomeRepository

class HomeScreenViewModel(private val homeRepo : HomeRepository) : ViewModel() {




    lateinit var homeData: MutableLiveData<List<HomeModel>>

    fun getHomeLiveData() {
        homeData = MutableLiveData();
        homeData.value = homeRepo.getHomeData()
    }


    class HomeScreenViewModelFactory(
        private val homeRepo: HomeRepository
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeScreenViewModel( homeRepo ) as T
        }
    }

}