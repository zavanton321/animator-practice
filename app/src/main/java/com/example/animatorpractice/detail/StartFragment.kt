package com.example.animatorpractice.detail

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
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
    ): View? {
        return inflater.inflate(R.layout.fmt_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvStart.setOnClickListener {
            fragmentNavigator?.goToFinishFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_start, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_finish) {
            Toast.makeText(requireActivity(), "Finish", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDetach() {
        super.onDetach()
        fragmentNavigator = null
    }
}