package javaVersionlearning;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.util.List;
import java.util.Map;

public class Java9 {
	public static void main(String[] args) {
		// Immutable List
		List<String> list = List.of("a", "b", "c");
		System.out.println("=========Immutable List Test=========");
		for (String item : list) {
			System.out.println(item);
		}

		// Immutable Map
		System.out.println("=========Immutable Map Test=========");
		Map<String, String> map = Map.of("a", "b", "c", "d");
		System.out.println(map.get("a"));
		System.out.println(map.get("c"));

		// Reactive Stream API
		// https://grokonez.com/java/java-9/java-9-flow-api-example-publisher-and-subscriber

		// Http2 Client
		System.out.println("=========Http2 Client Test=========");
		testHttp2Client();
	}

	public static void testHttp2Client() {
		try {
			// Java 9 HTTP2 Client
			var request = HttpRequest.newBuilder()
					.uri(new URI("https://postman-echo.com/get"))
					.GET()
					.build();
			System.out.println(request);

			var client = HttpClient.newBuilder().version(Version.HTTP_2).build();
			String result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
					.thenApply(HttpResponse::body).get();
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
