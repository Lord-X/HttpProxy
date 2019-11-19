package top.feathers.httpproxy.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Description:
 *
 * @author zhiminxu
 * @package top.feathers.httpproxy.server
 * @create_time 2019-11-19
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ProxyServerHandler());
    }
}
