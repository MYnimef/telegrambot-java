package com.mynimef.bot.handlers;

import com.mynimef.bot.callback.*;
import com.mynimef.bot.containers.VMFile;
import com.mynimef.bot.message.IMessage;
import com.mynimef.bot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

import java.util.Map;

public final class CallbackHandler extends Handler {
    private final Integer messageId;
    private final ICallback callback;

    public CallbackHandler(
            String chatId,
            Integer messageId,
            String callback,
            Map<Long, ICallback> callbacks
    ) {
        super(Long.parseLong(chatId), chatId);
        this.messageId = messageId;
        this.callback = callbacks.get(Long.parseLong(callback));
    }

    public IHandler start() {
        if (callback instanceof ICallbackEdit) {
            EditMessageText message = new EditMessageText();

            message.setChatId(chatIdStr);
            message.setMessageId(messageId);
            message.setText(((ICallbackEdit) callback).callback(chatIdLong));
            if (callback.doesHaveButtons()) {
                message.setReplyMarkup(KeyboardBuilder.setReply(callback.getButtons()));
            }

            reply = message;
        } else if (callback instanceof ICallbackSendMessage) {
            IMessage mes = new Message();
            ((ICallbackSendMessage) callback).callback(chatIdLong, mes);

            SendMessage message = new SendMessage();
            message.setChatId(chatIdStr);
            message.setText(mes.getText());
            reply = message;

            for (VMFile file: mes.getFiles()) {
                addDoc(file, chatIdStr);
            }
        }

        for (VMFile file : callback.getFiles()) {
            addDoc(file, chatIdStr);
        }

        return this;
    }
}