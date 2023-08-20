package com.example.tradebot.network

import com.example.tradebot.util.Constant
import io.socket.client.IO
import io.socket.client.Socket
import javax.inject.Inject

class SocketManager @Inject constructor() {
    private lateinit var socket: Socket

    fun connect() {
        val options = IO.Options()
        options.forceNew = true
        socket = IO.socket("http://192.168.0.68:8080", options)
        socket.connect()
    }

    fun disconnect() {
        socket.disconnect()
    }

    fun listenToNewBlockEvent(listener: (String) -> Unit) {
        socket.on("blockNumber") { args ->
            val blockData = args[0] as String
            listener(blockData)
        }
    }
}
