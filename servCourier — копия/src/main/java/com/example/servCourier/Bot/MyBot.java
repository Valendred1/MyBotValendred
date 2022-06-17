package com.example.servCourier.Bot;

import com.example.servCourier.entity.CourierEntity;
import com.example.servCourier.exception.CourierAlreadyExistException;
import com.example.servCourier.model.Courier;
import com.example.servCourier.model.Zakaz;
import com.example.servCourier.service.CourierService;
import com.example.servCourier.service.ZakaziService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    CourierService courierService;
    ZakaziService zakaziService;
   private static MyBot myBot;

    MyBot() {
        System.out.println("111111111111111111111111111111111111111");
    }
    public static MyBot getInstance(){
        if (myBot==null) {
            myBot=new MyBot();
        }
        return myBot;
    }

    public int adds(String message)
    {

        int sum;
        int ind=message.indexOf("+");
        String firstnmb=message.substring(0,ind);
        String secondnmb=message.substring(ind+1);
        System.out.println(secondnmb+" "+firstnmb);
        sum=Integer.valueOf(firstnmb)+Integer.valueOf(secondnmb);
        System.out.println(sum);
        return sum;
    }
    @Override
    public String getBotUsername() {
        return "Valendredbot";
    }

    @Override
    public String getBotToken() {
        return "";
    }
String[] courierFields=new String[3];
    int couirerFieldCount=0;
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("122345");
        SendMessage messagereg = new SendMessage();
if (couirerFieldCount>0){{
    if (couirerFieldCount==3)
    {

        if (update.hasMessage() && update.getMessage().getText().equals("Подтвердить")){
        messagereg.setChatId(update.getMessage().getChatId().toString());
            CourierEntity courier = new CourierEntity();
            courier.setFirstName(courierFields[1]);
            courier.setSecondName(courierFields[2]);
            courier.setTelegramId(courierFields[0]);
            try {
                courierService.registration(courier);
            } catch (CourierAlreadyExistException e) {
                e.printStackTrace();
            }
            ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
            replyKeyboardRemove.setSelective(true);
            replyKeyboardRemove.setRemoveKeyboard(true);
            messagereg.setReplyMarkup(replyKeyboardRemove);
        messagereg.setText("Регистрация завершена");
            try {
                execute(messagereg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
if (update.hasMessage() && update.getMessage().getText().equals("Отменить")){
    courierFields[0]="";
    courierFields[1]="";
    courierFields[2]="";
    couirerFieldCount=0;
    messagereg.setChatId(update.getMessage().getChatId().toString());
    ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
    replyKeyboardRemove.setSelective(true);
    replyKeyboardRemove.setRemoveKeyboard(true);
    messagereg.setReplyMarkup(replyKeyboardRemove);
    messagereg.setText("Регистрация отменена");

    try {
        execute(messagereg);
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }
}
    }

    if (couirerFieldCount==2){
        courierFields[2]=update.getMessage().getText();
        messagereg.setChatId(update.getMessage().getChatId().toString());
        messagereg.setText("Вы уверены, что хотите зарегистрировать пользователя "+courierFields[1]+" "+courierFields[2]);
        couirerFieldCount++;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        messagereg.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("Подтвердить");
        keyboardFirstRow.add("Отменить");
        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        // и устанавливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        System.out.println(courierFields[0]+courierFields[1]+courierFields[2]);
        try {
            execute(messagereg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    if (couirerFieldCount==1){
        courierFields[1]=update.getMessage().getText();
        messagereg.setChatId(update.getMessage().getChatId().toString());
        messagereg.setText("Введите фамилию");
        couirerFieldCount++;
        try {
            execute(messagereg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
}

//        System.out.println(update.getMessage().getChatId().toString());
//        InputFile sticker = new InputFile("CAACAgIAAxkBAAEE8rFioZNLmAKNV0wWfk0O7YkDf_swhwACxRsAAoBrkEgUwsJlEAMtJSQE");
//        SendSticker sendSticker = new SendSticker();
//        sendSticker.setSticker(sticker);
//        sendSticker.setChatId(update.getMessage().getChatId().toString());
//        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
//        message.setChatId(update.getMessage().getChatId().toString());
//        message.setText("123213213");
//        try {
//            execute(message);
//            execute(sendSticker);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
//
//            message.setChatId(update.getMessage().getChatId().toString());
//
//            System.out.println(update.getMessage().getText());
//            message.setText(String.valueOf(adds(update.getMessage().getText())));
//
//
//
//
//
//
//            try {
//
//
//                    execute(message) ;
//
//
//
//                ; // Call method to send the message
//
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
        if (update.hasMessage() && update.getMessage().getText().equals("/hello")) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            System.out.println(update.getMessage().getChatId());
            message.setText("Привет, " + update.getMessage().getChat().getFirstName());
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            message.setReplyMarkup(replyKeyboardMarkup);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow keyboardFirstRow = new KeyboardRow();
            // Добавляем кнопки в первую строчку клавиатуры
            keyboardFirstRow.add("Команда 1");
            keyboardFirstRow.add("Команда 2");

            // Вторая строчка клавиатуры

            // Добавляем кнопки во вторую строчку клавиатуры
            keyboardFirstRow.add("Команда 3");
            keyboardFirstRow.add("Команда 4");

            // Добавляем все строчки клавиатуры в список
            keyboard.add(keyboardFirstRow);

            // и устанавливаем этот список нашей клавиатуре
            replyKeyboardMarkup.setKeyboard(keyboard);
            try {
                System.out.println("aadfasdfs");
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (update.hasMessage() && update.getMessage().getText().equals("Команда 1")){
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
            replyKeyboardRemove.setSelective(true);
            replyKeyboardRemove.setRemoveKeyboard(true);
            message.setReplyMarkup(replyKeyboardRemove);
            message.setText("Окс");


            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (update.hasMessage() && update.getMessage().getText().equals("/registration")) {
            SendMessage message = new SendMessage();
            courierFields[0] = update.getMessage().getChatId().toString();
            couirerFieldCount++;
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Введите имя");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    public void messageToAll(String message){
        SendMessage sendMessage = new SendMessage();
    List<Courier> spisokId= courierService.getAll();
    for (int i=1;i<=spisokId.size();i++){
        sendMessage.setChatId(spisokId.get(i).getIdTelegram());
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    }
    public void zakazToCouriers( Zakaz zakaz){
        messageToAll("Новый заказ: "+zakaz.getAdress());
    }
}
