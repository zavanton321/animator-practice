package com.example.animatorpractice.toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.animatorpractice.R
import com.example.animatorpractice.actionbar.FragmentTwo
import kotlinx.android.synthetic.main.fmt_finish.*

class FinishFragment : Fragment() {

    companion object {

        fun newInstance(): FinishFragment = FinishFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fmt_finish, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        vToolbar.navigationIcon = requireContext().getDrawable(R.drawable.ic_back_arrow)
        vToolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        vToolbar.inflateMenu(R.menu.menu_finish)
        vToolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.item_search) {
                Toast.makeText(requireContext(), "Finish", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}