package com.devansh.rvapp.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devansh.rvapp.R
import com.devansh.rvapp.ui.MemesViewModel

class MemesFragment : Fragment() {

    companion object {
        fun newInstance() = MemesFragment()
    }

    private lateinit var viewModel: MemesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_memes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MemesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}