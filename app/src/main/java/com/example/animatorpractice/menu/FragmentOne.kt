package com.example.animatorpractice.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animatorpractice.R
import com.example.animatorpractice.detail.StartFragment
import kotlinx.android.synthetic.main.fmt_start.*

class FragmentOne : Fragment() {

    interface FragmentNavigator {

        fun goToFinishFragment()
    }

    companion object {

        fun newInstance(): FragmentOne = FragmentOne()
    }

    private var fragmentNavigator: FragmentNavigator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentNavigator = requireActivity() as FragmentNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fmt_one, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvStart.setOnClickListener {
            fragmentNavigator?.goToFinishFragment()
        }

        setupToolbar()
    }

    private fun setupToolbar() {
        vToolbar.inflateMenu(R.menu.menu_start)
        vToolbar.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.item_finish -> fragmentNavigator?.goToFinishFragment()
            }
            true
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentNavigator = null
    }
}