package com.example.demo.utils;

public class JsonUtil<E>{
    private Integer state;
    private String message;
    private E data;
    public JsonUtil(){
        super();
    }

    public JsonUtil(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonUtil(Integer state) {
        super();
        this.state = state;


    }
    public JsonUtil(Throwable e){
        super();
        this.message = e.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
