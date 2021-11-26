package com.company;

public abstract class RequestHandler {

    protected RequestHandler handler;

    public void setNextHandler(RequestHandler handler) {
        this.handler = handler;
    }

     public abstract String handleRequest(String path, User loggedUser);
}
