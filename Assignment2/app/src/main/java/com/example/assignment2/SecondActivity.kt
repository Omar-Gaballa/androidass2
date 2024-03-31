package com.example.assignment2

import android.app.ActionBar
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {


    lateinit var playerImageView: ImageView
    lateinit var playerName:TextView
    lateinit var team1:ImageView
    lateinit var team2:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        val actionBar: ActionBar? = actionBar
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true)
//        }

        playerName = findViewById(R.id.playerName)
        playerImageView  = findViewById(R.id.player_Img)
        team1 =findViewById(R.id.team1)
        team2 =findViewById(R.id.team2)

        var PlayerName:String = intent.getStringExtra("playerName").toString()
        var playerImageResource = intent.getIntExtra("playerImage", 0)
        var teamImageRes = intent.getIntExtra("team1Image",0)
        var teamtwoImageRes = intent.getIntExtra("team2Image",0)


        playerName.text = PlayerName
        playerImageView.setImageResource(playerImageResource)
        team1.setImageResource(teamImageRes)
        team2.setImageResource(teamtwoImageRes)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        return when (item.itemId) {
            android.R.id.home -> {
                // Handle the Up button press
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}