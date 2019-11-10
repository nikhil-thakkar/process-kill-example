package com.processkill.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.processkill.example.data.model.User

interface ItemClickListener {
    fun onItemClick(user: User)
}

class DataAdapter(private val users: List<User> = mutableListOf(), private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<DataVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataVH {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return DataVH(layout, itemClickListener)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataVH, position: Int) {
        holder.bind(users[position])
    }
}

class DataVH(view: View, private val itemClickListener: ItemClickListener) : RecyclerView.ViewHolder(view),
    View.OnClickListener {

    private lateinit var user: User

    private val textView: TextView = view.findViewById(R.id.textView)
    private val textView1: TextView = view.findViewById(R.id.textView1)

    init {
        view.setOnClickListener(this)
    }

    fun bind(user: User) {
        textView.text = user.company
        textView1.text = user.email
        this.user = user
    }

    override fun onClick(p0: View?) {
        itemClickListener.onItemClick(user)
    }
}