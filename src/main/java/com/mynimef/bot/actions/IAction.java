package com.mynimef.bot.actions;

import com.mynimef.bot.IBot;

public interface IAction {
    void action(
            String message,
            String chatId,
            Integer messageId,
            String username,
            String firstName,
            String lastName,
            IBot bot
    );
}
