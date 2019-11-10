package com.processkill.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.processkill.example.data.AssetDataProvider
import com.processkill.example.data.model.User

class MainFragment : Fragment(), ItemClickListener {

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    private val assetDataProvider: AssetDataProvider by lazy {
        AssetDataProvider(context!!.applicationContext)
    }

    private lateinit var users: List<User>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(context)
        users = savedInstanceState?.getParcelableArrayList("users") ?: assetDataProvider.getUsers()
        rv.adapter = DataAdapter(users, this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("users", users as ArrayList)
    }

    override fun onItemClick(user: User) {
        activity?.supportFragmentManager?.replaceFragment(
            R.id.fragment_container, DetailFragment.newInstance(user), true
        )
    }
}