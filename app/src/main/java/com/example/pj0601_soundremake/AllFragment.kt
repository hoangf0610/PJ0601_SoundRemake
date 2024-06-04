package com.example.pj0601_soundremake

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pj0601_soundremake.databinding.FragmentAllBinding

class AllFragment : Fragment(R.layout.fragment_all) {
    private var _binding: FragmentAllBinding? = null
    private val binding get() = _binding!!

    companion object {
        var indexSelected: Int = -1
        const val TAG = "AllFragment"
    }

    lateinit var soundList: MutableList<Sound>
    lateinit var tempAdapter: SoundAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAllBinding.bind(view)

        soundList = Constants.generateSoundList()

        tempAdapter = SoundAdapter(soundList, object : SoundAdapter.OnItemClicked {
            override fun onItemClicked(sound: Sound, position: Int) {
                indexSelected = position
                (activity as MainActivity).goToDetailFragment(sound)
            }

            override fun onItemPlay(sound: Sound, position: Int) {
                Toast.makeText(this@AllFragment.requireContext(), sound.name, Toast.LENGTH_SHORT)
                    .show()
            }
        })


        binding.rcvCfgSound.adapter = tempAdapter
        binding.rcvCfgSound.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.imgTutorialHome.setOnClickListener {
            val intent = Intent(requireActivity(), TutorialActivity::class.java)
            startActivity(intent)
        }
        binding.imgSettingHome.setOnClickListener {
            val intent = Intent(requireActivity(), SettingActivity::class.java)
            startActivity(intent)
        }

        binding.img.setImageResource(soundList[0].icon)


        (activity as? MainActivity)?.soundLiveData?.observe(activity as LifecycleOwner) {
            Log.i(TAG, "observe PictureItem Livedata $it")

            for (s in soundList) {
                s.isSelected = false
            }

            if (indexSelected != -1) {
                soundList[indexSelected] = it
                soundList[indexSelected].isSelected = true
                tempAdapter.updateData(soundList)
                binding.img.setImageResource(soundList[indexSelected].icon)
            }
        }


    }
}