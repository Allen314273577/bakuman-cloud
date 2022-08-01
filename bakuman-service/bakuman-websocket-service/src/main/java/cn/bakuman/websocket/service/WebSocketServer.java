package cn.bakuman.websocket.service;


import cn.bakuman.websocket.dto.Message;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/webSocket/{username}")
@Component
@Slf4j
public class WebSocketServer {

    private static AtomicInteger onlineNum = new AtomicInteger();

    private static ConcurrentHashMap<String, Session> SESSION_POOLS = new ConcurrentHashMap<>();

    /**
     * 建立连接成功调用
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "username") String userName) {
        SESSION_POOLS.put(userName, session);
        addOnlineCount();
        log.info("[{}]加入webSocket！当前人数为[{}]", userName, onlineNum);
        // 广播上线消息
    }

    //关闭连接时调用
    @OnClose
    public void onClose(@PathParam(value = "username") String userName) {
        SESSION_POOLS.remove(userName);
        subOnlineCount();
        log.info("[{}]断开webSocket连接！当前人数为[{}]", userName, onlineNum);
    }

    //收到客户端信息后，根据接收人的username把消息推下去或者群发
    // to=-1群发消息
    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("server get" + message);
        Message msg = JSON.parseObject(message, Message.class);
        msg.setDate(new Date());
        //获取连接
        List<String> to = msg.getTo();
        to.forEach(s -> { Session session = SESSION_POOLS.get(s);sendMessage(session, message);});
    }

    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount() {
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }

    public static AtomicInteger getOnlineNumber() {
        return onlineNum;
    }

    public static ConcurrentHashMap<String, Session> getSessionPools() {
        return SESSION_POOLS;
    }

}
