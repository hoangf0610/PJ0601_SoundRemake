package com.example.pj0601_soundremake

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SoundAdapter (var soundList:MutableList<Sound>, val listener: OnItemClicked ):RecyclerView.Adapter<SoundAdapter.SoundViewHolder>() {

    interface OnItemClicked {
        fun onItemClicked(sound: Sound, position: Int)
        fun onItemPlay(sound: Sound, position: Int)
    }

    inner class SoundViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imgSound: ImageView = itemView.findViewById(R.id.iconSound)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val btPlay: ImageView = itemView.findViewById(R.id.bt_play)
        val cardView: View = itemView.findViewById(R.id.cardView)
        val imgOnFlash: ImageView = itemView.findViewById(R.id.iconOnFlash)
        val imgOnVibration: ImageView = itemView.findViewById(R.id.iconOnVibration)
        val imgOnSound: ImageView = itemView.findViewById(R.id.iconOnSound)
        val tvVolumn: TextView = itemView.findViewById(R.id.tv_volumn)
        val tvDuration: TextView = itemView.findViewById(R.id.tv_duration)

    }

    fun updateData(newData: MutableList<Sound>) {
//      update ds
        soundList = newData
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sound, parent, false)
        return SoundViewHolder(view)
    }

    override fun getItemCount(): Int = soundList.size

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {


        val sound = soundList[position]
        holder.imgSound.setImageResource(sound.icon)
        holder.tvName.setText(sound.name)
        holder.btPlay.setImageResource(R.drawable.ic_play)
        holder.tvVolumn.text = sound.volumn.toString()
        holder.tvDuration.text = sound.duration.toString()


        if (sound.isSelected) {
            holder.cardView.setBackgroundResource(R.drawable.bg_home_item_sound_recyclerview_blue)
            holder.tvName.setTextColor(Color.WHITE)
            holder.btPlay.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
            if(sound.onFlash) holder.imgOnFlash.setColorFilter(Color.WHITE)
            if(sound.onVibration) holder.imgOnVibration.setColorFilter(Color.WHITE)
            if(sound.onSound) holder.imgOnSound.setColorFilter(Color.WHITE)
            if(sound.volumn != 0) holder.tvVolumn.setTextColor(Color.WHITE)
            holder.tvDuration.setTextColor(Color.WHITE)

        } else {
            holder.cardView.setBackgroundResource(R.drawable.bg_home_item_sound_recyclerview)
            holder.tvName.setTextColor(Color.BLUE)
            holder.btPlay.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
        }


        holder.cardView.setOnClickListener {
            listener.onItemClicked(sound = sound, position)
        }

        holder.btPlay.setOnClickListener {
            listener.onItemPlay(sound = sound, position)
        }

    }

}

