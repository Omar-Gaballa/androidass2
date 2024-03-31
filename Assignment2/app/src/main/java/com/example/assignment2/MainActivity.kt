package com.example.assignment2

import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //lists
    var playerNameList = ArrayList<String>()
    var playerImagesList = ArrayList<Int>()
    var teamImagesList = ArrayList<Int>()
    var arrowList = ArrayList<Int>()



    lateinit var recyclerView: RecyclerView

    lateinit var adapter: FootballAdapter

    lateinit var receiver:Receiver

    private lateinit var mp:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mp= MediaPlayer.create(applicationContext,R.raw.waka)


        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


        playerNameList.add("Messi")
        playerNameList.add("Mbappe")
        playerNameList.add("Ronaldo")
        playerNameList.add("Ronaldinho")


        playerImagesList.add(R.drawable.messi)
        playerImagesList.add(R.drawable.mbappe)
        playerImagesList.add(R.drawable.ronaldo)
        playerImagesList.add(R.drawable.ronaldinho)

        arrowList.add(R.drawable.greenarrowup)
        arrowList.add(R.drawable.redarrowdown)


        teamImagesList.add(R.drawable.barca)
        teamImagesList.add(R.drawable.bayern)
        teamImagesList.add(R.drawable.psg)
        teamImagesList.add(R.drawable.realmadrid)


        adapter = FootballAdapter(playerNameList,playerImagesList,teamImagesList,arrowList, this@MainActivity)

        recyclerView.adapter = adapter






    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Application Resumed", Toast.LENGTH_SHORT).show();
    }

    override fun onStart() {
        super.onStart()

        mp.start()
        receiver = Receiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

    }
    override fun onStop() {
        super.onStop()
        mp.pause()
        unregisterReceiver(receiver)
    }
}