package top.feathers.httpproxy.core.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.web.socket.TextMessage;
import top.feathers.httpproxy.core.endpoint.WSHandler;
import top.feathers.httpproxy.extension.parser.ProxyRequest;
import top.feathers.httpproxy.extension.parser.RequestParser;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

/**
 * Description:
 *
 * @author zhiminxu
 */
public class ProxyServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("message = " + body);
        ServiceLoader<RequestParser> loader = ServiceLoader.load(RequestParser.class);
        Iterator<RequestParser> iterator = loader.iterator();
        if (iterator.hasNext()) {
            RequestParser parser = iterator.next();
            ProxyRequest request = parser.parseRequest(body);
            if (WSHandler.getWebSocketSession() != null) {
                WSHandler.getWebSocketSession().sendMessage(new TextMessage(request.getBody()));
            }
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
