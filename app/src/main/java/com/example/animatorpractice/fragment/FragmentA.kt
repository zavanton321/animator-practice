package com.example.animatorpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animatorpractice.R

class FragmentA : Fragment() {

    companion object {

        fun newInstance(): FragmentA = FragmentA()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_a, container, false)
}