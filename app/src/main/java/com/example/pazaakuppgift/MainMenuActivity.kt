package com.example.pazaakuppgift

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainMenuActivity : AppCompatActivity() {

    lateinit var player1NameView: EditText
    lateinit var player2NameView: EditText
    var player1Name = "Player 1"
    var player2Name = "Player 2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        //locks the activity in landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)


        var startGameNavButton = findViewById<Button>(R.id.startGameNavButton)
        var rulesNavButton = findViewById<Button>(R.id.rulesNavButton)

        player1NameView = findViewById(R.id.player1NameView)
        player2NameView = findViewById(R.id.player2NameView)

        var submitPlayer1NameButton = findViewById<Button>(R.id.submitPlayer1NameButton)
        var submitPlayer2NameButton = findViewById<Button>(R.id.submitPlayer2NameButton)
        var changePlayer1NameButton = findViewById<Button>(R.id.changePlayer1NameButton)
        var changePlayer2NameButton = findViewById<Button>(R.id.changePlayer2NameButton)

        //player names fetched from the last activity if they have been submitted
        player1Name = intent.getStringExtra("player1Name").toString()
        player2Name = intent.getStringExtra("player2Name").toString()

        //Checks if no name has been given. Changes it to Player 1. This is a problem due to fetching names from intent
        // that have not been submitted yet
        checkIfNameNull()

        //change buttons disabled from start
        changePlayer1NameButton.setEnabled(false)
        changePlayer2NameButton.setEnabled(false)


        submitPlayer1NameButton.setOnClickListener {
            var playerValue = 1
            submitName(playerValue)
            submitPlayer1NameButton.setEnabled(false)
            changePlayer1NameButton.setEnabled(true)

        }

        submitPlayer2NameButton.setOnClickListener {
            var playerValue = 2
            submitName(playerValue)
            submitPlayer2NameButton.setEnabled(false)
            changePlayer2NameButton.setEnabled(true)

        }
        //clears the text and resets variable to default name
        changePlayer1NameButton.setOnClickListener {
            submitPlayer1NameButton.setEnabled(true)
            changePlayer1NameButton.setEnabled(false)
            player1Name = getString(R.string.player1)
            player1NameView.text.clear()
        }
        //clears the text and resets variable to default name
        changePlayer2NameButton.setOnClickListener {
            submitPlayer2NameButton.setEnabled(true)
            changePlayer2NameButton.setEnabled(false)
            player2Name = getString(R.string.player2)
            player2NameView.text.clear()
        }

        startGameNavButton.setOnClickListener {
            val intent = Intent(this, HandBuildingActivity::class.java)
            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            startActivity(intent)
        }

        rulesNavButton.setOnClickListener {
            val intent = Intent(this, RulesActivity::class.java)
            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            startActivity(intent)
        }


    }

    //Checks if no name has been given. Changes it to Player 1. This is a problem due to fetching names from intent
    // that have not been submitted yet
    fun checkIfNameNull() {
        if (player1Name == getString(R.string.null_)) {
            player1Name = getString(R.string.player1)
        }
        if (player2Name == getString(R.string.null_)) {
            player2Name = getString(R.string.player2)
        }
    }
    //saves the submitted name
    fun submitName(playerValue: Int) {
        if (playerValue == 1) {
            player1Name = player1NameView.text.toString()
        } else if (playerValue == 2) {
            player2Name = player2NameView.text.toString()
        }
    }


}