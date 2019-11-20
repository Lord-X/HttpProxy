package top.feathers.httpproxy.endpoint;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author zhiminxu
 * @package top.feathers.httpproxy.endpoint
 * @create_time 2019-11-19
 */
public class WSHandler extends TextWebSocketHandler {

    private static WebSocketSession session;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Map<String, String> map = JSONObject.parseObject(payload, HashMap.class);
        System.out.println("get message = " + JSONObject.toJSONString(map));
        session.sendMessage(new TextMessage("return, " + payload));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        WSHandler.session = session;
        session.sendMessage(new TextMessage("Connection established."));
    }

    public static WebSocketSession getWebSocketSession() {
        if (!session.isOpen()) {
            return null;
        }
        return session;
    }
}
