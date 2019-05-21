package org.willclark.oauthsforce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	private SalesforceQueryService sforce;

	@GetMapping
	public List<Account> list(OAuth2Authentication principal) {
		return sforce.accounts(principal);
	}

}
