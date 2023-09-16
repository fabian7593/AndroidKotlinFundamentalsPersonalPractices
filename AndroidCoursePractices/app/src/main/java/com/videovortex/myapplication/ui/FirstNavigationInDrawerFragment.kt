package com.videovortex.myapplication.ui

import android.app.BroadcastOptions.fromBundle
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.app.Person.fromBundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.videovortex.myapplication.MainActivity
import com.videovortex.myapplication.R
import com.videovortex.myapplication.databinding.FragmentDrawerCompleteFourthBinding

class FirstNavigationInDrawerFragment : Fragment() {

    private lateinit var binding: FragmentDrawerCompleteFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_drawer_complete_fourth, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO atajar un secure args en el segundo fragment de navigation in drawer
        val argumentValue = FirstNavigationInDrawerFragmentArgs.fromBundle(requireArguments()).argKey
        Toast.makeText(view.context, argumentValue, Toast.LENGTH_SHORT).show()


        binding.nextFragment.setOnClickListener{

            //TODO ir al sigueinte fragment desde navigation In Drawer
             view.findNavController().navigate(R.id.secondNavigationDrawerFragment)

        }
    }
}

