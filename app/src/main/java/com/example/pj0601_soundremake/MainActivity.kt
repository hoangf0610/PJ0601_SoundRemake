package com.example.pj0601_soundremake

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pj0601_soundremake.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    val soundLiveData = MutableLiveData<Sound>()
    val soundIndex = MutableLiveData<Sound>()
    private val fragmentAll = AllFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
//            thay thế framelayout bằng AllPictureFragment
            replace(R.id.flFragment, fragmentAll)
            commit()
        }

    }

    fun  goToDetailFragment(soundList: Sound) {
        val fragmentDetail = supportFragmentManager.beginTransaction()
        val detailFragment = DetailFragment()

//        đóng gói data
        val bundle = Bundle()
        bundle.putInt("index", soundList.index)
        bundle.putInt("sound", soundList.sound)
        bundle.putInt("icon", soundList.icon)
        bundle.putInt("name", soundList.name)
        bundle.putBoolean("isSelected", soundList.isSelected)
        bundle.putBoolean("onFlash", soundList.onFlash)
        bundle.putBoolean("onVibrate", soundList.onVibration)
        bundle.putBoolean("onSound", soundList.onSound)
        bundle.putInt("volumn", soundList.volumn)
        bundle.putString("duration", soundList.duration)

        detailFragment.arguments = bundle   // gói bundle vào arguments

        fragmentDetail.addToBackStack(DetailFragment.TAG) // chuyển data
        fragmentDetail.replace(R.id.flFragment, detailFragment) // add : thêm detailFragment vào stack
        fragmentDetail.commit()
    }



}