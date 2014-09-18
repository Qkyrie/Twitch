###OAuth 2 authentication mechanism

Using the code we got during the authorization process, we can now fetch an access token. This is done using the accessTokens implementation.

	AccessTokenResponse token = twitch.accessTokens().requestToken(code);
	if (token.getStatus() == AccessTokenResponseEnum.OK) {
		//do something with the token
	} else {
		//something went wrong, check the status of the response
	}