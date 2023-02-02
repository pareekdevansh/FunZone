package com.devansh.rvapp.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devansh.rvapp.ui.JokesViewModel
import com.devansh.rvapp.R

class JokesFragment : Fragment() {

    companion object {
        fun newInstance() = JokesFragment()
    }

    private lateinit var viewModel: JokesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(JokesViewModel::class.java)
        // TODO: Use the ViewModel


    }

}