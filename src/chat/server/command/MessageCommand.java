package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;

public class MessageCommand implements Command {

    private final SessionManager sessionManager;

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        //클라이언트 전체에게 문자 보내기
        String message = args[1];

        //[sung] hello
        sessionManager.sendAll("["+session.getUsername()+"]"+ args[1]);
    }
}
