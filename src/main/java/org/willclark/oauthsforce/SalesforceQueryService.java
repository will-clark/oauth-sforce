package org.willclark.oauthsforce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SalesforceQueryService {

	private static final String REST_VERSION = "35.0";

	@Autowired
	private OAuth2RestTemplate restTemplate;

	private static String restUrl(OAuth2Authentication principal) {
		HashMap<String, Object> details = (HashMap<String, Object>) principal.getUserAuthentication().getDetails();
		HashMap<String, String> urls = (HashMap<String, String>) details.get("urls");
		return urls.get("rest").replace("{version}", REST_VERSION);
	}

	public List<Account> accounts(OAuth2Authentication principal) {
		String url = restUrl(principal) + "query/?q={q}";

		Map<String, String> params = new HashMap<>();
		params.put("q", "SELECT Id, Name FROM Account");

		return restTemplate.getForObject(url, QueryResultAccount.class, params).records;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class QueryResult<T> {

		public List<T> records;
	}

	private static class QueryResultAccount extends QueryResult<Account> {}

}