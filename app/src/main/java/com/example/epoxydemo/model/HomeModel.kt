package com.example.epoxydemo.model

data class HomeModel(val sequenceType : SequenceType,
                     var type1Model: Type1Model? = null,
                     val type2Model: Type2Model? = null,
                     val type3Model: Type3Model? = null,
                     val type4Model: Type4Model? = null)


enum class SequenceType {
    TYPE1, TYPE2, TYPE3, TYPE4
}