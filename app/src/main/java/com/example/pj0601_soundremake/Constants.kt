package com.example.pj0601_soundremake

import android.provider.Settings.Global.getString

object Constants {

    fun generateSoundList(): MutableList<Sound> {
        return mutableListOf(
            Sound(1, R.raw.sound_dog,R.drawable.img_main_dog, R.string.dog, true),
            Sound(2, R.raw.sound_cat, R.drawable.img_main_cat2, R.string.cat),
            Sound(3, R.raw.sound_police, R.drawable.img_main_police, R.string.police),
            Sound(4, R.raw.sound_doorbell, R.drawable.img_main_bell, R.string.doorbell),
            Sound(5, R.raw.sound_hello, R.drawable.img_main_hello, R.string.hello),
            Sound(6, R.raw.sound_harp, R.drawable.img_main_harp2, R.string.harp),
            Sound(7, R.raw.sound_laughing, R.drawable.laughing, R.string.laughing),
            Sound(8, R.raw.sound_alarm_clock, R.drawable.img_main_clock, R.string.alarm_clock),
            Sound(9,R.raw.sound_rooster, R.drawable.img_main_rooster1, R.string.rooster),
            Sound(10, R.raw.sound_piano, R.drawable.img_main_piano2, R.string.piano),
            Sound(11, R.raw.sound_sneeze, R.drawable.img_main_sneezing, R.string.sneeze),
            Sound(12, R.raw.sound_train, R.drawable.img_main_train, R.string.train),
            Sound(13, R.raw.sound_alarm, R.drawable.img_main_alarm, R.string.alarm),
            Sound(14, R.raw.sound_army, R.drawable.img_main_army, R.string.army),
            Sound(15, R.raw.sound_drum, R.drawable.img_main_drum1, R.string.drum),
            Sound(16, R.raw.sound_guitar, R.drawable.img_main_guitar1, R.string.guitar),
            Sound(17, R.raw.sound_orchestral_string, R.drawable.img_main_orchestral, R.string.orchestral_string),
            Sound(18, R.raw.sound_ship, R.drawable.img_main_ship2, R.string.ship),
            Sound(19, R.raw.sound_snoze, R.drawable.img_main_snore, R.string.snoze),
            Sound(20, R.raw.sound_warning, R.drawable.img_main_warning1, R.string.warning),
            Sound(20, R.raw.sound_whistle, R.drawable.img_main_whistle, R.string.whistle),
            Sound(20, R.raw.sound_wind_chimes, R.drawable.img_main_windchimes1, R.string.wind_chimes),

            )
    }
}