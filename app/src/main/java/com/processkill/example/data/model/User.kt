package com.processkill.example.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val _id: String,
    val about: String,
    val address: String,
    val age: Int,
    val balance: String,
    val company: String,
    val email: String,
    val eyeColor: String,
    val favoriteFruit: String,
    val friends: List<Friend>,
    val greeting: String,
    val guid: String,
    val index: Int,
    val isActive: Boolean,
    val latitude: String,
    val longitude: String,
    val name: Name,
    val phone: String,
    val picture: String,
    val range: List<Int>,
    val registered: String,
    val tags: List<String>
): Parcelable