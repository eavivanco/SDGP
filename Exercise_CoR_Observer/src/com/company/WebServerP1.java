package com.company;

// before implementing part 2
public class WebServerP1 implements WebRequestObservable{

    String output = "";

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
        //
    };
    public void detach(WebRequestObserver observer) {
        //
    };
    public void notifyObservers(WebRequest webRequest) {
        //
    };
}
