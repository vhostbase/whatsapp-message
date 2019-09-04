package org.tharak.core.msgs.test;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpTest {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost("http://localhost:8080/paramMessage?msg=Testing");
//		httpPost.setEntity(new StringEntity("Testing"));
		httpClient.execute(httpPost);
	}

}
