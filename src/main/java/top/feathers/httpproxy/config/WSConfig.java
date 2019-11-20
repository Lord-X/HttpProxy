package top.feathers.httpproxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import top.feathers.httpproxy.endpoint.WSHandler;

/**
 * Description:
 *
 * @author zhiminxu
 * @package top.feathers.httpproxy.config
 * @create_time 2019-11-19
 */
@Configuration
@EnableWebSocket
public class WSConfig implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(wsHandler(), "proxy/print")
                .setAllowedOrigins("*");
    }

    public WebSocketHandler wsHandler() {
        return new WSHandler();
    }
}
