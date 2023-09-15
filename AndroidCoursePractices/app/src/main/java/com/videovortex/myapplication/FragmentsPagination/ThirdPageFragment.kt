package com.videovortex.myapplication.FragmentsPagination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.videovortex.myapplication.Models.MyName
import com.videovortex.myapplication.R
import com.videovortex.myapplication.databinding.FragmentThirdPageBinding

class ThirdPageFragment : Fragment() {

    private lateinit var binding: FragmentThirdPageBinding
    //private val myName: MyName = MyName("Fabian")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Just for activities
        //binding = DataBindingUtil.setContentView(activity!!, R.layout.activity_main)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third_page, container, false)

        /*val binding = DataBindingUtil.inflate<FragmentThirdPageBinding>(inflater,
            R.layout.fragment_third_page,container,false)*/

        // Infla el diseño de este fragmento
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFragmentThirdId.setOnClickListener {
            //TODO show this, is withouth data binding
             binding.firstNameTextView.text =
                  binding.editText1.text.toString()

            binding.lastNameTextView.text =
                binding.editText2.text.toString()

            //TODO this is with databinding
          //  myName?.name = binding.editText1.text.toString()
           // myName?.lastName = binding.editText2.text.toString()

        }
    }
}
