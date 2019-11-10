package com.processkill.example.data

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.processkill.example.data.model.User

interface DataProvider {

    fun getUser(id: String): User

    fun getUsers(): List<User>
}

class AssetDataProvider(private val context: Context) : DataProvider {

    private val gson = GsonBuilder().create()

    override fun getUser(id: String): User {
        val actualId = if (id == "1" || id == "2" || id == "3") {
            id
        } else "2"

        val user = readFromAssets(actualId)
        return gson.fromJson<List<User>>(user, TypeToken.getParameterized(List::class.java, User::class.java).type)[0]
    }

    override fun getUsers(): List<User> {
        val user1 = readFromAssets("1")
        val user2 = readFromAssets("2")
        val user3 = readFromAssets("3")

        val users1 =
            gson.fromJson<List<User>>(user1, TypeToken.getParameterized(List::class.java, User::class.java).type)

        val users2 =
            gson.fromJson<List<User>>(user2, TypeToken.getParameterized(List::class.java, User::class.java).type)

        val users3 =
            gson.fromJson<List<User>>(user3, TypeToken.getParameterized(List::class.java, User::class.java).type)

        return (users1 + users2 + users3).multiply(2)
    }

    private fun readFromAssets(id: String): String {
        return context.assets.open("$id.json").bufferedReader().use {
            it.readText()
        }
    }

    fun <T> List<T>.multiply(times: Int): List<T> {
        val list = mutableListOf<T>()
        repeat(times) {
            map {
                list.addAll(this)
            }
        }
        return list
    }
}