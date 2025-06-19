package com.kareemsobh.coffe_online.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kareemsobh.coffe_online.Domain.BannerModel
import com.kareemsobh.coffe_online.Domain.CategoryModel
import com.kareemsobh.coffe_online.Domain.ItemsModel
import com.kareemsobh.coffe_online.Repository.MainRespository

class MainViewModel: ViewModel() {
    private val respository = MainRespository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return respository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return respository.loadCategory()
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>> {
        return respository.loadPopular()
    }

    fun loadItems(categoryId: String): LiveData<MutableList<ItemsModel>> {
        return respository.loadItemCategory(categoryId)
    }
}