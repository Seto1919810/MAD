package com.example.demomychat

class Msg(val content: String, val type: Int, val friendId: Int=0) {
    companion object{
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
        const val TYPE_VOICE_RECEIVED = 2
        const val TYPE_IMG_SENT = 3
    }
}