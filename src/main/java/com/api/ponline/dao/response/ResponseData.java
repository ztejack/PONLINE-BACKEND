package com.api.ponline.dao.response;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {

    private Boolean status;
    private List<String> messages = new ArrayList<>();

    private T payLoad;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public T getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(T payLoad) {
        this.payLoad = payLoad;
    }
    
    
}
