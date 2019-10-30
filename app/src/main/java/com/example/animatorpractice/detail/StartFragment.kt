package com.example.animatorpractice.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.fmt_start.*

class StartFragment : Fragment() {

    interface FragmentNavigator {

        fun goToFinishFragment()
    }

    companion object {

        fun newInstance(): StartFragment = StartFragment()
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
    ): View = inflater.inflate(R.layout.fmt_start, container, false)

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