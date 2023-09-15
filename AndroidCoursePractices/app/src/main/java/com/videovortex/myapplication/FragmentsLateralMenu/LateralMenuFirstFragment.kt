package com.videovortex.myapplication.FragmentsLateralMenu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.videovortex.myapplication.DrawerCompleteExample
import com.videovortex.myapplication.PaginationActivity
import com.videovortex.myapplication.R



class LateralMenuFirstFragment : Fragment() {

    lateinit var exampleGoToAnotherActivity : Button
    lateinit var exampleGoToDrawerActivity : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_lateral_menu_first, container, false)
        exampleGoToAnotherActivity = view.findViewById(R.id.exampleGoToAnotherActivity)
        exampleGoToDrawerActivity = view.findViewById(R.id.exampleGoToDrawerActivity)

        exampleGoToAnotherActivity.setOnClickListener({
            val intent = Intent(activity, PaginationActivity::class.java)
            startActivity(intent)
        })


        exampleGoToDrawerActivity.setOnClickListener({
            val intent = Intent(activity, DrawerCompleteExample::class.java)
            startActivity(intent)
        })

        return view
    }
}
