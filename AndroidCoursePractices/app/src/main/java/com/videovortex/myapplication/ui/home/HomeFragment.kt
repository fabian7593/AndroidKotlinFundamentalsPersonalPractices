package com.videovortex.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.videovortex.myapplication.R
import com.videovortex.myapplication.databinding.FragmentHomeBinding
import com.videovortex.myapplication.ui.FirstNavigationInDrawerFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.nextFragment?.setOnClickListener{


            //TODO utilizacion de secure args para pasar datos por fragments desde Navigation In Drawer
            val action = HomeFragmentDirections.actionNavHomeToFirstNavigationDrawerFragment(argKey = "Esto es una prueba de safe args entre Fragments")
            findNavController().navigate(action)

            //TODO Navegar entre fragments de navigation In drawer sin arguments
            //it.findNavController().navigate(R.id.firstNavigationDrawerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}