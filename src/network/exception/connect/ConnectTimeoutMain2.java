package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {

            // 기본생성자로 소켓객체를 생성하면 TCP연결을 시도하지 않는다.
            Socket socket = new Socket();

            // timeOut 설정 (3초)
            socket.connect(new InetSocketAddress("192.168.1.250", 45667), 3000);
        } catch (SocketTimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("end = " + (end - start));
        }

    }
}
