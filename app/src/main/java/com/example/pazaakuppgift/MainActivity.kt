package com.example.pazaakuppgift

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    //Turn counter that keeps track of the next card position
    var p1TurnCount = 1
    var p2TurnCount = 1

    //lateinit of the card slots that will change image each round
    lateinit var p1CardOneImageView: ImageView
    lateinit var p1CardTwoImageView: ImageView
    lateinit var p1CardThreeImageView: ImageView
    lateinit var p1CardFourImageView: ImageView
    lateinit var p1CardFiveImageView: ImageView
    lateinit var p1CardSixImageView: ImageView
    lateinit var p1CardSevenImageView: ImageView
    lateinit var p1CardEightImageView: ImageView
    lateinit var p1CardNineImageView: ImageView
    lateinit var p2CardOneImageView: ImageView
    lateinit var p2CardTwoImageView: ImageView
    lateinit var p2CardThreeImageView: ImageView
    lateinit var p2CardFourImageView: ImageView
    lateinit var p2CardFiveImageView: ImageView
    lateinit var p2CardSixImageView: ImageView
    lateinit var p2CardSevenImageView: ImageView
    lateinit var p2CardEightImageView: ImageView
    lateinit var p2CardNineImageView: ImageView

    //lateinit of the visible total card value of the boar
    lateinit var p1BoardValueTextView: TextView
    lateinit var p2BoardValueTextView: TextView

    //lateinit of the end turn button that increases the turn value and adds an extra card
    lateinit var p1EndTurnButton: Button
    lateinit var p2EndTurnButton: Button

    //lateinit of buttons that end the current round for player is they want to stand on the current total card value
    lateinit var p1StandButton: Button
    lateinit var p2StandButton: Button

    //lateinit of the extra cards that were chosen during the hand building activity and can be added to the board
    lateinit var p1ExtraCard1ImageButton: ImageButton
    lateinit var p1ExtraCard2ImageButton: ImageButton
    lateinit var p1ExtraCard3ImageButton: ImageButton
    lateinit var p2ExtraCard1ImageButton: ImageButton
    lateinit var p2ExtraCard2ImageButton: ImageButton
    lateinit var p2ExtraCard3ImageButton: ImageButton

    // variable that keeps check of the score for each player
    var p1TotalValue = 0
    var p2TotalValue = 0

    //variables that keep check of the card value each player round so that it can be added up to a visible total
    var p1Round1Value = 0
    var p1Round2Value = 0
    var p1Round3Value = 0
    var p1Round4Value = 0
    var p1Round5Value = 0
    var p1Round6Value = 0
    var p1Round7Value = 0
    var p1Round8Value = 0
    var p1Round9Value = 0
    var p2Round1Value = 0
    var p2Round2Value = 0
    var p2Round3Value = 0
    var p2Round4Value = 0
    var p2Round5Value = 0
    var p2Round6Value = 0
    var p2Round7Value = 0
    var p2Round8Value = 0
    var p2Round9Value = 0



    // variable for the chosen extra cards from hand building
    // needed to assign the images to hand before they are used
    var p1ChosenExtraCard1Value = 0
    var p1ChosenExtraCard2Value = 0
    var p1ChosenExtraCard3Value = 0
    var p2ChosenExtraCard1Value = 0
    var p2ChosenExtraCard2Value = 0
    var p2ChosenExtraCard3Value = 0

    // variable that takes in the card value of the chosen extra
    // cards when they are used and adds it to the total value counter
    var p1ExtraCard1Value = 0
    var p1ExtraCard2Value = 0
    var p1ExtraCard3Value = 0
    var p2ExtraCard1Value = 0
    var p2ExtraCard2Value = 0
    var p2ExtraCard3Value = 0


    //Default player names if none have been chosen
    var player1Name = "Player 1"
    var player2Name = "Player 2"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //locks the activity in landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        p1CardOneImageView = findViewById(R.id.p1CardOneImageView)
        p1CardTwoImageView = findViewById(R.id.p1CardTwoImageView)
        p1CardThreeImageView = findViewById(R.id.p1CardThreeImageView)
        p1CardFourImageView = findViewById(R.id.p1CardFourImageView)
        p1CardFiveImageView = findViewById(R.id.p1CardFiveImageView)
        p1CardSixImageView = findViewById(R.id.p1CardSixImageView)
        p1CardSevenImageView = findViewById(R.id.p1CardSevenImageView)
        p1CardEightImageView = findViewById(R.id.p1CardEightImageView)
        p1CardNineImageView = findViewById(R.id.p1CardNineImageView)
        p2CardOneImageView = findViewById(R.id.p2CardOneImageView)
        p2CardTwoImageView = findViewById(R.id.p2CardTwoImageView)
        p2CardThreeImageView = findViewById(R.id.p2CardThreeImageView)
        p2CardFourImageView = findViewById(R.id.p2CardFourImageView)
        p2CardFiveImageView = findViewById(R.id.p2CardFiveImageView)
        p2CardSixImageView = findViewById(R.id.p2CardSixImageView)
        p2CardSevenImageView = findViewById(R.id.p2CardSevenImageView)
        p2CardEightImageView = findViewById(R.id.p2CardEightImageView)
        p2CardNineImageView = findViewById(R.id.p2CardNineImageView)

        p1EndTurnButton = findViewById(R.id.p1EndTurnButton)
        p2EndTurnButton = findViewById(R.id.p2EndTurnButton)

        p1BoardValueTextView = findViewById(R.id.p1BoardValueTextView)
        p2BoardValueTextView = findViewById(R.id.p2BoardValueTextView)

        p1ExtraCard1ImageButton = findViewById(R.id.p1ExtraCard1ImageButton)
        p1ExtraCard2ImageButton = findViewById(R.id.p1ExtraCard2ImageButton)
        p1ExtraCard3ImageButton = findViewById(R.id.p1ExtraCard3ImageButton)
        p2ExtraCard1ImageButton = findViewById(R.id.p2ExtraCard1ImageButton)
        p2ExtraCard2ImageButton = findViewById(R.id.p2ExtraCard2ImageButton)
        p2ExtraCard3ImageButton = findViewById(R.id.p2ExtraCard3ImageButton)

        p1StandButton = findViewById(R.id.p1StandButton)
        p2StandButton = findViewById(R.id.p2StandButton)

        //player names fetched from the last activity if they have been submitted
        // chosen extra card values fetched and stored
        player1Name = intent.getStringExtra("player1Name").toString()
        player2Name = intent.getStringExtra("player2Name").toString()
        p1ChosenExtraCard1Value = intent.getIntExtra("p1ChosenExtraCard1Value", 1)
        p1ChosenExtraCard2Value = intent.getIntExtra("p1ChosenExtraCard2Value", 4)
        p1ChosenExtraCard3Value = intent.getIntExtra("p1ChosenExtraCard3Value", -3)
        p2ChosenExtraCard1Value = intent.getIntExtra("p2ChosenExtraCard1Value", 1)
        p2ChosenExtraCard2Value = intent.getIntExtra("p2ChosenExtraCard2Value", 4)
        p2ChosenExtraCard3Value = intent.getIntExtra("p2ChosenExtraCard3Value", -3)


        //assign the extra card images based on the ones picked in hand building
        assignExtraCardImages()

        // ends player turn and randomizes a new card on the board
        // Score gets calculated
        // Turn counter goes up since turn ended
        p1EndTurnButton.setOnClickListener {
            var playerValue = 1
            EndTurnButtonPress(playerValue)
            calculateTotalValue()
            p1TurnCount++
        }
        p2EndTurnButton.setOnClickListener {
            var playerValue = 2
            EndTurnButtonPress(playerValue)
            calculateTotalValue()
            p2TurnCount++
        }


        // Stand button that disables end turn button and waits for the other player to finish
        p1StandButton.setOnClickListener {
            var playerValue = 1
            standButtonPress(playerValue)
        }
        p2StandButton.setOnClickListener {
            var playerValue = 2
            standButtonPress(playerValue)
        }


        // Extra card buttons that check if the extra card has been pressed
        // The button gets disabled for the rest of the game
        //Image gets replaced with color
        // Adds the used card value to the visible total card value
        p1ExtraCard1ImageButton.setOnClickListener {
            var playerValue = 1
            p1ExtraCard1Value = p1ChosenExtraCard1Value
            ExtraCardPressed(playerValue, p1ExtraCard1Value)
            p1ExtraCard1ImageButton.setEnabled(false)
            p1ExtraCard1ImageButton.setColorFilter(resources.getColor(androidx.appcompat.R.color.material_grey_50))
            calculateTotalValue()
            p1TurnCount++
        }
        p1ExtraCard2ImageButton.setOnClickListener {
            var playerValue = 1
            p1ExtraCard2Value = p1ChosenExtraCard2Value
            ExtraCardPressed(playerValue, p1ExtraCard2Value)
            p1ExtraCard2ImageButton.setEnabled(false)
            p1ExtraCard2ImageButton.setColorFilter(resources.getColor(androidx.appcompat.R.color.material_grey_50))
            calculateTotalValue()
            p1TurnCount++
        }
        p1ExtraCard3ImageButton.setOnClickListener {
            var playerValue = 1
            p1ExtraCard3Value = p1ChosenExtraCard3Value
            ExtraCardPressed(playerValue, p1ExtraCard3Value)
            p1ExtraCard3ImageButton.setEnabled(false)
            p1ExtraCard3ImageButton.setColorFilter(resources.getColor(androidx.appcompat.R.color.material_grey_50))
            calculateTotalValue()
            p1TurnCount++
        }
        p2ExtraCard1ImageButton.setOnClickListener {
            var playerValue = 2
            p2ExtraCard1Value = p2ChosenExtraCard1Value
            ExtraCardPressed(playerValue, p2ExtraCard1Value)
            p2ExtraCard1ImageButton.setEnabled(false)
            p2ExtraCard1ImageButton.setColorFilter(resources.getColor(androidx.appcompat.R.color.material_grey_50))
            calculateTotalValue()
            p2TurnCount++
        }
        p2ExtraCard2ImageButton.setOnClickListener {
            var playerValue = 2
            p2ExtraCard2Value = p2ChosenExtraCard2Value
            ExtraCardPressed(playerValue, p2ExtraCard2Value)
            p2ExtraCard2ImageButton.setEnabled(false)
            p2ExtraCard2ImageButton.setColorFilter(resources.getColor(androidx.appcompat.R.color.material_grey_50))
            calculateTotalValue()
            p2TurnCount++
        }
        p2ExtraCard3ImageButton.setOnClickListener {
            var playerValue = 2
            p2ExtraCard3Value = p2ChosenExtraCard3Value
            ExtraCardPressed(playerValue, p2ExtraCard3Value)
            p2ExtraCard3ImageButton.setEnabled(false)
            p2ExtraCard3ImageButton.setColorFilter(resources.getColor(androidx.appcompat.R.color.material_grey_50))
            calculateTotalValue()
            p2TurnCount++
        }


    }

