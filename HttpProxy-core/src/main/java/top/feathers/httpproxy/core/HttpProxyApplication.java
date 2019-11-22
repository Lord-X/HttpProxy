package top.feathers.httpproxy.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.feathers.httpproxy.core.server.ProxyServer;

/**
 * Description:
 *
 * @author zhiminxu
 */
@SpringBootApplication
public class HttpProxyApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HttpProxyApplication.class, args);

        int port = 9990;

        new ProxyServer().bind(port);
    }
}
