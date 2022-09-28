package com.example.pazaakuppgift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout


class HandBuildingActivity : AppCompatActivity() {
    // lateinit of clickable extra cards
     lateinit var p1AvailableExtraCard1ImageButton: ImageButton
     lateinit var p1AvailableExtraCard2ImageButton: ImageButton
     lateinit var p1AvailableExtraCard3ImageButton: ImageButton
     lateinit var p1AvailableExtraCard4ImageButton: ImageButton
     lateinit var p1AvailableExtraCard5ImageButton: ImageButton
     lateinit var p1AvailableExtraCard6ImageButton: ImageButton
     lateinit var p1AvailableExtraCard7ImageButton: ImageButton
     lateinit var p1AvailableExtraCard8ImageButton: ImageButton
     lateinit var p1AvailableExtraCard9ImageButton: ImageButton
     lateinit var p2AvailableExtraCard1ImageButton: ImageButton
     lateinit var p2AvailableExtraCard2ImageButton: ImageButton
     lateinit var p2AvailableExtraCard3ImageButton: ImageButton
     lateinit var p2AvailableExtraCard4ImageButton: ImageButton
     lateinit var p2AvailableExtraCard5ImageButton: ImageButton
     lateinit var p2AvailableExtraCard6ImageButton: ImageButton
     lateinit var p2AvailableExtraCard7ImageButton: ImageButton
     lateinit var p2AvailableExtraCard8ImageButton: ImageButton
     lateinit var p2AvailableExtraCard9ImageButton: ImageButton

    //     lateinit of the cards the players choose
    lateinit var p1ChosenExtraCard1ImageButton: ImageButton
    lateinit var p1ChosenExtraCard2ImageButton: ImageButton
    lateinit var p1ChosenExtraCard3ImageButton: ImageButton
    lateinit var p2ChosenExtraCard1ImageButton: ImageButton
    lateinit var p2ChosenExtraCard2ImageButton: ImageButton
    lateinit var p2ChosenExtraCard3ImageButton: ImageButton

    //    lateinit of the ready buttons
    lateinit var p1HandBuildingReadyButton: Button
    lateinit var p2HandBuildingReadyButton: Button


    //  boolean variable to check if player are ready to start game
    var player1Ready = false
    var player2Ready = false

    //  variables that keep track of the chosen value of the extra cards
    var p1ChosenExtraCard1Value = 0
    var p1ChosenExtraCard2Value = 0
    var p1ChosenExtraCard3Value = 0
    var p2ChosenExtraCard1Value = 0
    var p2ChosenExtraCard2Value = 0
    var p2ChosenExtraCard3Value = 0

    // placeholder player names if the player does not submit a name
    var player1Name = "Player 1"
    var player2Name = "Player 2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hand_building)
        // finding the id of elements in the layout
        p1AvailableExtraCard1ImageButton = findViewById(R.id.p1AvailableExtraCard1ImageButton)
        p1AvailableExtraCard2ImageButton = findViewById(R.id.p1AvailableExtraCard2ImageButton)
        p1AvailableExtraCard3ImageButton = findViewById(R.id.p1AvailableExtraCard3ImageButton)
        p1AvailableExtraCard4ImageButton = findViewById(R.id.p1AvailableExtraCard4ImageButton)
        p1AvailableExtraCard5ImageButton = findViewById(R.id.p1AvailableExtraCard5ImageButton)
        p1AvailableExtraCard6ImageButton = findViewById(R.id.p1AvailableExtraCard6ImageButton)
        p1AvailableExtraCard7ImageButton = findViewById(R.id.p1AvailableExtraCard7ImageButton)
        p1AvailableExtraCard8ImageButton = findViewById(R.id.p1AvailableExtraCard8ImageButton)
        p1AvailableExtraCard9ImageButton = findViewById(R.id.p1AvailableExtraCard9ImageButton)
        p2AvailableExtraCard1ImageButton = findViewById(R.id.p2AvailableExtraCard1ImageButton)
        p2AvailableExtraCard2ImageButton = findViewById(R.id.p2AvailableExtraCard2ImageButton)
        p2AvailableExtraCard3ImageButton = findViewById(R.id.p2AvailableExtraCard3ImageButton)
        p2AvailableExtraCard4ImageButton = findViewById(R.id.p2AvailableExtraCard4ImageButton)
        p2AvailableExtraCard5ImageButton = findViewById(R.id.p2AvailableExtraCard5ImageButton)
        p2AvailableExtraCard6ImageButton = findViewById(R.id.p2AvailableExtraCard6ImageButton)
        p2AvailableExtraCard7ImageButton = findViewById(R.id.p2AvailableExtraCard7ImageButton)
        p2AvailableExtraCard8ImageButton = findViewById(R.id.p2AvailableExtraCard8ImageButton)
        p2AvailableExtraCard9ImageButton = findViewById(R.id.p2AvailableExtraCard9ImageButton)

