package com.example.pazaakuppgift

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class RoundWinnerActivity : AppCompatActivity() {

    lateinit var playerWinsRoundView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_winner)

        //locks the activity in landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        playerWinsRoundView = findViewById(R.id.playerWinsRoundView)

        //winner name fetched from the last activity if not a tie
        // extra cards checked if used
        var winnerName = intent.getStringExtra("winnerName").toString()
        var p1Score = intent.getIntExtra("p1Score", 0)
        var p2Score = intent.getIntExtra("p2Score", 0)
        var p1ExtraCard1Used = intent.getBooleanExtra("p1ExtraCardUsed", false)
        var p1ExtraCard2Used = intent.getBooleanExtra("p1ExtraCardUsed", false)
        var p1ExtraCard3Used = intent.getBooleanExtra("p1ExtraCardUsed", false)
        var p2ExtraCard1Used = intent.getBooleanExtra("p1ExtraCardUsed", false)
        var p2ExtraCard2Used = intent.getBooleanExtra("p1ExtraCardUsed", false)
        var p2ExtraCard3Used = intent.getBooleanExtra("p1ExtraCardUsed", false)



        playerWinsRoundView.text = "$winnerName won the round!"

    }




}