package tanermappper.rabbitmq_mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MessageCore<E> implements Serializable {

    private UUID eventId;

    private String eventTime;

    private String eventType;

    private E messageClass;

    public MessageCore(@JsonProperty("eventType") String eventType) {
        this.eventId = UUID.randomUUID();
        this.eventTime = formattedDate();
        this.eventType = eventType;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = formattedDate();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public E getMessageClass() {
        return messageClass;
    }

    public void setMessageClass(E messageClass) {
        this.messageClass = messageClass;
    }

    private String formattedDate() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    @Override
    public String toString(){
        JSONObject jsonInfo = new JSONObject();

        try {
            jsonInfo.put("eventTypeName", this.eventType);
            jsonInfo.put("eventTime", this.eventTime);
            jsonInfo.put("eventId", this.eventId);

            jsonInfo.put("messageClass", getMessageClass());

            /*JSONArray productArray = new JSONArray();
            if (this.products != null) {
                this.products.forEach(product -> {
                    JSONObject subJson = new JSONObject();
                    try {
                        subJson.put("name", product.getName());
                    } catch (JSONException e) {}

                    productArray.put(subJson);
                });
            }
            jsonInfo.put("products", productArray);*/
        } catch (JSONException e1) {

        }
        return jsonInfo.toString();
    }

}
