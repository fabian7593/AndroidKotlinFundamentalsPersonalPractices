package com.videovortex.myapplication.FragmentsPagination

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.videovortex.myapplication.R

class SecondPageFragment : Fragment() {

    lateinit var doneButton : Button
    lateinit var nickNameTextView : TextView
    lateinit var nickNameEditText : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño de este fragmento

        return inflater.inflate(R.layout.fragment_second_page, container, false)
    }

    private fun declareUiComponents(view : View){
        doneButton = view.findViewById(R.id.done_button)
        nickNameTextView = view.findViewById(R.id.nickname_text)
        nickNameEditText = view.findViewById(R.id.nickname_edit)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        declareUiComponents(view)

        doneButton.setOnClickListener {
            addNickname(it)
        }

        nickNameTextView.setOnClickListener {
            updateNickname(it)
        }
        // Puedes realizar cualquier inicialización de vistas o lógica específica de este fragmento aquí
    }

    //TODO hide and show keyboard
    /**
     * Click handler for the DONE button.
     * Hides the EditText and the DONE button.
     * Sets the EditText content to the TextView and displays it.
     */
    private fun addNickname(view: View) {
        nickNameTextView.text = nickNameEditText.text
        nickNameEditText.visibility = View.GONE
        view.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE


        // Hide the keyboard.
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    /**
     * Click handler for the nickname TextView.
     * Displays the EditText and the DONE button.
     * Hides the nickname TextView.
     */
    private fun updateNickname(view: View) {

        nickNameEditText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        nickNameEditText.requestFocus()

        // Show the keyboard.
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickNameEditText, 0)
    }

}