        var player1NameTextView = findViewById<TextView>(R.id.player1NameTextView)
        var player2NameTextView = findViewById<TextView>(R.id.player2NameTextVIew)

        p1HandBuildingReadyButton = findViewById(R.id.p1HandBuildingReadyButton)
        p2HandBuildingReadyButton = findViewById(R.id.p2HandBuildingReadyButton)

        p1ChosenExtraCard1ImageButton = findViewById(R.id.p1ChosenExtraCard1ImageButton)
        p1ChosenExtraCard2ImageButton = findViewById(R.id.p1ChosenExtraCard2ImageButton)
        p1ChosenExtraCard3ImageButton = findViewById(R.id.p1ChosenExtraCard3ImageButton)
        p2ChosenExtraCard1ImageButton = findViewById(R.id.p2ChosenExtraCard1ImageButton)
        p2ChosenExtraCard2ImageButton = findViewById(R.id.p2ChosenExtraCard2ImageButton)
        p2ChosenExtraCard3ImageButton = findViewById(R.id.p2ChosenExtraCard3ImageButton)



        //  clickable chosen extra cards. Disabled at the start because they have no chosen value
        p1ChosenExtraCard1ImageButton.setEnabled(false)
        p1ChosenExtraCard2ImageButton.setEnabled(false)
        p1ChosenExtraCard3ImageButton.setEnabled(false)
        p2ChosenExtraCard1ImageButton.setEnabled(false)
        p2ChosenExtraCard2ImageButton.setEnabled(false)
        p2ChosenExtraCard3ImageButton.setEnabled(false)

        //player names fetched from the last activity if they have been submitted
        player1Name = intent.getStringExtra("player1Name").toString()
        player2Name = intent.getStringExtra("player2Name").toString()


        // fetched player names put into the right TextView
        player1NameTextView.text = player1Name
        player2NameTextView.text = player2Name

        //  ready buttons disabled at start until players choose 3 cards
        p1HandBuildingReadyButton.setEnabled(false)
        p2HandBuildingReadyButton.setEnabled(false)

