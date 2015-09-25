package com.navink.s3.common;

import com.navink.s3.exceptions.InvalidInputException;
import com.navink.s3.put.S3Request;

public final class ValidationHelper {

	public static void validatePutRequest(S3Request req) throws InvalidInputException {
		doNullCheck(req);
	}

	private static void doNullCheck(S3Request req) throws InvalidInputException {
		if ((req.getBucket() == null) || (req.getBucket().isEmpty()) ||
				(req.getKey() == null) || (req.getKey().isEmpty())) {
			throw new InvalidInputException("Null or empty input");
		}
	}
}
