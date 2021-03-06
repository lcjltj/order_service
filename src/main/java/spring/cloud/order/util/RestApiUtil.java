package spring.cloud.order.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestApiUtil<T> {

	private final RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	public ResponseEntity<T> get(String url, HttpHeaders httpHeaders) {
		return callApiEndpoint(url, HttpMethod.GET, httpHeaders, null, (Class<T>) Object.class);
	}

	public ResponseEntity<T> get(String url, HttpHeaders httpHeaders, Class<T> clazz) {
		return callApiEndpoint(url, HttpMethod.GET, httpHeaders, null, clazz);
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<T> post(String url, HttpHeaders httpHeaders, Object body) {
		return callApiEndpoint(url, HttpMethod.POST, httpHeaders, body, (Class<T>) Object.class);
	}

	public ResponseEntity<T> post(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
		return callApiEndpoint(url, HttpMethod.POST, httpHeaders, body, clazz);
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<T> put(String url, HttpHeaders httpHeaders, Object body) {
		return callApiEndpoint(url, HttpMethod.POST, httpHeaders, body, (Class<T>) Object.class);
	}

	public ResponseEntity<T> put(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
		return callApiEndpoint(url, HttpMethod.POST, httpHeaders, body, clazz);
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<T> delete(String url, HttpHeaders httpHeaders) {
		return callApiEndpoint(url, HttpMethod.GET, httpHeaders, null, (Class<T>) Object.class);
	}
	
	public ResponseEntity<T> delete(String url, HttpHeaders httpHeaders, Class<T> clazz) {
		return callApiEndpoint(url, HttpMethod.GET, httpHeaders, null, clazz);
	}
	
	private ResponseEntity<T> callApiEndpoint(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Object body,
			Class<T> clazz) {
		return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body,httpHeaders), clazz);
	}
	

}
