package com.videovortex.myapplication.FragmentsPagination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.videovortex.myapplication.R

//TODO clase que maneja el view de manera manual pero es creado desde onViewCreated
class FirstPageFragment : Fragment() {

    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var buttonToChange : Button
    lateinit var resultText : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        declareUiComponents(view)

        buttonToChange.setOnClickListener{
            rollDice(diceImage)
            rollDice(diceImage2)
        }
    }

    private fun declareUiComponents(view : View){
        buttonToChange = view.findViewById(R.id.buttonToChange)
        diceImage = view.findViewById(R.id.dice_image)
        diceImage2 = view.findViewById(R.id.dice_image2)
        resultText = view.findViewById(R.id.result_text)
    }

    private fun rollDice(imageUI:ImageView) {
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()

        //  var diceImage: ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageUI.setImageResource(drawableResource)
    }
}
