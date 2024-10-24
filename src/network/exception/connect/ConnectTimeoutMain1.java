package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ConnectTimeoutMain1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            // 존재하지 않는 IP이므로 TCP응답이 오지않음. 또는 해당 IP서버가 응답을 보낼 수 없는 경우가 있을 수 있다.
            Socket socket = new Socket("192.168.1.250", 45678);

        } catch (ConnectException e) {
            throw new RuntimeException(e);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("end = " + (end - start));
        }

    }
}