//    fun addUsedExtraToTotalValue(){
//        // checks if any of the extra cards have been used by checking if they have been given a value
//        if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)) {
//            p1ExtraCard1UsedValue = p1ExtraCard1Value
//        }
//        if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)) {
//            p1ExtraCard2UsedValue = p1ExtraCard2Value
//        }
//        if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)) {
//            p1ExtraCard3UsedValue = p1ExtraCard3Value
//        }
//
//        if ((p2ExtraCard1Value < 0) || (p2ExtraCard1Value > 0)) {
//            p2ExtraCard1UsedValue = p2ExtraCard1Value
//        }
//        if ((p2ExtraCard2Value < 0) || (p2ExtraCard2Value > 0)) {
//            p2ExtraCard2UsedValue = p2ExtraCard2Value
//        }
//        if ((p2ExtraCard3Value < 0) || (p2ExtraCard3Value > 0)) {
//            p2ExtraCard3UsedValue = p2ExtraCard3Value
//        }
//    }

    fun calculateTotalValue() {
        //Calculates the total value of cards on the board every time a card gets used

        p1TotalValue = p1Round1Value + p1Round2Value + p1Round3Value + p1Round4Value + p1Round5Value + p1Round6Value + p1Round7Value + p1Round8Value + p1Round9Value + p1ExtraCard1Value + p1ExtraCard2Value + p1ExtraCard3Value
        p1BoardValueTextView.text = p1TotalValue.toString()

        p2TotalValue = p2Round1Value + p2Round2Value + p2Round3Value + p2Round4Value + p2Round5Value + p2Round6Value + p2Round7Value + p2Round8Value + p2Round9Value + p2ExtraCard1Value + p2ExtraCard2Value + p2ExtraCard3Value
        p2BoardValueTextView.text = p2TotalValue.toString()

    }

    fun standButtonPress(playerValue: Int) {
        if (playerValue == 1) {
            p1EndTurnButton.setEnabled(false)
        } else if (playerValue == 2) {
            p2EndTurnButton.setEnabled(false)
        }

    }



    fun ExtraCardPressed(playerValue: Int, cardValue: Int){
        if (playerValue == 1) {
            when (p1TurnCount) {

                1 -> {
                    when (cardValue) {
                        1 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardplus4)

                        }
                        5 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                                p1CardOneImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {

                                p1CardOneImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                      -5->{
//                          p1CardOneImageView.setImageResource(R.drawable.extracardminus4)
//                       }


                    }
                }

                2 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                      -5->{
//                        p1CardTwoImageView.setImageResource(R.drawable.extracardminus4)
//                      }
                    }
                }

                3 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p1CardThreeImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                4 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardFourImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p1CardFourImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                5 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p1CardFiveImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                6 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardSixImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p1CardSixImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                7 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p1CardSevenImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                8 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardEightImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p1CardEightImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                9 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p1CardNineImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p1CardNineImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }
            }
        }


        if (playerValue == 2) {
            when (p2TurnCount) {

                1 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardplus4)

                        }
                        5 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardOneImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {

                            p2CardOneImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                      -5->{
//                          p2CardOneImageView.setImageResource(R.drawable.extracardminus4)
//                       }


                    }
                }

                2 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                      -5->{
//                        p2CardTwoImageView.setImageResource(R.drawable.extracardminus4)
//                      }
                    }
                }

                3 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p2CardThreeImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                4 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardFourImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p2CardFourImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                5 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p2CardFiveImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                6 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardSixImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p2CardSixImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                7 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p2CardSevenImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                8 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardEightImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p2CardEightImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }

                9 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardplus1)
                        }
                        2 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardplus2)
                        }
                        3 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardplus3)
                        }
                        4 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardplus4)
                        }
                        5 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardplus5)
                        }
                        -1 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardminus1)
                        }
                        -2 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardminus2)
                        }
                        -3 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardminus3)
                        }
                        -4 -> {
                            p2CardNineImageView.setImageResource(R.drawable.extracardminus4)
                        }
