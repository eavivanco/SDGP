package com.company;

public class RenderContentHandler extends RequestHandler {

    @Override
     public String handleRequest(String path, User loggedUser) {
        if (path.equals("/dashboard")) {
            return "Status 200 : Dashboard content here";
        }else{
            return "Status 200 : Home content here";
        }
     }
}
