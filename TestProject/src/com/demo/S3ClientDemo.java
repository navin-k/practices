package com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;

public class S3ClientDemo {
	static final int BUFFER_SIZE = 4096;
	public static void main(String[] args) throws ClientProtocolException, IOException {
		//doPost();
		doGet();
	}


	private static void doGet() throws IOException {
		HttpURLConnection httpConn = getConnection(null, "GET");
		int responseCode = httpConn.getResponseCode();

		if (responseCode == HttpURLConnection.HTTP_OK) {
			File output = new File("/Users/navink/buildCopy2.xml");
			InputStream inputStream = httpConn.getInputStream();
			FileOutputStream outputStream = new FileOutputStream(output);
			byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
	        System.out.println("Receiving data...");
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }
	         
	        System.out.println("Data received.");
	        outputStream.close();
	        inputStream.close();
	         
	        System.out.println("File written to: " + output.getAbsolutePath());
			
		} else {
            System.out.println("Server returned non-OK code: " + responseCode);
        }
	}

	private static void doPost() throws IOException {
		File uploadFile = new File("build.xml");
		HttpURLConnection httpConn = getConnection(uploadFile, "POST");
        
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

	private static HttpURLConnection getConnection(File uploadFile, String type) throws IOException {
		String urlString = "http://localhost:8080/com.navink.wtp.first/FileCounter";
		URL url = new URL(urlString);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setUseCaches(false);
        httpConn.setDoOutput(true);
        httpConn.setRequestMethod(type);
        if (type.equalsIgnoreCase("POST"))
        httpConn.setRequestProperty("fileName", uploadFile.getName());
        return httpConn;
	}

}
