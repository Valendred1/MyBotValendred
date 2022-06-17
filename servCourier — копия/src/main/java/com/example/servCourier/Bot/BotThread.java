package com.example.servCourier.Bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotThread extends Thread {

    @Override
    public void run() {
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        try {
            botsApi.registerBot(new MyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
