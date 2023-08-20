package com.example.tradebot.screens

import androidx.lifecycle.ViewModel
import com.example.tradebot.network.SocketManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SocketViewModel @Inject constructor(
    private val socketManager: SocketManager
) : ViewModel() {

    fun connectSocket() {
        socketManager.connect()
    }

    fun disconnectSocket() {
        socketManager.disconnect()
    }

    fun listenToNewBlockEvent(listener: (String) -> Unit) {
        socketManager.listenToNewBlockEvent(listener)
    }
}
