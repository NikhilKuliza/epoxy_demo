package com.example.epoxydemo.ui.controller

import android.content.Context
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.TypedEpoxyController
import com.example.epoxydemo.CarouselCardItemLayoutBindingModel_
import com.example.epoxydemo.imageDescriptionCardLayout
import com.example.epoxydemo.imagesCardLayout
import com.example.epoxydemo.model.HomeModel
import com.example.epoxydemo.model.SequenceType
import com.example.epoxydemo.singleDescriptionCardLayout


class HomeDataController(var context: Context) : TypedEpoxyController<List<HomeModel>>() {
    var dummyId: Int = 101;

    override fun buildModels(data: List<HomeModel>?) {

        data?.forEach { homeModel ->

            when (homeModel.sequenceType) {

                SequenceType.TYPE1 -> {

                    CarouselModel_().apply {
                        ++dummyId
                        id("Carosel_list_")

                        models(homeModel.type1Model?.titles?.map { title ->
                            ++dummyId
                            CarouselCardItemLayoutBindingModel_().apply {
                                id("carosil_data_item_$dummyId")
                                title(title)
                            }
                        }!!)
                    }
                }

                SequenceType.TYPE2 -> {
                    singleDescriptionCardLayout {
                        homeModel.type2Model?.let { type2 ->
                            this.id(type2.id)
                            this.text(type2.longText)
                        }
                    }
                }

                SequenceType.TYPE3 -> {
                    imageDescriptionCardLayout {
                        homeModel.type3Model?.let { type3 ->
                            this.id(type3.id)
                            this.text(type3.longText)
                        }
                    }
                }

                SequenceType.TYPE4 -> {
                    imagesCardLayout {
                        homeModel.type4Model?.let { type4 ->
                            this.id(type4.id)
                            this.text1(type4.title1)
                            this.text2(type4.title2)
                        }
                    }
                }
            }
        }
    }
}