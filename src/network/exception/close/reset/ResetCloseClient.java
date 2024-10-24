package network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결 : " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        // client <- server : FIN
        Thread.sleep(1000); //서버가 close() 호출할 때 까지 잠시 대기

        // client -> server: PUSH[1]
        output.write(1); // 서버 소켓은 종료 됐으나 데이터를 전송하면?

        // server는 client에 RST패킷은 전송한다.
        //client <- server: RST
        Thread.sleep(1000); // RST 메세지 전송 대기
        try{
            // 서버 소켓은 종료 됐으나 input.read() 호출로 예외 발생
            // java.net.SocketException : Connection reset
            int read = input.read();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
