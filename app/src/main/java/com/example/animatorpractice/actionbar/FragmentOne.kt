package com.example.animatorpractice.actionbar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.animatorpractice.R
import kotlinx.android.synthetic.main.fmt_one.*
import kotlinx.android.synthetic.main.fmt_start.tvStart

class FragmentOne : Fragment() {

    interface FragmentNavigator {

        fun goToFragmentTwo()
    }

    companion object {

        fun newInstance(): FragmentOne = FragmentOne()
    }

    private var fragmentNavigator: FragmentNavigator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentNavigator = requireActivity() as FragmentNavigator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // this makes it possible for the fragment to add items to the action bar menu
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fmt_one, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // hosting activity will use this toolbar as action bar
        (requireActivity() as AppCompatActivity).setSupportActionBar(vToolbarOne)

        tvStart.setOnClickListener {
            fragmentNavigator?.goToFragmentTwo()
        }
    }

    // inflate menu and add more items
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_start, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_search -> fragmentNavigator?.goToFragmentTwo()
        }
        return true
    }

    override fun onDetach() {
        super.onDetach()
        fragmentNavigator = null
    }
}