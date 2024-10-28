package chat.server;

import java.io.IOException;

// 클라이언트 명령을 실행하는 인터페이스
public interface CommandManager {
    void execute(String totalMEssage, Session session) throws IOException;
}
