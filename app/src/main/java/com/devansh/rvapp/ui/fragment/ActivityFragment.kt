package com.devansh.rvapp.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.devansh.rvapp.R
import com.devansh.rvapp.ui.ActivityViewModel

class ActivityFragment : Fragment() {

    companion object {
        fun newInstance() = ActivityFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel : ActivityViewModel by viewModels { ActivityViewModel.Factory}
        // TODO: Use the ViewModel
    }

}