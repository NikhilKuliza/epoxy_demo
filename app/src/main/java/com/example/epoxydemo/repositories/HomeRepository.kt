package com.example.epoxydemo.repositories

import android.util.Log
import com.example.epoxydemo.model.*
import java.util.*
import kotlin.collections.ArrayList

class HomeRepository {

    fun getHomeData() : ArrayList<HomeModel> {
        return getRandumData()
    }







    //need to implement this logic on server
    private val random = Random()
    private fun getRandumNumber() : Int {
        return random.nextInt(4)
    }


    private fun getRandumData() : ArrayList<HomeModel> {
        val list = ArrayList<HomeModel>()

        for (i in 1..20) {
            val number = getRandumNumber()
            Log.d("HomeRepo", "Randum Value : $number")

            val datta = when (number) {

                0 -> {
                    HomeModel(SequenceType.TYPE1, type1Model = getType1Data(i))
                }

                1 -> {
                    HomeModel(SequenceType.TYPE2, type2Model = getType2Data(i))
                }

                2 -> {
                    HomeModel(SequenceType.TYPE3, type3Model = getType3Data(i))
                }

                else -> {
                    HomeModel(SequenceType.TYPE4, type4Model = getType4Data(i))
                }
            }

            list.add(datta)

        }
        return list
    }



    private fun getType1Data(position : Int) : Type1Model {
        val id = "$position Kuliza"
        val list = ArrayList<String>()
        for (i in 1..6) {
            list.add("$id $i")
        }

        return Type1Model(id,list)
    }

    private fun getType2Data(position : Int) : Type2Model {
        val id = "$position Kuliza"
        val longText = "There are two main components of Epoxy: \\n The EpoxyModels that describe how your views should be displayed in the RecyclerView. \\n The EpoxyController where the models are used to describe what items to show and with what data."
        return Type2Model(id, longText)
    }

    private fun getType3Data(position : Int) : Type3Model {
        val id = "$position Kuliza"
        val longText = "There are two main components of Epoxy: \\n The EpoxyModels that describe how your views should be displayed in the RecyclerView. \\n The EpoxyController where the models are used to describe what items to show and with what data."
        return Type3Model(id, longText)
    }

    private fun getType4Data(position : Int) : Type4Model {
        val id = "$position Kuliza"
        val title1 =  "$id 1 "
        val title2 =  "$id 2 "
        return Type4Model(id, title1, title2, "", "")
    }



}