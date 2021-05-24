package javaVersionlearning;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;

public class java11 {

	public void test() {
		try {
			// Java 11 
			var request = HttpRequest.newBuilder().uri(new URI("https://postman-echo.com/get"))
			.GET()
			.build();
			System.out.println(request);
			
			var client = HttpClient.newBuilder().version(Version.HTTP_2).build();
			String result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
					.thenApply(HttpResponse::body)
					.get();
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
