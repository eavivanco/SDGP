package com.company;

import java.util.ArrayList;
import java.util.List;

public class WebServer implements WebRequestObservable{
    String output = "";
    String notification = "";
    private List<WebRequestObserver> observers = new ArrayList<WebRequestObserver>();

    public String getRequest(WebRequest request) {
        String path = request.getPath();
        User loggedUser = request.getLoggedUser();

        ExistingContentCheckRequestHandler eccrh = new ExistingContentCheckRequestHandler();
        PolicyCheckRequestHandler pcrh = new PolicyCheckRequestHandler();
        RenderContentHandler rch = new RenderContentHandler();

        eccrh.setNextHandler(pcrh);
        pcrh.setNextHandler(rch);

        output = eccrh.handleRequest(path, loggedUser);
        System.out.println(output);
        return "";
    }
    public void attach(WebRequestObserver observer) {
        this.observers.add(observer);
    };
    public void detach(WebRequestObserver observer) {
        this.observers.remove(observer);
    };

    public void notifyObservers(WebRequest webRequest) {
        String path = webRequest.getPath();
        User loggedUser = webRequest.getLoggedUser();

        if (loggedUser.isAdmin()) {
            this.notification = String.format("Request made to %s by admin user", path);
        } else {
            this.notification = String.format("Request made to %s by non admin user", path);
        }

        for (WebRequestObserver observer : this.observers) {
            observer.update(webRequest);
        }
    };
}
