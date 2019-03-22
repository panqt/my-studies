package pers.panqt.springboot.entry;

import lombok.Data;

import java.io.Serializable;

/**  @auther panqt 2019/03/21 22:23
 */
@Data
public class RabbitMqMessage implements Serializable {
    private String message;

    private String routingKey;

    public RabbitMqMessage() {
    }

    public RabbitMqMessage(String message) {
        this.message = message;
    }

    public RabbitMqMessage(String message, String routingKey) {
        this.message = message;
        this.routingKey = routingKey;
    }
}
