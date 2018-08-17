package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Home PC Volkov on 27.01.2018.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>() ;

    public static void main (String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
        System.out.println("Server is started");
        while (true) {
            Socket soc = null;
            try {
                soc = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                serverSocket.close();
                break;
            }
            Handler handler = new Handler(soc);
            handler.start();
        }
    }
    private static class Handler extends Thread {
        private Socket socket;
        public Handler (Socket socket) {
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message userName = connection.receive();
                if (userName.getType() == MessageType.USER_NAME){
                    if (!userName.getData().isEmpty()) {
                        if (!connectionMap.keySet().contains(userName.getData())){
                            connectionMap.put(userName.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return userName.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()
                    ) {
                String name = pair.getKey();
                Message message = new Message(MessageType.USER_ADDED, name);

                if (!name.equals(userName)) connection.send(message);
            }
        }

        private  void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String s = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, s));
                }
                else ConsoleHelper.writeMessage("Error");
            }
        }

        @Override
        public void run() {
            System.out.println("connected to " + this.socket.getRemoteSocketAddress());
            String userName = "";
            try (Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);
                sendListOfUsers(connection, userName);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                serverMainLoop(connection, userName);
            }
            catch (IOException e) {
                System.out.println("an error occurred while communicating with the remote address");
            }
            catch (ClassNotFoundException e) {
                System.out.println("an error occurred while communicating with the remote address");
            }
            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");
        }
    }

    public static void sendBroadcastMessage (Message message) {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()
             ) {
            String name = pair.getKey();
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Message not sent");
            }
        }
    }






}
