package com.example.pazaakuppgift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainMenu : AppCompatActivity() {

    lateinit var player1NameView : EditText
    lateinit var player2NameView : EditText
    var player1Name = ""
    var player2Name = ""
    var playerValue = 0

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var startGameNavButton = findViewById<Button>(R.id.startGameNavButton)
        var rulesNavButton = findViewById<Button>(R.id.rulesNavButton)
        player1NameView = findViewById(R.id.player1NameView)
        player2NameView = findViewById(R.id.player2NameView)
        var submitPlayer1NameButton = findViewById<Button>(R.id.submitPlayer1NameButton)
        var submitPlayer2NameButton = findViewById<Button>(R.id.submitPlayer2NameButton)



        submitPlayer1NameButton.setOnClickListener {
           playerValue = 1
           submitName(playerValue)
        }

        submitPlayer2NameButton.setOnClickListener {
            playerValue=2
            submitName(playerValue)
        }

        startGameNavButton.setOnClickListener {
            val intent = Intent(this, HandBuildingActivity::class.java)
            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            startActivity(intent)
        }



    }

fun submitName(playerValue:Int){
    if (playerValue == 1){
        player1Name = player1NameView.text.toString()
    }else if (playerValue == 2){
        player2Name = player2NameView.text.toString()
    }
}



}