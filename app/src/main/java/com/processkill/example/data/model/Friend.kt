package com.processkill.example.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Friend(
    val id: Int,
    val name: String
): Parcelable