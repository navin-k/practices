package com.navink.s3.put;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.navink.s3.common.ValidationHelper;
import com.navink.s3.exceptions.InvalidInputException;

public class PutHandler {

	public HttpServletResponse handleRequest(
			HttpServletRequest req, HttpServletResponse res) {
		try {
			ValidationHelper.validatePutRequest(createPutRequest(req));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Store file
		//Create response
		return null;
	}

	private S3Request createPutRequest(HttpServletRequest req) {
		S3Request request = new S3Request();
		request.setBucket(req.getParameter("bucket"));
		request.setKey(req.getParameter("key"));
		return request;
	}
}
