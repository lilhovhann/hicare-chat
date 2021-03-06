package io.project.app.covidbot;

import io.project.app.covidbot.domain.Account;
import io.project.app.covidbot.domain.Address;
import io.project.app.covidbot.dto.AccountDTO;
import io.project.app.covidbot.dto.AddressDTO;
import io.project.app.covidbot.services.AccountService;
import io.project.app.covidbot.services.AddressService;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author lilith
 */
@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    AccountService accountService;

    @Autowired
    AddressService addressService;

    private static final Logger log = LoggerFactory.getLogger(Bot.class);

    public String getBotToken() {
        //put your telegram bot token here
        return "1824231087:AAEEH7jAjxBOeJf9C5JdvFlz6ZnpevpFztc";
    }

    @Override
    public String getBotUsername() {
        //put your telegram bot username here
        return "novermber_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        
        if (update.hasMessage()) {
            System.out.println("Your message is "+update.getMessage().getText());
            long chat_id = update.getMessage().getChatId();
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("Hello")) {
                    try {
                        execute(sendInlineKeyBoardMessage(chat_id));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            SendMessage sendM = new SendMessage();
            String callBackData = update.getCallbackQuery().getData();
            sendM.setText(callBackData);
            Long callBackChatId = update.getCallbackQuery().getMessage().getChatId();
            String chatID = String.valueOf(callBackChatId);
            sendM.setChatId(chatID);

            try {
                execute(sendM);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

//    @SneakyThrows
//    public synchronized void sendMsg(String s, InlineKeyboardMarkup replyMarkup, long chat_id) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(chat_id + "");
//        sendMessage.setText(s);
//
//        sendMessage.setReplyMarkup(replyMarkup);
//
//        execute(sendMessage);
//    }
    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("??????");
        inlineKeyboardButton1.setCallbackData("Button \"??????\" has been pressed");
        inlineKeyboardButton2.setText("??????2");
        inlineKeyboardButton2.setCallbackData("Button \"??????2\" has been pressed");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);

        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton3.setText("Fi4a");
        inlineKeyboardButton3.setCallbackData("CallFi4a");
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        String chatID = String.valueOf(chatId);

        SendMessage send = new SendMessage();
        send.setChatId(chatID);
        send.setText("????????????");
        send.setReplyMarkup(inlineKeyboardMarkup);

        return send;
    }

}
