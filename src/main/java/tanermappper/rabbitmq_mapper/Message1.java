package tanermappper.rabbitmq_mapper;

import java.io.Serializable;

public class Message1 implements Serializable {
    private int id2;
    private String name;

    public Message1(int id2, String name) {
        this.id2 = id2;
        this.name = name;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
