package se.magictechnology.pia12android19feb

import androidx.lifecycle.ViewModel

class StuffViewModel : ViewModel() {

    var sometext = "XXXXXX"

    fun loadsome() {
        sometext = "Hej"
    }
}