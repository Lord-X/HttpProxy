package top.feathers.httpproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.feathers.httpproxy.server.ProxyServer;

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
