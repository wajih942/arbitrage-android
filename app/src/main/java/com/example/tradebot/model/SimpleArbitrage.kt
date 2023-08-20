package com.example.tradebot.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SimpleArbitrage(val _id:String,val ID : Int,val NAME:String,val TOKEN0NAME:String,val TOKEN0IMAGE:String,val TOKEN1NAME:String,val TOKEN1IMAGE:String,val FIRSTMARKET: String,val SECONDMARKET:String,val arbitrageOpportunities :List<ArbitrageOpportunities>) : Parcelable
