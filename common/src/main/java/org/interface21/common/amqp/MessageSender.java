package org.interface21.common.amqp;

import org.interface21.common.constant.AmqpArgs;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huangzh
 * @Date 2019/12/18
 * @Description 消息发送者
 */
@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Object object){
        rabbitTemplate.convertAndSend(AmqpArgs.DIRECT_EXCHANGE, AmqpArgs.DIRECT_ROUTING,object);
    }


}
