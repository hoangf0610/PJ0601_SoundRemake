package com.example.pj0601_soundremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pj0601_soundremake.databinding.ItemHorizontalBinding

class HorizontalSoundAdapter(var soundList: MutableList<Sound>, var listener: OnItemClicked) :
    RecyclerView.Adapter<HorizontalSoundAdapter.HorizontalSoundViewHolder>() {
    inner class HorizontalSoundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemHorizontalBinding.bind(itemView)

        val img: ImageView = itemView.findViewById(R.id.iconHorizontal)
    }

    private lateinit var soundSelected: Sound

    fun updateData(newData: MutableList<Sound>) {
//      update ds
        soundList = newData
        notifyDataSetChanged()
    }

    interface OnItemClicked {
        fun onItemClickIcon(sound: Sound, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalSoundViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false)
        return HorizontalSoundViewHolder(view)
    }

    override fun getItemCount(): Int = soundList.size

    override fun onBindViewHolder(holder: HorizontalSoundViewHolder, position: Int) {
        val sound = soundList[position]
        holder.img.setImageResource(sound.icon)

        if (sound.isSelected) {
            holder.img.setBackgroundResource(R.drawable.bg_detail_horizontal_recyclerview_blue)
        } else {
            holder.img.setBackgroundResource(R.drawable.bg_detail_horizontal_recyclerview)
        }

        holder.img.setOnClickListener {
            setSelected(sound)
            listener.onItemClickIcon(sound = sound, position)
        }
    }

    fun setSelected(sound: Sound) {
        for (s in soundList) {
            s.isSelected = s.sound == sound.sound
        }
        notifyDataSetChanged()
    }

    fun setItems(items: List<Sound>) {
        this.soundList.clear()
        this.soundList.addAll(items)
        notifyDataSetChanged()
    }

}
