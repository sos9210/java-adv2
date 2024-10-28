package chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.MyLogger.log;

public class WriteHandler implements Runnable{

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;
    private boolean closed = false;
    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("이름을 입력하세요.");
            String username = inputUsername(scanner);
            // 사용자가 최초로 입장한다
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String toSend = scanner.nextLine();
                if (toSend.isEmpty()) {
                    continue;
                }

                // 사용자가 나간다
                if(toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                // "/"로 시작하면 명령어, 나머지는 일반 메시지
                if(toSend.startsWith("/")) {
                    //명령어
                    output.writeUTF(toSend);
                } else {
                    //일반메시지
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }
        }catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private static String inputUsername(Scanner scanner) {
        String username;
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    public synchronized void close() {
        if(closed) {
            return;
        }
        try {
            System.in.close(); // Scanner 입력 중지
        } catch (IOException e) {
            log(e);
        }
        closed = true;
        log("writerHandler 종료");
    }
}
