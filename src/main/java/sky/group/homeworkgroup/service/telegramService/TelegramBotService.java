package sky.group.homeworkgroup.service.telegramService;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TelegramBotService {
    private final TelegramBot telegramBot;
    private Logger logger = LoggerFactory.getLogger(TelegramBotService.class);

    public TelegramBotService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void sendingMessage(Long chatId, String string) {

        SendMessage message = new SendMessage(chatId, "Привет");
        controlSendingControl(telegramBot.execute(message));

    }

    private void controlSendingControl(SendResponse sendResponse) {
        if (sendResponse.isOk()) {
            logger.info("Сообщение отправлено");
            return;
        }
        logger.info("Ошибка, сообщение не отправлено");
    }
}
