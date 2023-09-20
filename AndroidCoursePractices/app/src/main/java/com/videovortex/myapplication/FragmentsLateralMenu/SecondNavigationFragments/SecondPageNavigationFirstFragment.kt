package com.videovortex.myapplication.FragmentsLateralMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.videovortex.myapplication.MainActivity
import com.videovortex.myapplication.R
import com.videovortex.myapplication.databinding.FragmentSecondPagePaginationFirstFragmentBinding

class SecondPageNavigationFirstFragment : Fragment() {

    private lateinit var binding: FragmentSecondPagePaginationFirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_page_pagination_first_fragment, container, false)
        // Inflar el diseño del Fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Establece el fragmento actual en la actividad
        //TODO setea el fragment actual desde el activity actual
        val activity = requireActivity() as MainActivity
        activity.setCurrentFragment(this)

        activity.getToggle()?.isDrawerIndicatorEnabled = false

        binding.goToSecondFragmentManual.setOnClickListener {

            // Crear un Bundle y agregar datos
            //TODO como agregar bundle entre fragments manuales
            val bundle = Bundle()
            val message = "Hola desde el primer fragmento"
            bundle.putString("mensaje", message)

            val fragmentSecondPageNavigationSecondFragment = SecondPageNavigationSecondFragment()
            fragmentSecondPageNavigationSecondFragment.arguments = bundle

            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragmentSecondPageNavigationSecondFragment)
            transaction.addToBackStack("tran_second_frag") // Etiqueta la transacción
            transaction.commit()
        }
    }
}
