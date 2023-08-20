package com.example.tradebot.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TriangularPathItem(val _id:String,val NAME:String,val TOKEN0NAME:String,val TOKEN0IMAGE:String,val TOKEN1NAME:String,val TOKEN1IMAGE:String) : Parcelable
