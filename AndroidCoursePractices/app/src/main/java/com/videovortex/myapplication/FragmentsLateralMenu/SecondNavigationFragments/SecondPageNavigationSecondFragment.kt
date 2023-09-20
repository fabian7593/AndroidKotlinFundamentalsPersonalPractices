package com.videovortex.myapplication.FragmentsLateralMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.videovortex.myapplication.MainActivity
import com.videovortex.myapplication.R
import com.videovortex.myapplication.databinding.FragmentSecondPagePaginationSecondFragmentBinding


class SecondPageNavigationSecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondPagePaginationSecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_page_pagination_second_fragment, container, false)
        // Inflar el diseño del Fragment
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Establece el fragmento actual en la actividad
        val activity = requireActivity() as MainActivity
        activity.setCurrentFragment(this)
        activity.getToggle()?.isDrawerIndicatorEnabled = false

        val bundle = arguments
        if (bundle != null) {
            val message = bundle.getString("mensaje")
            Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }


        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Navega al Fragmento A
            requireActivity().supportFragmentManager.popBackStack("tran_first_frag", 0)
        }
    }
}
