package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Home PC Volkov on 02.02.2018.
 */
public class BotClient extends Client{
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Hello chatiku. I'm a bot. I understand commands: date, day, month, year, time, hour, minute, second.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message!=null&&!message.isEmpty()&&message.contains(":")) {
                String[] str = message.split(": ");
                Calendar calendar = new GregorianCalendar();
                SimpleDateFormat dateFormat = null;
                if (str[1].equals("дата")) {
                    dateFormat = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                } else {
                    if (str[1].equals("день")) {
                        dateFormat = new SimpleDateFormat("d");
                        sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                    } else {
                        if (str[1].equals("месяц")) {
                            dateFormat = new SimpleDateFormat("MMMMM");
                            sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                        } else {
                            if (str[1].equals("год")) {
                                dateFormat = new SimpleDateFormat("YYYY");
                                sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                            } else {
                                if (str[1].equals("время")) {
                                    dateFormat = new SimpleDateFormat("H:mm:ss");
                                    sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                                } else {
                                    if (str[1].equals("час")) {
                                        dateFormat = new SimpleDateFormat("H");
                                        sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                                    } else {
                                        if (str[1].equals("минуты")) {
                                            dateFormat = new SimpleDateFormat("m");
                                            sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                                        } else {
                                            if (str[1].equals("секунды")) {
                                                dateFormat = new SimpleDateFormat("s");
                                                sendTextMessage("Информация для " + str[0] + ": " + dateFormat.format(calendar.getTime()));
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }

                }
            }


        }
    }

    @Override
    protected SocketThread getSocketThread() {
        BotSocketThread bot = new BotSocketThread();
        return bot;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String name = "date_bot_" + (int)(Math.random()*100);
        return name;
    }

    public static void main (String[] args) {
        new BotClient().run();
    }
}
