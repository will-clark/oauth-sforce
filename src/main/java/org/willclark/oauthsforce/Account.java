package org.willclark.oauthsforce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Account {

	public String Id;
	public String Name;
}
