package com.alex.kotlin.login.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.kotlin.componentbase.ServiceFactory

import com.alex.kotlin.login.R
import kotlinx.android.synthetic.main.login_blank_fragment.*

class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_blank_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_button2.setOnClickListener {
            Log.e("========",ServiceFactory.getFactory().share?.shareSuccess().toString())
        }
        login_share.setOnClickListener {
            ServiceFactory.getFactory().share?.share("AAA")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)

    }

}
