package com.example.pazaakuppgift

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class RoundWinnerActivity : AppCompatActivity() {

    lateinit var playerWinsRoundView: TextView
    lateinit var winnerConstraintLayout: ConstraintLayout
    var winnerName = ""
    var p1Score = 0
    var p2Score = 0
    var p1ExtraCard1Used = false
    var p1ExtraCard2Used = false
    var p1ExtraCard3Used = false
    var p2ExtraCard1Used = false
    var p2ExtraCard2Used = false
    var p2ExtraCard3Used = false

    //Default player names if none have been chosen
    var player1Name = "Player 1"
    var player2Name = "Player 2"

    // variable that takes in the card value of the chosen extra
    // cards when they are used and adds it to the total value counter
    var p1ChosenExtraCard1Value = 0
    var p1ChosenExtraCard2Value = 0
    var p1ChosenExtraCard3Value = 0
    var p2ChosenExtraCard1Value = 0
    var p2ChosenExtraCard2Value = 0
    var p2ChosenExtraCard3Value = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_winner)

        //locks the activity in landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        playerWinsRoundView = findViewById(R.id.playerWinsRoundView)

        //winner name fetched from the last activity if not a tie
        // extra cards checked if used
        winnerName = intent.getStringExtra("winnerName").toString()
        player1Name = intent.getStringExtra("player1Name").toString()
        player2Name = intent.getStringExtra("player2Name").toString()
        p1ChosenExtraCard1Value = intent.getIntExtra("p1ChosenExtraCard1Value", 1)
        p1ChosenExtraCard2Value = intent.getIntExtra("p1ChosenExtraCard2Value", 4)
        p1ChosenExtraCard3Value = intent.getIntExtra("p1ChosenExtraCard3Value", -3)
        p2ChosenExtraCard1Value = intent.getIntExtra("p2ChosenExtraCard1Value", 1)
        p2ChosenExtraCard2Value = intent.getIntExtra("p2ChosenExtraCard2Value", 4)
        p2ChosenExtraCard3Value = intent.getIntExtra("p2ChosenExtraCard3Value", -3)
        p1Score = intent.getIntExtra("p1Score", 0)
        p2Score = intent.getIntExtra("p2Score", 0)
        p1ExtraCard1Used = intent.getBooleanExtra("p1ExtraCard1Used", false)
        p1ExtraCard2Used = intent.getBooleanExtra("p1ExtraCard2Used", false)
        p1ExtraCard3Used = intent.getBooleanExtra("p1ExtraCard3Used", false)
        p2ExtraCard1Used = intent.getBooleanExtra("p2ExtraCard1Used", false)
        p2ExtraCard2Used = intent.getBooleanExtra("p2ExtraCard2Used", false)
        p2ExtraCard3Used = intent.getBooleanExtra("p2ExtraCard3Used", false)




        winnerConstraintLayout = findViewById(R.id.winnerConstraintLayout)

        if(winnerName == "No one"){
            winnerConstraintLayout.setBackgroundColor(129)
        }

        playerWinsRoundView.text = "$winnerName won this round!"



    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        if(event?.action == MotionEvent.ACTION_UP){

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("p1Score", p1Score)
            intent.putExtra("p2Score", p2Score)
            intent.putExtra("p1ExtraCard1Used", p1ExtraCard1Used)
            intent.putExtra("p1ExtraCard2Used", p1ExtraCard2Used)
            intent.putExtra("p1ExtraCard3Used", p1ExtraCard3Used)
            intent.putExtra("p2ExtraCard1Used", p2ExtraCard1Used)
            intent.putExtra("p2ExtraCard2Used", p2ExtraCard2Used)
            intent.putExtra("p2ExtraCard3Used", p2ExtraCard3Used)

            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            intent.putExtra("p1ChosenExtraCard1Value",p1ChosenExtraCard1Value)
            intent.putExtra("p1ChosenExtraCard2Value",p1ChosenExtraCard2Value)
            intent.putExtra("p1ChosenExtraCard3Value",p1ChosenExtraCard3Value)
            intent.putExtra("p2ChosenExtraCard1Value",p2ChosenExtraCard1Value)
            intent.putExtra("p2ChosenExtraCard2Value",p2ChosenExtraCard2Value)
            intent.putExtra("p2ChosenExtraCard3Value",p2ChosenExtraCard3Value)
            startActivity(intent)
        }


        return true
    }



}