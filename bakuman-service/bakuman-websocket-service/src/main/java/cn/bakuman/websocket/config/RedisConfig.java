//package cn.bakuman.websocket.config;
//
//import cn.bakuman.websocket.consts.RedisTopicConsts;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//
///**
// * @Author 梦叶
// * @date 2021/12/29 18:22
// */
//@Configuration
//public class RedisConfig {
//
//
//
//    /**
//     * 创建连接工厂
//     * @param connectionFactory
//     * @param listenerAdapter
//     * @return
//     */
//    @Bean
//    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//                                                   MessageListenerAdapter listenerAdapter){
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        //接受消息的key
//        container.addMessageListener(listenerAdapter,new PatternTopic(RedisTopicConsts.IM_CHAT_TOPIC));
//        return container;
//    }
//
//    /**
//     * 绑定消息监听者和接收监听的方法
//     * @param receiver
//     * @return
//     */
//    @Bean
//    public MessageListenerAdapter listenerAdapter(ReceiverRedisMessage  receiver){
//        return new MessageListenerAdapter(receiver,"receiveMessage");
//    }
//
//}
