package tanermappper.rabbitmq_mapper;

import java.io.Serializable;

public class Message2 implements Serializable {
    private String key;

    public Message2(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
