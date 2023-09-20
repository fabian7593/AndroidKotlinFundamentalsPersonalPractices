package com.videovortex.myapplication.FragmentsLateralMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.videovortex.myapplication.MainActivity
import com.videovortex.myapplication.R
import com.videovortex.myapplication.databinding.FragmentLateralMenuSecondBinding

class LateralMenuSecondFragment : Fragment() {

    private lateinit var binding: FragmentLateralMenuSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lateral_menu_second, container, false)
        // Inflar el diseño del Fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO setea el current fragment
        val activity = requireActivity() as MainActivity
        activity.setCurrentFragment(this)
        activity.getToggle()?.isDrawerIndicatorEnabled = true

        binding.goToAnotherFragmentManual.setOnClickListener {

            val fragmentSecondPageNavigationFirstFragment = SecondPageNavigationFirstFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragmentSecondPageNavigationFirstFragment)
            transaction.addToBackStack("tran_first_frag") // Etiqueta la transacción
            transaction.commit()

        }
    }
}
