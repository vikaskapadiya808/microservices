package com.s3storage;

import java.io.IOException;
import java.io.InputStream;

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class S3Utils {
	 private static final String BUCKET = "bucket885709";
     
	    public static void uploadFile(String fileName, InputStream inputStream)
	            throws S3Exception, AwsServiceException, SdkClientException, IOException {
	        S3Client client = S3Client.builder().build();
	         
	        PutObjectRequest request = PutObjectRequest.builder()
	                            .bucket(BUCKET)
	                            .key(fileName)
	                            .build();
	         
	        client.putObject(request,
	                RequestBody.fromInputStream(inputStream, inputStream.available()));
	    }
}
