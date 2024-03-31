package com.example.assignment2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class FootballAdapter(
    var playerNameList: ArrayList<String>,
    var playerImagesList: ArrayList<Int>,
    var teamImagesList: ArrayList<Int>,
    var arrowList: ArrayList<Int>,
    var context: Context
): RecyclerView.Adapter<FootballAdapter.PlayerViewHolder>() {

    class PlayerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var playerName:TextView = itemView.findViewById(R.id.PlayerName)
        var percentage:TextView = itemView.findViewById(R.id.Percentage)
        var playerImage:ImageView = itemView.findViewById(R.id.PlayerImage)
        var teamImage:ImageView = itemView.findViewById(R.id.TeamLogo)
        var upordownArrow:ImageView = itemView.findViewById(R.id.Red_Green_Arrow)

        var cardView: CardView = itemView.findViewById(R.id.cardView)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view:View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_design,parent,false)

        return PlayerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerNameList.size
    }

    fun randomize():String{
        val min:Int = 0
        val max:Int = 100
        val randomperc = (min..max).random()
        return randomperc.toString()
    }

    fun arrowrand():Int{
        val radomArrow = (0..1).random()
        return radomArrow
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.playerName.text = playerNameList.get(position)
        holder.playerImage.setImageResource(playerImagesList.get(position))
        holder.percentage.text = randomize()
        holder.teamImage.setImageResource(teamImagesList.get(position))
        holder.upordownArrow.setImageResource(arrowList.random())

        holder.cardView.setOnClickListener{

            var rand = (0..teamImagesList.size-1).random()

            var intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("playerName", holder.playerName.text)
            intent.putExtra("playerImage", playerImagesList[position])
            intent.putExtra("team2Image",teamImagesList[position])
            intent.putExtra("team1Image", teamImagesList[rand])



            context.startActivity(intent)
        }
    }

}