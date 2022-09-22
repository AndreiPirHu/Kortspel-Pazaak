package com.example.pazaakuppgift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView


class HandBuildingActivity : AppCompatActivity() {

    lateinit var p1ChosenExtraCard1ImageButton: ImageButton
    lateinit var p1ChosenExtraCard2ImageButton: ImageButton
    lateinit var p1ChosenExtraCard3ImageButton: ImageButton

    var player1Ready = false
    var player2Ready = false

    var chosenExtraCard1Value = 0
    var chosenExtraCard2Value = 0
    var chosenExtraCard3Value = 0

//    var player1Name = intent.getStringExtra("player1Name")
//    var player2Name = intent.getStringExtra("player2Name")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hand_building)

        var p1AvailableExtraCard1ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard1ImageButton)
        var p1AvailableExtraCard2ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard2ImageButton)
        var p1AvailableExtraCard3ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard3ImageButton)
        var p1AvailableExtraCard4ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard4ImageButton)
        var p1AvailableExtraCard5ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard5ImageButton)
        var p1AvailableExtraCard6ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard6ImageButton)
        var p1AvailableExtraCard7ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard7ImageButton)
        var p1AvailableExtraCard8ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard8ImageButton)
        var p1AvailableExtraCard9ImageButton = findViewById<ImageButton>(R.id.p1AvailableExtraCard9ImageButton)

//        var p1HandBuildingReadyButton = findViewById<Button>(R.id.p1HandBuildingReadyButton)
//        var p2HandBuildingReadyButton = findViewById<Button>(R.id.p2HandBuildingReadyButton)

        p1ChosenExtraCard1ImageButton = findViewById(R.id.p1ChosenExtraCard1ImageButton)
        p1ChosenExtraCard2ImageButton = findViewById(R.id.p1ChosenExtraCard2ImageButton)
        p1ChosenExtraCard3ImageButton = findViewById(R.id.p1ChosenExtraCard3ImageButton)


        p1ChosenExtraCard1ImageButton.setEnabled(false)
        p1ChosenExtraCard2ImageButton.setEnabled(false)
        p1ChosenExtraCard3ImageButton.setEnabled(false)

//        p1HandBuildingReadyButton.setOnClickListener {
//            player1Ready = true
//            checkReadyToStart()
//        }
//        p1HandBuildingReadyButton.setOnClickListener {
//            player2Ready = true
//            checkReadyToStart()
//        }

        p1AvailableExtraCard1ImageButton.setOnClickListener{
            var chosenValue = 1
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard1ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard2ImageButton.setOnClickListener{
            var chosenValue = 2
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard2ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard3ImageButton.setOnClickListener{
            var chosenValue = 3
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard3ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard4ImageButton.setOnClickListener{
            var chosenValue = 4
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard4ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard5ImageButton.setOnClickListener{
            var chosenValue = 5
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard5ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard6ImageButton.setOnClickListener{
            var chosenValue = -1
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard6ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard7ImageButton.setOnClickListener{
            var chosenValue = -2
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard7ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard8ImageButton.setOnClickListener{
            var chosenValue = -3
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard8ImageButton.setEnabled(false)
        }
        p1AvailableExtraCard9ImageButton.setOnClickListener{
            var chosenValue = -4
            chooseCardAsExtra(chosenValue)
            setCardImage()
            p1AvailableExtraCard9ImageButton.setEnabled(false)
        }



//        var textView = findViewById<TextView>(R.id.textView)
//        textView.text= player1Name

    }

//    fun checkReadyToStart(){
//        if(player1Ready == true && player2Ready == true){
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("player1Name", player1Name)
//            intent.putExtra("player2Name", player2Name)
//            intent.putExtra("chosenExtraCard1Value",chosenExtraCard1Value)
//            intent.putExtra("chosenExtraCard2Value",chosenExtraCard2Value)
//            intent.putExtra("chosenExtraCard3Value",chosenExtraCard3Value)
//            startActivity(intent)
//        }
//    }

    fun chooseCardAsExtra(cardValue: Int) {
        if (chosenExtraCard1Value == 0) {
            chosenExtraCard1Value = cardValue
        } else if (chosenExtraCard2Value == 0) {
            chosenExtraCard2Value = cardValue
        } else if (chosenExtraCard3Value == 0) {
            chosenExtraCard3Value = cardValue
        }
    }

    fun setCardImage(){
        when (chosenExtraCard1Value){

            1->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d1)
            }
            2->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d2)
            }
            3->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d3)
            }
            4->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d4)
            }
            5->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d5)
            }
            -1->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d6)
            }
            -2->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d7)
            }
            -3->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d8)
            }
            -4->{
                p1ChosenExtraCard1ImageButton.setImageResource(R.drawable.d9)
            }

        }

        when (chosenExtraCard2Value){

            1->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d1)
            }
            2->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d2)
            }
            3->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d3)
            }
            4->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d4)
            }
            5->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d5)
            }
            -1->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d6)
            }
            -2->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d7)
            }
            -3->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d8)
            }
            -4->{
                p1ChosenExtraCard2ImageButton.setImageResource(R.drawable.d9)
            }

        }

        when (chosenExtraCard3Value){

            1->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d1)
            }
            2->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d2)
            }
            3->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d3)
            }
            4->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d4)
            }
            5->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d5)
            }
            -1->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d6)
            }
            -2->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d7)
            }
            -3->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d8)
            }
            -4->{
                p1ChosenExtraCard3ImageButton.setImageResource(R.drawable.d9)
            }

        }

    }

}