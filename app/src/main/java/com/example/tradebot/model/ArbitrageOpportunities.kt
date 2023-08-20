package com.example.tradebot.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArbitrageOpportunities(val _id : String,val price : Float,val date:String) :Parcelable
