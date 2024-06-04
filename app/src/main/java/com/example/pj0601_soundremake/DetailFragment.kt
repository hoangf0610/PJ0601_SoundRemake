package com.example.pj0601_soundremake

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pj0601_soundremake.databinding.FragmentDetailBinding

@Suppress("CAST_NEVER_SUCCEEDS")
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG = "DetailFragment"
    }

    lateinit var soundList: MutableList<Sound>
    lateinit var tempAdapter: HorizontalSoundAdapter

    private lateinit var  soundSelected :Sound


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        var index = arguments?.getInt("index") ?:-1
        var sound = arguments?.getInt("sound") ?: 0
        var icon = arguments?.getInt("icon") ?: 0
        var name = arguments?.getInt("name") ?: 0
        var isSelected = arguments?.getBoolean("isSelected") ?: false
        var onFlash = arguments?.getBoolean("flash") ?: false
        var onVibration = arguments?.getBoolean("vibration") ?: false
        var onSound = arguments?.getBoolean("soundOn") ?: false
        var volumn = arguments?.getInt("volumn") ?: 0
        var duration = arguments?.getString("duration") ?: ""

        soundSelected = Sound(index, sound, icon, name, isSelected, onFlash, onVibration, onSound, volumn, duration)

        soundList = Constants.generateSoundList()


        tempAdapter= HorizontalSoundAdapter(soundList, object : HorizontalSoundAdapter.OnItemClicked{
            override fun onItemClickIcon(sound: Sound, position: Int) {
                soundSelected.sound = sound.sound
                soundSelected.icon = sound.icon
                soundSelected.name = sound.name
                binding.icon.setImageResource(sound.icon)
                binding.tvSoundName.setText(sound.name)
                AllFragment.indexSelected = position
            }
        })

        binding.rcvHorizontal.adapter = tempAdapter
        binding.rcvHorizontal.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        tempAdapter.setItems(Constants.generateSoundList())
        tempAdapter.setSelected(soundSelected)

//        ánh xạ
        binding.icon.setImageResource(icon)
        binding.tvSoundName.setText(name)

        binding.swFlash.setOnCheckedChangeListener { _, isChecked ->
            soundSelected.onFlash = isChecked
        }

        binding.swVibration.setOnCheckedChangeListener { _, isChecked ->
            soundSelected.onVibration = isChecked
        }

        binding.swSound.setOnCheckedChangeListener { _, isChecked ->
            soundSelected.onSound = isChecked
        }

        binding.sliderVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                soundSelected.volumn = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.radioButton1.setOnClickListener {
            soundSelected.duration = binding.radioButton1.text.toString()
        }
        binding.radioButton2.setOnClickListener {
            soundSelected.duration = binding.radioButton2.text.toString()
        }
        binding.radioButton3.setOnClickListener {
            soundSelected.duration = binding.radioButton3.text.toString()
        }
        binding.radioButton4.setOnClickListener {
            soundSelected.duration = binding.radioButton4.text.toString()
        }

        binding.imgBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        binding.tvApply.setOnClickListener {
            (activity as MainActivity).soundLiveData.value = soundSelected
            (activity as MainActivity).soundIndex.value = soundSelected
            parentFragmentManager.popBackStack()
        }


        return view
    }
}