package top.feathers.httpproxy.endpoint;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Description:
 *
 * @author zhiminxu
 */
@ServerEndpoint("/printer")
@Slf4j
public class HttpEndpoint {

    private Session session;

    @OnOpen
    public void start(Session session) {
        this.session = session;
        try {
            this.session.getBasicRemote().sendText("Connect Success.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void end() {

    }

    @OnMessage
    public void handle(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void error() {
        log.error("System error.");
    }

}
