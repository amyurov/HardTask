package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept(); //Ждем подключения

            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("New connection accepted");
                int fibNumber = Integer.parseInt(in.readLine()); //Получаем переданную инфу от клиента и записываем в переменную

                long value = fibValue(fibNumber);

                out.println(String.format("Hi, your fibValue is %d", value)); //Отправляем инф-ю клиенту
                out.flush();

            }

        }
    }

    private static long fibValue(int n) {
        if (n <= 1) {
            return n;
        }

        return getFibValue(n - 1) + getFibValue(n - 2);
    }

    private static long getFibValue(int n) {
        long[] arr = new long[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
