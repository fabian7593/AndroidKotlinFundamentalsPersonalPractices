package com.videovortex.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import com.videovortex.myapplication.R
import com.videovortex.myapplication.databinding.FragmentDrawerCompleteFourthSecondBinding
import androidx.navigation.fragment.findNavController

//Logic fo back pressed button
class SecondNavigationInDrawerFragment : Fragment() {

        private lateinit var binding: FragmentDrawerCompleteFourthSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drawer_complete_fourth_second, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Navega al Fragmento A
            navigateToFragmentA()
        }
    }

    private fun navigateToFragmentA() {

        val navController = findNavController()
        navController.popBackStack(R.id.nav_home,false)

    }


}

