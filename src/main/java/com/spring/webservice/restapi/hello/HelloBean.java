package com.spring.webservice.restapi.hello;




public class HelloBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public HelloBean(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "helloWorld [mesage"+message+"]";
    }

}
