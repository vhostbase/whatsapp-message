package org.tharak.core.msgs.test;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpTest {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		//HttpPost httpPost = new HttpPost("http://localhost:8080/adminMessage");
		HttpPost httpPost = new HttpPost("http://whatschat-whatschat.apps.us-east-2.online-starter.openshift.com/adminMessage");
		httpPost.setEntity(new StringEntity("Testing"));
		httpPost.setHeader("Content-Type", "text/plain");
		httpClient.execute(httpPost);
	}

}
