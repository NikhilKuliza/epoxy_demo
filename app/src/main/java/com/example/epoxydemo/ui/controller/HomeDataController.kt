package com.example.epoxydemo.ui.controller

import android.content.Context
import com.airbnb.epoxy.*
import com.example.epoxydemo.*
import com.example.epoxydemo.model.HomeModel
import com.example.epoxydemo.model.SequenceType


class HomeDataController(var context: Context) : TypedEpoxyController<List<HomeModel>>() {
    var dummyId: Int = 101;

    override fun buildModels(data: List<HomeModel>?) {

        data?.forEach { homeModel ->

            when (homeModel.sequenceType) {

                SequenceType.TYPE1 -> {

                    headerRow {
                        ++dummyId
                        id("Header_$dummyId")
                        headerText("Carousel Header")
                    }

                    carousel {
                        ++dummyId
                        id("Carosel_list_")
                        numViewsToShowOnScreen(2.5F)

                        withModelsFrom(homeModel.type1Model?.titles!!) {
                            CarouselCardItemLayoutBindingModel_()
                                .id("carosil_data_item_$dummyId")
                                .title(it)
                            }
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












    /** For use in the buildModels method of EpoxyController. A shortcut for creating a Carousel model, initializing it, and adding it to the controller.
     *
     */
    private inline fun EpoxyController.carousel(modelInitializer: CarouselModelBuilder.() -> Unit) {
        CarouselModel_().apply {
            modelInitializer()
        }.addTo(this)
    }

    /** Add models to a CarouselModel_ by transforming a list of items into EpoxyModels.
     *
     * @param items The items to transform to models
     * @param modelBuilder A function that take an item and returns a new EpoxyModel for that item.
     */
    private inline fun <T> CarouselModelBuilder.withModelsFrom(
        items: List<T>,
        modelBuilder: (T) -> EpoxyModel<*>
    ) {
        models(items.map { modelBuilder(it) })
    }
}