package com.mynimef.telegrambot

import com.mynimef.telegrambot.containers.BotFile
import com.mynimef.telegrambot.containers.BotMessage

interface IBot {

    fun sendMessage(chatId: String, text: String): Int?

    fun sendMessage(chatId: String, message: BotMessage): Int?

    fun sendMessage(chatId: String, botFile: BotFile)

    fun editMessage(chatId: String, messageId: Int, message: BotMessage)

    fun editMessage(chatId: String, messageId: Int, text: String)

    fun deleteMessage(chatId: String, messageId: Int)

}
