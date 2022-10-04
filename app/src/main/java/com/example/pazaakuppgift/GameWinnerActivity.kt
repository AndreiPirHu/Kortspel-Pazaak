package com.example.pazaakuppgift

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GameWinnerActivity : AppCompatActivity() {

    lateinit var gameWinnerView: TextView
    lateinit var rematchButton: Button
    lateinit var returnToMainMenuButton: Button



    //Default player names if none have been chosen
    var player1Name = "Player 1"
    var player2Name = "Player 2"

    var winnerName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_winner)

        //locks the activity in landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        gameWinnerView = findViewById(R.id.gameWinnerView)
        rematchButton = findViewById(R.id.rematchButton)
        returnToMainMenuButton = findViewById(R.id.returnToMainMenuButton)


        //winner name fetched from the last activity
        // player names fetched from last activity for rematch
        winnerName = intent.getStringExtra("winnerName").toString()
        player1Name = intent.getStringExtra("player1Name").toString()
        player2Name = intent.getStringExtra("player2Name").toString()


        gameWinnerView.text =   "Congratulations $winnerName!" +
                                System.getProperty("line.separator") +
                                "You are the winner of the game!"

        //takes the players back to hand building activity with the same names
        rematchButton.setOnClickListener {
            val intent = Intent(this, HandBuildingActivity::class.java)
            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            startActivity(intent)
        }

        // takes the players back to main menu activity
        returnToMainMenuButton.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

    }




}