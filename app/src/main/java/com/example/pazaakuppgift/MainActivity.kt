package com.example.pazaakuppgift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var p1TurnCount = 1
    lateinit var p1CardOneImageView : ImageView
    lateinit var p1CardTwoImageView : ImageView
    lateinit var p1CardThreeImageView : ImageView
    lateinit var p1CardFourImageView : ImageView
    lateinit var p1CardFiveImageView : ImageView
    lateinit var p1CardSixImageView : ImageView
    lateinit var p1CardSevenImageView : ImageView
    lateinit var p1CardEightImageView : ImageView
    lateinit var p1CardNineImageView : ImageView
    lateinit var p1ScoreTextView : TextView
    lateinit var p1EndTurnButton: Button
    lateinit var p1ExtraCard1ImageButton: ImageButton
    lateinit var p1ExtraCard2ImageButton: ImageButton
    lateinit var p1ExtraCard3ImageButton: ImageButton

    var p1Score = 0
    var p1Round1Score = 0
    var p1Round2Score = 0
    var p1Round3Score = 0
    var p1Round4Score = 0
    var p1Round5Score = 0
    var p1Round6Score = 0
    var p1Round7Score = 0
    var p1Round8Score = 0
    var p1Round9Score = 0

    var p1ExtraCard1Value = 0
    var p1ExtraCard2Value = 0
    var p1ExtraCard3Value = 0

    var p1ExtraCard1UsedValue = 0
    var p1ExtraCard2UsedValue = 0
    var p1ExtraCard3UsedValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        p1CardOneImageView = findViewById(R.id.p1CardOneImageView)
        p1CardTwoImageView = findViewById(R.id.p1CardTwoImageView)
        p1CardThreeImageView = findViewById(R.id.p1CardThreeImageView)
        p1CardFourImageView = findViewById(R.id.p1CardFourImageView)
        p1CardFiveImageView = findViewById(R.id.p1CardFiveImageView)
        p1CardSixImageView = findViewById(R.id.p1CardSixImageView)
        p1CardSevenImageView = findViewById(R.id.p1CardSevenImageView)
        p1CardEightImageView = findViewById(R.id.p1CardEightImageView)
        p1CardNineImageView = findViewById(R.id.p1CardNineImageView)

        p1EndTurnButton = findViewById<Button>(R.id.p1EndTurnButton)
        val p1StandButton = findViewById<Button>(R.id.p1StandButton)
        p1ScoreTextView = findViewById(R.id.p1ScoreTextView)

        p1ExtraCard1ImageButton = findViewById(R.id.p1ExtraCard1ImageButton)
        p1ExtraCard2ImageButton = findViewById(R.id.p1ExtraCard2ImageButton)
        p1ExtraCard3ImageButton = findViewById(R.id.p1ExtraCard3ImageButton)



        p1EndTurnButton.setOnClickListener {
            p1EndTurnButtonPress()
            calculateScore()
        }

        p1StandButton.setOnClickListener{
            p1StandButtonPress()
        }

        p1ExtraCard1ImageButton.setOnClickListener{
            p1ExtraCard1Value = 3
            p1ExtraCardImageButtonPressed(p1ExtraCard1Value)
            p1ExtraCard1Value = 0
            p1ExtraCard1ImageButton.setEnabled(false)
            calculateScore()
        }

        p1ExtraCard2ImageButton.setOnClickListener{
            p1ExtraCardImageButtonPressed(p1ExtraCard2Value)
            p1ExtraCard2Value = 0
            p1ExtraCard2ImageButton.setEnabled(false)
            calculateScore()
        }

        p1ExtraCard3ImageButton.setOnClickListener{
            p1ExtraCardImageButtonPressed(p1ExtraCard3Value)
            p1ExtraCard3Value = 0
            p1ExtraCard3ImageButton.setEnabled(false)
            calculateScore()
        }


    }




    fun calculateScore(){
        p1Score = p1Round1Score + p1Round2Score + p1Round3Score + p1Round4Score + p1Round5Score + p1Round6Score + p1Round7Score + p1Round8Score + p1Round9Score + p1ExtraCard1UsedValue + p1ExtraCard2UsedValue + p1ExtraCard3UsedValue
        p1ScoreTextView.text = p1Score.toString()
    }

    fun p1StandButtonPress(){
         p1EndTurnButton.setEnabled(false)
    }


    fun p1ExtraCardImageButtonPressed(cardValue: Int): Int{

        when(p1TurnCount){


            1-> {
                when(cardValue){
                    1->{
                        p1CardOneImageView.setImageResource(R.drawable.d1)
                    }
                    2->{
                        p1CardOneImageView.setImageResource(R.drawable.d2)
                    }
                    3->{
                        p1CardOneImageView.setImageResource(R.drawable.d3)
                    }
                    4->{
                        p1CardOneImageView.setImageResource(R.drawable.d4)
                    }
                    5->{
                        p1CardOneImageView.setImageResource(R.drawable.d5)
                    }
                    -1->{
                        p1CardOneImageView.setImageResource(R.drawable.d6)
                    }
                    -2->{
                        p1CardOneImageView.setImageResource(R.drawable.d7)
                    }
                    -3->{
                        p1CardOneImageView.setImageResource(R.drawable.d8)
                    }
                    -4->{
                        p1CardOneImageView.setImageResource(R.drawable.d9)
                    }
                    -5->{
                        p1CardOneImageView.setImageResource(R.drawable.d10)
                    }


                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }


            }

            2-> {
                when(cardValue) {
                    1 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }
            }

            3-> {
                when(cardValue) {
                    1 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }
            }

            4-> {
                when(cardValue) {
                    1 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }
            }

            5-> {
                when(cardValue) {
                    1 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }
            }

            6-> {
                when(cardValue) {
                    1 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }
            }

            7->{
                when(cardValue) {
                    1 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }

            }

            8->{
                when(cardValue) {
                    1 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }
            }

            9->{
                when(cardValue) {
                    1 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d10)
                    }
                }
                if ((p1ExtraCard1Value < 0) || (p1ExtraCard1Value > 0)){
                    p1ExtraCard1UsedValue = p1ExtraCard1Value
                }
                if ((p1ExtraCard2Value < 0) || (p1ExtraCard2Value > 0)){
                    p1ExtraCard2UsedValue = p1ExtraCard2Value
                }
                if ((p1ExtraCard3Value < 0) || (p1ExtraCard3Value > 0)){
                    p1ExtraCard3UsedValue = p1ExtraCard3Value
                }
            }
        }

        return p1TurnCount++
    }








    fun p1EndTurnButtonPress(): Int{
        var cardValue = (1..10).random()

        when(p1TurnCount){


            1-> {
                when(cardValue){
                    1->{
                        p1CardOneImageView.setImageResource(R.drawable.d1)
                    }
                    2->{
                        p1CardOneImageView.setImageResource(R.drawable.d2)
                    }
                    3->{
                        p1CardOneImageView.setImageResource(R.drawable.d3)
                    }
                    4->{
                        p1CardOneImageView.setImageResource(R.drawable.d4)
                    }
                    5->{
                        p1CardOneImageView.setImageResource(R.drawable.d5)
                    }
                    6->{
                        p1CardOneImageView.setImageResource(R.drawable.d6)
                    }
                    7->{
                        p1CardOneImageView.setImageResource(R.drawable.d7)
                    }
                    8->{
                        p1CardOneImageView.setImageResource(R.drawable.d8)
                    }
                    9->{
                        p1CardOneImageView.setImageResource(R.drawable.d9)
                    }
                    10->{
                        p1CardOneImageView.setImageResource(R.drawable.d10)
                    }


                }
                p1Round1Score = cardValue
            }

            2-> {
                when(cardValue) {
                    1 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardTwoImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round2Score = cardValue
            }

            3-> {
                when(cardValue) {
                    1 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardThreeImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round3Score = cardValue
            }

            4-> {
                when(cardValue) {
                    1 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardFourImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round4Score = cardValue
            }

            5-> {
                when(cardValue) {
                    1 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardFiveImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round5Score = cardValue
            }

            6-> {
                when(cardValue) {
                    1 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardSixImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round6Score = cardValue
            }

            7->{
                when(cardValue) {
                    1 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardSevenImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round7Score = cardValue

            }

            8->{
                when(cardValue) {
                    1 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardEightImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round8Score = cardValue
            }

            9->{
                when(cardValue) {
                    1 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d1)
                    }
                    2 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d2)
                    }
                    3 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d3)
                    }
                    4 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d4)
                    }
                    5 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d5)
                    }
                    6 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d6)
                    }
                    7 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d7)
                    }
                    8 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d8)
                    }
                    9 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d9)
                    }
                    10 -> {
                        p1CardNineImageView.setImageResource(R.drawable.d10)
                    }
                }
                p1Round9Score = cardValue
            }
        }



        return p1TurnCount++
    }




}