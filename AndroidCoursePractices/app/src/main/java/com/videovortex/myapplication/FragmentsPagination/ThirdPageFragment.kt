package com.videovortex.myapplication.FragmentsPagination

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.videovortex.myapplication.Models.MyName
import com.videovortex.myapplication.R
import com.videovortex.myapplication.ViewModels.ExampleViewModel
import com.videovortex.myapplication.databinding.FragmentThirdPageBinding

//Todo clase que utiliza elview binding
class ThirdPageFragment : Fragment() {

    //TODO ejemplo de view model implementation
    private lateinit var viewModel: ExampleViewModel

    private lateinit var binding: FragmentThirdPageBinding
    //private val myName: MyName = MyName("Fabian")

    private val TAG = "MyFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Just for activities
        //binding = DataBindingUtil.setContentView(activity!!, R.layout.activity_main)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third_page, container, false)

        Log.i("GameFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(ExampleViewModel::class.java)

        // Infla el diseño de este fragmento
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
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


        binding.buttonChangeWordFragmentThirdId.setOnClickListener{
            viewModel.onCorrect()

            binding.firstNameTextView.text = viewModel.word
            binding.lastNameTextView.text = viewModel.score.toString()
        }
    }


    fun setViewModel(){
        if(viewModel.word != ""){
            binding.firstNameTextView.text = viewModel.word
            binding.lastNameTextView.text = viewModel.score.toString()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        //TODO Set view model in screen
        setViewModel()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }

}
