package was;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;
import static util.MyLogger.log;

public class HttpServer1 {
    private final int port;

    public HttpServer1(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port : " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
        }
    }

    private void process(Socket socket) throws IOException {
        try (socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8);
        ) {
            String requestString = requestToString(reader);
            if(requestString.contains("/favicon.ico")) {
                log("favicon 요청은 일단무시");
                return;
            }
            log("HTTP 요청 정보 출력");
            System.out.println(requestString);

            log("HTTP 응답 생성중");
            sleep(3000);
            responseToClient(writer);
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);   // 서버에서 처리되는걸 보기위해 시간 텀을 준다.
        }catch (InterruptedException e){
            throw new RuntimeException(e);

        }
    }

    private void responseToClient(PrintWriter writer) {
        // 웹 브라우저에 전달하는 내용

        String body = "<h1>Hello World</h1>";
        int length = body.getBytes(UTF_8).length;
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\r\n");       // \r\n -> \n 만해도 동작은함 (HTTP 스펙은 \r\n으로 되어있음)
        sb.append("Content-Type: text/html\r\n");
        sb.append("Content-Length: ").append(length).append("\r\n");
        sb.append("\r\n");  // header , body 구분라인 (빈 라인)
        sb.append(body);

        log("HTTP 응답 정보 출력");
        System.out.println(sb);

        writer.println(sb);
        writer.flush();
    }

    private static String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.isEmpty()) {
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
