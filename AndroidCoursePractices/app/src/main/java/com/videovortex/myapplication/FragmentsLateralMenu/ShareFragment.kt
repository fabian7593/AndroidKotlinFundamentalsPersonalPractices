package com.videovortex.myapplication.FragmentsLateralMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.videovortex.myapplication.R
import com.videovortex.myapplication.ViewModels.ExampleShareFragmentViewData
import com.videovortex.myapplication.databinding.FragmentLateralMenuShareBinding

class ShareFragment : Fragment() {


    private lateinit var binding: FragmentLateralMenuShareBinding
    private lateinit var exampleShareViewModel: ExampleShareFragmentViewData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lateral_menu_share, container, false)

        exampleShareViewModel = ViewModelProvider(this).get(ExampleShareFragmentViewData::class.java)

        // Inflar el diseño del Fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        exampleShareViewModel.taskList.observe(viewLifecycleOwner, Observer { newWordInList ->
            binding.textViewLiveData.text = newWordInList.toString()
        })

        //TODO LOGIC OF OBSERVE OF LIVEDATA
        // Observa los cambios en la lista de tareas
        exampleShareViewModel.taskList.observe(this) { tasks ->
            binding.textViewLiveData.text = exampleShareViewModel.getListToString()
        }

        //TODO Another logic of observer data
       /* binding.buttonChangeDataFromViewBinding.setOnClickListener {
            exampleShareViewModel.addTask(binding.editTextLiveData.text.toString())
        }*/
    }
}