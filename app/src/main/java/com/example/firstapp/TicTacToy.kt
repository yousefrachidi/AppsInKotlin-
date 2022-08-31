package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.firstapp.databinding.ActivityMainBinding
import com.example.firstapp.databinding.ActivityTicTacToyBinding
import java.util.*
import kotlin.collections.ArrayList

class TicTacToy : AppCompatActivity() {

    var binding: ActivityTicTacToyBinding? = null
    var currentPlayer = 1
    var winner = false
    var listPlayer1: ArrayList<Int>? = ArrayList()
    var listPlayer2: ArrayList<Int>? = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tic_tac_toy)
        initialView()
    }

    private fun initialView() {
    }

    fun onClickBtn(view: View) {
        var textView = view as TextView
        var currentBtn = -1

        if (winner) {
            return
        }

        when (textView.id) {
            R.id.btn1 -> currentBtn = 1
            R.id.btn2 -> currentBtn = 2
            R.id.btn3 -> currentBtn = 3

            R.id.btn4 -> currentBtn = 4
            R.id.btn5 -> currentBtn = 5
            R.id.btn6 -> currentBtn = 6

            R.id.btn7 -> currentBtn = 7
            R.id.btn8 -> currentBtn = 8
            R.id.btn9 -> currentBtn = 9

        }


        textView.isEnabled = false

        playGame(textView, currentBtn)


    }

    private fun playGame(textView: TextView, currentBtn: Int) {

        if (currentPlayer == 1) {
            textView.setBackgroundResource(R.color.bleu)
            textView.text = "x"
            currentPlayer = 2
            listPlayer1!!.add(currentBtn)
            checkWinner()
            if (!winner) {
                autoPlay()
            }

        } else {
            textView.setBackgroundResource(R.color.grinDark)
            textView.text = "o"
            currentPlayer = 1
            listPlayer2!!.add(currentBtn)
            checkWinner()

        }

    }

    private fun autoPlay() {
        var emptyBtn = ArrayList<Int>()

        for (cellID in 1..9) {

            if (!(listPlayer1!!.contains(cellID) || listPlayer2!!.contains(cellID))) {
                emptyBtn.add(cellID)
            }
        }
        //is empty
        if (emptyBtn.isEmpty()){
            return
        }
        var number = Random()
        var index = number.nextInt(emptyBtn.size - 0) + 0
        var indexBtn = emptyBtn[index]
        var btn: TextView? = null

        when (indexBtn) {
            1 -> btn = binding!!.btn1
            2 -> btn = binding!!.btn2
            3 -> btn = binding!!.btn3
            4 -> btn = binding!!.btn4
            5 -> btn = binding!!.btn5
            6 -> btn = binding!!.btn6
            7 -> btn = binding!!.btn7
            8 -> btn = binding!!.btn8
            9 -> btn = binding!!.btn9
            else -> {
                btn = binding!!.btn1
            }
        }

        playGame(btn, indexBtn)
    }

    private fun checkWinner() {

        if (listPlayer1!!.containsAll(listOf(1, 2, 3)) || listPlayer1!!.containsAll(
                listOf(
                    4,
                    5,
                    6
                )
            ) || listPlayer1!!.containsAll(listOf(7, 8, 9)) ||
            listPlayer1!!.containsAll(listOf(1, 4, 7)) || listPlayer1!!.containsAll(
                listOf(
                    2,
                    5,
                    8
                )
            ) || listPlayer1!!.containsAll(listOf(3, 6, 9)) ||
            listPlayer1!!.containsAll(listOf(1, 5, 9)) || listPlayer1!!.containsAll(listOf(3, 5, 7))
        ) {
            Toast.makeText(this, "Player One is winner", Toast.LENGTH_SHORT).show()
            winner = true
        }

        if (listPlayer2!!.containsAll(listOf(1, 2, 3)) || listPlayer2!!.containsAll(
                listOf(
                    4,
                    5,
                    6
                )
            ) || listPlayer2!!.containsAll(listOf(7, 8, 9)) ||
            listPlayer2!!.containsAll(listOf(1, 4, 7)) || listPlayer2!!.containsAll(
                listOf(
                    2,
                    5,
                    8
                )
            ) || listPlayer2!!.containsAll(listOf(3, 6, 9)) ||
            listPlayer2!!.containsAll(listOf(1, 5, 9)) || listPlayer2!!.containsAll(listOf(3, 5, 7))
        ) {
            Toast.makeText(this, "Player Tow is winner", Toast.LENGTH_SHORT).show()
            winner = true
        }

    }

}