        //  ready buttons to start game when cards are picked, game starts when both are clicked
        //  buttons are disabled after being clicked
        p1HandBuildingReadyButton.setOnClickListener {
            player1Ready = true
            p1HandBuildingReadyButton.setEnabled(false)
            checkReadyToStart()
        }
        p2HandBuildingReadyButton.setOnClickListener {
            player2Ready = true
            p2HandBuildingReadyButton.setEnabled(false)
            checkReadyToStart()
        }
        //  clicking an available card picks it as one of the chosen extra cards
        // playerValue tells which player is clicking and chosenValue gives the card's value
        //  button is disabled after being chosen
        //  lastly checks if all extra cards have been chosen. If true, the ready button becomes available
        p1AvailableExtraCard1ImageButton.setOnClickListener{
            var chosenValue = 1
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard1ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)

        }
        p1AvailableExtraCard2ImageButton.setOnClickListener{
            var chosenValue = 2
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard2ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p1AvailableExtraCard3ImageButton.setOnClickListener{
            var chosenValue = 3
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard3ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p1AvailableExtraCard4ImageButton.setOnClickListener{
            var chosenValue = 4
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard4ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p1AvailableExtraCard5ImageButton.setOnClickListener{
            var chosenValue = 5
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard5ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p1AvailableExtraCard6ImageButton.setOnClickListener{
            var chosenValue = -1
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard6ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p1AvailableExtraCard7ImageButton.setOnClickListener{
            var chosenValue = -2
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard7ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p1AvailableExtraCard8ImageButton.setOnClickListener{
            var chosenValue = -3
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard8ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p1AvailableExtraCard9ImageButton.setOnClickListener{
            var chosenValue = -4
            var playerValue = 1
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p1AvailableExtraCard9ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }


        //  clicking an available card picks it as one of the chosen extra cards
        //  playerValue tells which player is clicking and chosenValue gives the card's value
        //  button is disabled after being chosen
        //  lastly checks if all extra cards have been chosen. If true, the ready button becomes available
        p2AvailableExtraCard1ImageButton.setOnClickListener{
            var chosenValue = 1
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard1ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)

        }
        p2AvailableExtraCard2ImageButton.setOnClickListener{
            var chosenValue = 2
            var playerValue = 2
            chooseCardAsExtra(chosenValue,playerValue)
            setCardImage()
            p2AvailableExtraCard2ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p2AvailableExtraCard3ImageButton.setOnClickListener{
            var chosenValue = 3
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard3ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p2AvailableExtraCard4ImageButton.setOnClickListener{
            var chosenValue = 4
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard4ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p2AvailableExtraCard5ImageButton.setOnClickListener{
            var chosenValue = 5
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard5ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p2AvailableExtraCard6ImageButton.setOnClickListener{
            var chosenValue = -1
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard6ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p2AvailableExtraCard7ImageButton.setOnClickListener{
            var chosenValue = -2
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard7ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p2AvailableExtraCard8ImageButton.setOnClickListener{
            var chosenValue = -3
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard8ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }
        p2AvailableExtraCard9ImageButton.setOnClickListener{
            var chosenValue = -4
            var playerValue = 2
            chooseCardAsExtra(chosenValue, playerValue)
            setCardImage()
            p2AvailableExtraCard9ImageButton.setEnabled(false)
            checkIfCardsReady(playerValue)
        }




        //  the chosen extra cards can be pressed to remove the chosen card in that spot
        //  the chosen extra card is enabled again
        //  the ready button is disabled again because the player doesnt have 3 cards
        //  the button is disabled since it has no value
        //  uses the given value from the picked card to set it
        //  playerValue tells which player it belongs to

        p1ChosenExtraCard1ImageButton.setOnClickListener{
            var currentValue = p1ChosenExtraCard1Value
            var playerValue = 1
            ReenableCards(playerValue, currentValue) 
            p1ChosenExtraCard1Value = 0
            setCardImage()
            checkIfCardsReady(playerValue)
            p1ChosenExtraCard1ImageButton.setEnabled(false)

        }

        p1ChosenExtraCard2ImageButton.setOnClickListener{
            var currentValue = p1ChosenExtraCard2Value
            var playerValue = 1
            ReenableCards(playerValue, currentValue)
            p1ChosenExtraCard2Value = 0
            setCardImage()
            checkIfCardsReady(playerValue)
            p1ChosenExtraCard2ImageButton.setEnabled(false)

        }

        p1ChosenExtraCard3ImageButton.setOnClickListener{
            var currentValue = p1ChosenExtraCard3Value
            var playerValue = 1
            ReenableCards(playerValue, currentValue)
            p1ChosenExtraCard3Value = 0
            setCardImage()
            checkIfCardsReady(playerValue)
            p1ChosenExtraCard3ImageButton.setEnabled(false)

        }

        p2ChosenExtraCard1ImageButton.setOnClickListener{
            var currentValue = p2ChosenExtraCard1Value
            var playerValue = 2
            ReenableCards(playerValue, currentValue)
            p2ChosenExtraCard1Value = 0
            setCardImage()
            checkIfCardsReady(playerValue)
            p2ChosenExtraCard1ImageButton.setEnabled(false)

        }

        p2ChosenExtraCard2ImageButton.setOnClickListener{
            var currentValue = p2ChosenExtraCard2Value
            var playerValue = 2
            ReenableCards(playerValue, currentValue)
            p2ChosenExtraCard2Value = 0
            setCardImage()
            checkIfCardsReady(playerValue)
            p2ChosenExtraCard2ImageButton.setEnabled(false)

        }

        p2ChosenExtraCard3ImageButton.setOnClickListener{
            var currentValue = p2ChosenExtraCard3Value
            var playerValue = 2
            ReenableCards(playerValue, currentValue)
            p2ChosenExtraCard3Value = 0
            setCardImage()
            checkIfCardsReady(playerValue)
            p2ChosenExtraCard3ImageButton.setEnabled(false)

        }


    }


    //  reenables cards if the card is removed from the chosen hand
    //  gets value from the removed card and also player value to know which player pressed
    fun ReenableCards(playerValue: Int, currentValue: Int){
        if (playerValue == 1){
                  when(currentValue){

                      1->{
                          p1AvailableExtraCard1ImageButton.setEnabled(true)
                      }
                      2->{
                          p1AvailableExtraCard2ImageButton.setEnabled(true)
                      }
                      3->{
                          p1AvailableExtraCard3ImageButton.setEnabled(true)
                      }
                      4->{
                          p1AvailableExtraCard4ImageButton.setEnabled(true)
                      }
                      5->{
                          p1AvailableExtraCard5ImageButton.setEnabled(true)
                      }
                      -1->{
                          p1AvailableExtraCard6ImageButton.setEnabled(true)
                      }
                      -2->{
                          p1AvailableExtraCard7ImageButton.setEnabled(true)
                      }
                      -3->{
                          p1AvailableExtraCard8ImageButton.setEnabled(true)
                      }
                      -4->{
                          p1AvailableExtraCard9ImageButton.setEnabled(true)
                      }
                  }
        }
        
        if (playerValue == 2){
                  when(currentValue){

                      1->{
                          p2AvailableExtraCard1ImageButton.setEnabled(true)
                      }
                      2->{
                          p2AvailableExtraCard2ImageButton.setEnabled(true)
                      }
                      3->{
                          p2AvailableExtraCard3ImageButton.setEnabled(true)
                      }
                      4->{
                          p2AvailableExtraCard4ImageButton.setEnabled(true)
                      }
                      5->{
                          p2AvailableExtraCard5ImageButton.setEnabled(true)
                      }
                      -1->{
                          p2AvailableExtraCard6ImageButton.setEnabled(true)
                      }
                      -2->{
                          p2AvailableExtraCard7ImageButton.setEnabled(true)
                      }
                      -3->{
                          p2AvailableExtraCard8ImageButton.setEnabled(true)
                      }
                      -4->{
                          p2AvailableExtraCard9ImageButton.setEnabled(true)
                      }
                  }
        }




    }
    //  checks if all 3 cards have been picked for the players hand.
    //  takes in playerValue to know which hand to check and to know which ready button to enable
    //  also disables ready button if card has been removed from hand
    fun checkIfCardsReady(playerValue: Int){

        if(playerValue == 1) {
            if (p1ChosenExtraCard1Value != 0 && p1ChosenExtraCard2Value != 0 && p1ChosenExtraCard3Value != 0) {
                p1HandBuildingReadyButton.setEnabled(true)
                lockCards(playerValue)
            } else {
                p1HandBuildingReadyButton.setEnabled(false)
                unlockCards(playerValue)
            }
        }else if(playerValue == 2) {
            if (p2ChosenExtraCard1Value != 0 && p2ChosenExtraCard2Value != 0 && p2ChosenExtraCard3Value != 0) {
                p2HandBuildingReadyButton.setEnabled(true)
                lockCards(playerValue)
            } else {
                p2HandBuildingReadyButton.setEnabled(false)
                unlockCards(playerValue)
            }
        }
    }

    //function to lock all cards if 3 have already been chosen

    fun lockCards(playerValue:Int){
        if (playerValue == 1){
            p1AvailableExtraCard1ImageButton.setEnabled(false)
            p1AvailableExtraCard2ImageButton.setEnabled(false)
            p1AvailableExtraCard3ImageButton.setEnabled(false)
            p1AvailableExtraCard4ImageButton.setEnabled(false)
            p1AvailableExtraCard5ImageButton.setEnabled(false)
            p1AvailableExtraCard6ImageButton.setEnabled(false)
            p1AvailableExtraCard7ImageButton.setEnabled(false)
            p1AvailableExtraCard8ImageButton.setEnabled(false)
            p1AvailableExtraCard9ImageButton.setEnabled(false)
        }else if(playerValue == 2){
            p2AvailableExtraCard1ImageButton.setEnabled(false)
            p2AvailableExtraCard2ImageButton.setEnabled(false)
            p2AvailableExtraCard3ImageButton.setEnabled(false)
            p2AvailableExtraCard4ImageButton.setEnabled(false)
            p2AvailableExtraCard5ImageButton.setEnabled(false)
            p2AvailableExtraCard6ImageButton.setEnabled(false)
            p2AvailableExtraCard7ImageButton.setEnabled(false)
            p2AvailableExtraCard8ImageButton.setEnabled(false)
            p2AvailableExtraCard9ImageButton.setEnabled(false)
        }

    }


    //Function to unlock cards if one card in hand gets unpicked
    // Checks value of other cards in hand to not reenable an already picked card

    fun unlockCards(playerValue: Int){
        if(playerValue == 1){

            if(p1ChosenExtraCard1Value !=1 && p2ChosenExtraCard2Value !=1 && p1ChosenExtraCard3Value != 1){
                p1AvailableExtraCard1ImageButton.setEnabled(true)
            }
            if (p1ChosenExtraCard1Value !=2 && p1ChosenExtraCard2Value !=2 && p1ChosenExtraCard3Value != 2){
                p1AvailableExtraCard2ImageButton.setEnabled(true)
            }
            if (p1ChosenExtraCard1Value !=3 && p1ChosenExtraCard2Value !=3 && p1ChosenExtraCard3Value != 3){
                p2AvailableExtraCard3ImageButton.setEnabled(true)
            }
            if (p1ChosenExtraCard1Value !=4 && p1ChosenExtraCard2Value !=4 && p1ChosenExtraCard3Value != 4){
                p1AvailableExtraCard4ImageButton.setEnabled(true)
            }
            if (p1ChosenExtraCard1Value !=5 && p1ChosenExtraCard2Value !=5 && p1ChosenExtraCard3Value != 5) {
                p1AvailableExtraCard5ImageButton.setEnabled(true)
            }
            if  (p1ChosenExtraCard1Value !=-1 && p1ChosenExtraCard2Value !=-1 && p1ChosenExtraCard3Value != -1){
                p1AvailableExtraCard6ImageButton.setEnabled(true)
            }
            if  (p1ChosenExtraCard1Value !=-2 && p1ChosenExtraCard2Value !=-2 && p1ChosenExtraCard3Value != -2){
                p1AvailableExtraCard7ImageButton.setEnabled(true)
            }
            if  (p1ChosenExtraCard1Value !=-3 && p1ChosenExtraCard2Value !=-3 && p1ChosenExtraCard3Value != -3){
                p1AvailableExtraCard8ImageButton.setEnabled(true)
            }
            if  (p1ChosenExtraCard1Value !=-4 && p1ChosenExtraCard2Value !=-4 && p1ChosenExtraCard3Value != -4){
                p1AvailableExtraCard9ImageButton.setEnabled(true)
            }
        }
        if(playerValue == 2){


            if(p2ChosenExtraCard1Value !=1 && p2ChosenExtraCard2Value !=1 && p2ChosenExtraCard3Value != 1){
                    p2AvailableExtraCard1ImageButton.setEnabled(true)
            }
            if (p2ChosenExtraCard1Value !=2 && p2ChosenExtraCard2Value !=2 && p2ChosenExtraCard3Value != 2){
                    p2AvailableExtraCard2ImageButton.setEnabled(true)
                }
            if (p2ChosenExtraCard1Value !=3 && p2ChosenExtraCard2Value !=3 && p2ChosenExtraCard3Value != 3){
                    p2AvailableExtraCard3ImageButton.setEnabled(true)
                }
            if (p2ChosenExtraCard1Value !=4 && p2ChosenExtraCard2Value !=4 && p2ChosenExtraCard3Value != 4){
                    p2AvailableExtraCard4ImageButton.setEnabled(true)
                }
            if (p2ChosenExtraCard1Value !=5 && p2ChosenExtraCard2Value !=5 && p2ChosenExtraCard3Value != 5) {
                    p2AvailableExtraCard5ImageButton.setEnabled(true)
                }
            if  (p2ChosenExtraCard1Value !=-1 && p2ChosenExtraCard2Value !=-1 && p2ChosenExtraCard3Value != -1){
                    p2AvailableExtraCard6ImageButton.setEnabled(true)
                }
            if  (p2ChosenExtraCard1Value !=-2 && p2ChosenExtraCard2Value !=-2 && p2ChosenExtraCard3Value != -2){
                    p2AvailableExtraCard7ImageButton.setEnabled(true)
                }
            if  (p2ChosenExtraCard1Value !=-3 && p2ChosenExtraCard2Value !=-3 && p2ChosenExtraCard3Value != -3){
                    p2AvailableExtraCard8ImageButton.setEnabled(true)
                }
            if  (p2ChosenExtraCard1Value !=-4 && p2ChosenExtraCard2Value !=-4 && p2ChosenExtraCard3Value != -4){
                    p2AvailableExtraCard9ImageButton.setEnabled(true)
                }
        }

    }



    //  checks if both players have pressed the ready button
    //  if both players are ready then it initiates the next activity
    //  sends the chosen player names and the chosen extra cards to the next activity
    fun checkReadyToStart(){
        if(player1Ready == true && player2Ready == true){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            intent.putExtra("chosenExtraCard1Value",p1ChosenExtraCard1Value)
            intent.putExtra("chosenExtraCard2Value",p1ChosenExtraCard2Value)
            intent.putExtra("chosenExtraCard3Value",p1ChosenExtraCard3Value)
            startActivity(intent)
        }
    }
    //  gives the cards in the hand value based on the ones chosen from the board
    //  takes in cardValue to know the chosen value for the card
    // takes in playerValue to know which player chose it
    fun chooseCardAsExtra(cardValue: Int,playerValue: Int) {
        if(playerValue== 1) {
            if (p1ChosenExtraCard1Value == 0) {
                p1ChosenExtraCard1Value = cardValue
                p1ChosenExtraCard1ImageButton.setEnabled(true)
            } else if (p1ChosenExtraCard2Value == 0) {
                p1ChosenExtraCard2Value = cardValue
                p1ChosenExtraCard2ImageButton.setEnabled(true)
            } else if (p1ChosenExtraCard3Value == 0) {
                p1ChosenExtraCard3Value = cardValue
                p1ChosenExtraCard3ImageButton.setEnabled(true)
            }
        }else if(playerValue== 2) {
            if (p2ChosenExtraCard1Value == 0) {
                p2ChosenExtraCard1Value = cardValue
                p2ChosenExtraCard1ImageButton.setEnabled(true)
            } else if (p2ChosenExtraCard2Value == 0) {
                p2ChosenExtraCard2Value = cardValue
                p2ChosenExtraCard2ImageButton.setEnabled(true)
            } else if (p2ChosenExtraCard3Value == 0) {
                p2ChosenExtraCard3Value = cardValue
                p2ChosenExtraCard3ImageButton.setEnabled(true)
            }
        }
    }

    //  assigns an image to the cards in the players' hands based on the ones picked from the board
    fun setCardImage(){
        when (p1ChosenExtraCard1Value){

            0->{
                p1ChosenExtraCard1ImageButton.setImageResource(android.R.color.transparent)
            }

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

        when (p1ChosenExtraCard2Value){

            0->{
                p1ChosenExtraCard2ImageButton.setImageResource(android.R.color.transparent)
            }
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

        when (p1ChosenExtraCard3Value){

            0->{
                p1ChosenExtraCard3ImageButton.setImageResource(android.R.color.transparent)
            }
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

        when (p2ChosenExtraCard1Value){

            0->{
                p2ChosenExtraCard1ImageButton.setImageResource(android.R.color.transparent)
            }
            1->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d1)
            }
            2->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d2)
            }
            3->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d3)
            }
            4->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d4)
            }
            5->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d5)
            }
            -1->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d6)
            }
            -2->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d7)
            }
            -3->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d8)
            }
            -4->{
                p2ChosenExtraCard1ImageButton.setImageResource(R.drawable.d9)
            }

        }

        when (p2ChosenExtraCard2Value){

            0->{
                p2ChosenExtraCard2ImageButton.setImageResource(android.R.color.transparent)
            }
            1->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d1)
            }
            2->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d2)
            }
            3->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d3)
            }
            4->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d4)
            }
            5->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d5)
            }
            -1->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d6)
            }
            -2->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d7)
            }
            -3->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d8)
            }
            -4->{
                p2ChosenExtraCard2ImageButton.setImageResource(R.drawable.d9)
            }

        }

        when (p2ChosenExtraCard3Value){

            0->{
                p2ChosenExtraCard3ImageButton.setImageResource(android.R.color.transparent)
            }
            1->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d1)
            }
            2->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d2)
            }
            3->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d3)
            }
            4->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d4)
            }
            5->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d5)
            }
            -1->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d6)
            }
            -2->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d7)
            }
            -3->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d8)
            }
            -4->{
                p2ChosenExtraCard3ImageButton.setImageResource(R.drawable.d9)
            }

        }

    }

}