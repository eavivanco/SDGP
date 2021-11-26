package com.company;

public class PolicyCheckRequestHandler extends RequestHandler {

     @Override
     public String handleRequest(String path, User loggedUser) {
        //System.out.println("<<< Checking the policy ! >>>");

        if (path.equals("/dashboard")) {
            if (loggedUser.isAdmin()) {
                //System.out.println("<<< The Admin user have the rights ! >>>");
                return handler.handleRequest(path, loggedUser);
            } else {
                return "<<< Status 403 : user is not authorized to access this content >>>";
            }
        } else {
            //System.out.println("<<< The user have the rights ! >>>");
            return handler.handleRequest(path, loggedUser);
        } 
     }   
}
