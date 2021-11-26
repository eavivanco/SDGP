package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger implements WebRequestObserver {
    String notification;
    String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNotification(WebRequest request) {
        String path = request.getPath();
        User loggedUser = request.getLoggedUser();

        if (loggedUser.isAdmin()) {
            this.notification = String.format("Request made to %s by admin user", path);
        } else {
            this.notification = String.format("Request made to %s by non admin user", path);
        }
        return this.notification;
    }

    @Override
    public void update(WebRequest request) {
        //this.notifyObservers(WebRequest webrequest);
    }

    public synchronized void log(String msg) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(this.filePath, true));
            out.println(msg);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

