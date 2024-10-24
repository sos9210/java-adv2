package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {
    public static void main(String[] args) throws IOException {
        unknownHostEx1();
        unknownHostEx2();
        connectionRefused();
    }
    // 연결을 거절함
    private static void connectionRefused() throws IOException {
        try {
            Socket socket = new Socket("localhost", 45678);
        } catch (ConnectException e) {
            throw new RuntimeException(e);
        }
    }
    // 존재하지않는 호스트1
    private static void unknownHostEx1() throws IOException {
        try{
            Socket socket = new Socket("999.999.999.999", 80);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    // 존재하지않는 호스트2
    private static void unknownHostEx2() throws IOException {
        try{
            Socket socket = new Socket("google.gogogo", 80);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
