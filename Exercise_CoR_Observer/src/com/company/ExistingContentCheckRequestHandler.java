package com.company;

public class ExistingContentCheckRequestHandler extends RequestHandler {

    @Override
     public String handleRequest(String path, User loggedUser){
        //System.out.println("<<< Checking the path ! >>>");
 
        if (path.equals("/dashboard") || path.equals("/home")) {
            //System.out.println("<<< The page exists ! >>>");
            return handler.handleRequest(path, loggedUser);
        }
        else {
            return "<<< Status 404 : Page missing >>>";
        }
        
     }

     

     
    
    //public void handleRequest() {
      //  System.out.println("<<< Handling the request ! >>>");
        //  checkPath(path);
            //checkPolicy(userRights);
            //render(content);
        //} catch (Exception ex) {
          //System.out.println("<<< We are having some troubles handling your request ! >>>");
        //}
     //}
}
