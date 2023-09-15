package com.videovortex.myapplication.FragmentsLateralMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.videovortex.myapplication.R

class LateralMenuSecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del Fragment
        return inflater.inflate(R.layout.fragment_lateral_menu_second, container, false)
    }

    // Otros métodos del Fragment
}