//                    -5->{
//                        p2CardNineImageView.setImageResource(R.drawable.extracardminus4)
//                    }
                    }
                }
            }
        }
    }


    fun EndTurnButtonPress(playerValue: Int){
        var cardValue = (1..10).random()

        if(playerValue == 1) {
            when (p1TurnCount) {

                1 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardOneImageView.setImageResource(R.drawable.normalcard10)
                        }


                    }
                    p1Round1Value = cardValue
                }

                2 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardTwoImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round2Value = cardValue
                }

                3 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardThreeImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round3Value = cardValue
                }

                4 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardFourImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round4Value = cardValue
                }

                5 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardFiveImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round5Value = cardValue
                }

                6 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardSixImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round6Value = cardValue
                }

                7 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardSevenImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round7Value = cardValue

                }

                8 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardEightImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round8Value = cardValue
                }

                9 -> {
                    when (cardValue) {
                        1 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p1CardNineImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p1Round9Value = cardValue
                }
            }
        }


        if(playerValue == 2) {
            when (p2TurnCount) {

                1 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardOneImageView.setImageResource(R.drawable.normalcard10)
                        }


                    }
                    p2Round1Value = cardValue
                }

                2 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardTwoImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round2Value = cardValue
                }

                3 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardThreeImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round3Value = cardValue
                }

                4 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardFourImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round4Value = cardValue
                }

                5 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardFiveImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round5Value = cardValue
                }

                6 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardSixImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round6Value = cardValue
                }

                7 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardSevenImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round7Value = cardValue

                }

                8 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardEightImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round8Value = cardValue
                }

                9 -> {
                    when (cardValue) {
                        1 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard1)
                        }
                        2 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard2)
                        }
                        3 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard3)
                        }
                        4 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard4)
                        }
                        5 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard5)
                        }
                        6 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard6)
                        }
                        7 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard7)
                        }
                        8 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard8)
                        }
                        9 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard9)
                        }
                        10 -> {
                            p2CardNineImageView.setImageResource(R.drawable.normalcard10)
                        }
                    }
                    p2Round9Value = cardValue
                }
            }
        }
    }


    fun assignExtraCardImages(){
        // assigning the extra card images based on the value of the ones picked in hand building activity
        // Player 1

        when(p1ChosenExtraCard1Value){
            1->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus1)
            }
            2->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus2)
            }
            3->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus3)
            }
            4->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus4)
            }
            5->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus5)
            }
            -1->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus1)
            }
            -2->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus2)
            }
            -3->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus3)
            }
            -4->{
                p1ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus4)
            }
        }
        when(p1ChosenExtraCard2Value){
            1->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus1)
            }
            2->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus2)
            }
            3->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus3)
            }
            4->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus4)
            }
            5->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus5)
            }
            -1->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus1)
            }
            -2->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus2)
            }
            -3->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus3)
            }
            -4->{
                p1ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus4)
            }
        }
        when(p1ChosenExtraCard3Value){
            1->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus1)
            }
            2->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus2)
            }
            3->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus3)
            }
            4->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus4)
            }
            5->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus5)
            }
            -1->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus1)
            }
            -2->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus2)
            }
            -3->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus3)
            }
            -4->{
                p1ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus4)
            }
        }



        //Player 2
        when(p2ChosenExtraCard1Value){
            1->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus1)
            }
            2->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus2)
            }
            3->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus3)
            }
            4->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus4)
            }
            5->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardplus5)
            }
            -1->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus1)
            }
            -2->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus2)
            }
            -3->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus3)
            }
            -4->{
                p2ExtraCard1ImageButton.setImageResource(R.drawable.extracardminus4)
            }
        }
        when(p2ChosenExtraCard2Value){
            1->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus1)
            }
            2->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus2)
            }
            3->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus3)
            }
            4->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus4)
            }
            5->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardplus5)
            }
            -1->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus1)
            }
            -2->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus2)
            }
            -3->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus3)
            }
            -4->{
                p2ExtraCard2ImageButton.setImageResource(R.drawable.extracardminus4)
            }
        }
        when(p1ChosenExtraCard3Value){
            1->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus1)
            }
            2->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus2)
            }
            3->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus3)
            }
            4->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus4)
            }
            5->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardplus5)
            }
            -1->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus1)
            }
            -2->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus2)
            }
            -3->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus3)
            }
            -4->{
                p2ExtraCard3ImageButton.setImageResource(R.drawable.extracardminus4)
            }
        }


    }

}