package com.example.animatorpractice.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animatorpractice.R

class FinishFragment : Fragment() {

    companion object {

        fun newInstance(): FinishFragment = FinishFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fmt_finish, container, false)
    }
}