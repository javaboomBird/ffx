package org.interface21.common.base;

import org.interface21.common.amqp.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzh
 * @Date 2019/12/18
 * @Description ApplicationObjectSupport.getApplicationContext可以获取应用上下文
 */
@RestController
public abstract class BaseController extends ApplicationObjectSupport {

    /**
     * 端口号
     */
    @Value("${server.port}")
    protected String port;

    /**
     * 应用名称（默认：lion-unknown）
     */
    @Value("${spring.application.name}")
    protected String applicationName;

    /**
     * RabbitMQ 消息发送者
     */
    @Autowired
    protected MessageSender messageSender;
}
