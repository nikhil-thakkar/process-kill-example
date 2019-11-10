package com.processkill.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.processkill.example.data.model.User

class DetailFragment : Fragment() {

    companion object {

        fun newInstance(user: User): DetailFragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("user", user)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.get("user") as? User ?: throw IllegalArgumentException()
        val textView = view.findViewById<TextView>(R.id.textView)
        val textView1 = view.findViewById<TextView>(R.id.textView1)

        textView.text = user.company
        textView1.text = user.email
    }
}