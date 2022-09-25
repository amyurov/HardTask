package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String Ip = "127.0.0.1";
        int port = 8888;

        try (Socket clientSocket = new Socket(Ip, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Введите искомое число фибонначи");

            int fibNumber = sc.nextInt();

            out.println(fibNumber); //Отправляем иниф-ю на сервер

            System.out.println(in.readLine()); //Выводим полученную инф-ю от сервера

        } catch (IOException ex) {
            ex.getMessage();
        }


    }
}