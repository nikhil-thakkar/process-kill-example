package com.processkill.example.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name(
    val first: String,
    val last: String
): Parcelable