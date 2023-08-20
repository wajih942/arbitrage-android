package com.example.tradebot.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TriangularPath(val _id:String,val ID:String,val tiangularPath:List<TriangularPathItem>,val FIRSTMARKET:String,val SECONDMARKET:String,val THIRDMARKET:String,val arbitrageOpportunities:List<ArbitrageOpportunities>) : Parcelable
