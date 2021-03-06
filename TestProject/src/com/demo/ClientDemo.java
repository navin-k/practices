package com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;

public class ClientDemo {

	static final int BUFFER_SIZE = 4096;
	public static void main(String[] args) throws ClientProtocolException, IOException {

		String urlString = "http://localhost:8080/com.navink.wtp.first/FileCounter";
		File uploadFile = new File("build.xml");
		URL url = new URL(urlString);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setUseCaches(false);
        httpConn.setDoOutput(true);
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("fileName", uploadFile.getName());
        
        OutputStream outputStream = httpConn.getOutputStream();
        FileInputStream inputStream = new FileInputStream(uploadFile);
        
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        
        System.out.println("Start writing data...");
        
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        System.out.println("Data was written.");
        outputStream.close();
        inputStream.close();
        // always check HTTP response code from server
        int responseCode = httpConn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // reads server's response
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream()));
            String response = reader.readLine();
            System.out.println("Server's response: " + response);
        } else {
            System.out.println("Server returned non-OK code: " + responseCode);
        }
		
	}

}
