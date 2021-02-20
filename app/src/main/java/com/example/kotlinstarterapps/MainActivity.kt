package com.example.kotlinstarterapps

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var player1_count = 0
    var player2_count = 1
    var winner = -1
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun clicked(v: View) {
        val selected = v as Button
        var cellId = 0
        when (selected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
        playGame(cellId, selected)
    }


    private fun playGame(cellId: Int, selected: Button) {

        selected.isEnabled = false
        if (activePlayer == 1) {
            selected.text = "X"
            selected.setBackgroundColor(Color.BLUE)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        } else {
            selected.text = "O"
            selected.setBackgroundColor(Color.RED)
            player2.add(cellId)
            activePlayer = 1
        }
        checkWinner()

    }


    private fun includes(x: ArrayList<Int>): Boolean {
        var check: Boolean = false
        if (x.contains(1) && x.contains(2) && x.contains(3)) {
            check = true
        } else if (x.contains(4) && x.contains(5) && x.contains(6)) {
            check = true
        } else if (x.contains(7) && x.contains(8) && x.contains(9)) {
            check = true
        } else if (x.contains(1) && x.contains(4) && x.contains(7)) {
            check = true
        } else if (x.contains(2) && x.contains(5) && x.contains(8)) {
            check = true
        } else if (x.contains(3) && x.contains(6) && x.contains(9)) {
            check = true
        } else if (x.contains(3) && x.contains(5) && x.contains(7)) {
            check = true
        } else if (x.contains(1) && x.contains(5) && x.contains(9)) {
            check = true
        }
        return check
    }

    private fun checkWinner() {
        if (includes(player1)) {
            winner = 1
        } else if (includes(player2)) {
            winner = 2
        }
        if (winner == 1) {
//            Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show()
            player1_count++
            restart()
        } else if (winner == 2) {
//            Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show()
            player2_count++
            restart()
        } else if (player1.size + player2.size == 9) {
//            Toast.makeText(this, "Game Drawn", Toast.LENGTH_SHORT).show()
            restart()
        }
    }


    private fun autoPlay() {
        var emptyCells = ArrayList<Int>()
        for (i in 1..9) {
            if (!player2.contains(i) && !(player1.contains(i))) {
                emptyCells.add(i)
            }
        }
//        val r = Random()
//        val index = r.nextInt(emptyCells.size)
        if (emptyCells.size > 0) {
            var index = (0..emptyCells.size - 1).random()
            val cellId = emptyCells[index]
            var selected: Button?
            selected = when (cellId) {
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> button1
            }
            playGame(cellId, selected)
        }

    }

    private fun restart() {
        activePlayer = 1
        player1.clear()
        player2.clear()
        winner = -1
        for (i in 1..9) {
            var selected: Button?
            selected = when (i) {
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> button1
            }
            selected.setBackgroundColor(Color.WHITE)
            selected.isEnabled = true
            selected.text = ""
        }
        Toast.makeText(
            this,
            "Player 1 : $player1_count wins , Player 2 : $player2_count wins",
            Toast.LENGTH_SHORT
        ).show()
    }


}