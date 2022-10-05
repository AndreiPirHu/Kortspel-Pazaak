package com.example.pazaakuppgift

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent

class RulesActivity : AppCompatActivity() {

    var player1Name = "Player 1"
    var player2Name = "Player 2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        //locks the activity in landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        //player names fetched from the last activity if they have been submitted
        player1Name = intent.getStringExtra("player1Name").toString()
        player2Name = intent.getStringExtra("player2Name").toString()


    }

    // if the players touch the screen. Goes back to the main menu
    // Player names are saved if submitted before
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        // if the player lifts their finger from the screen, the action is executed
        if (event?.action == MotionEvent.ACTION_UP) {

            // sends all the needed variables back to the main activity for the next round
            val intent = Intent(this, MainMenuActivity::class.java)
            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            startActivity(intent)
        }


        return true
    }


}