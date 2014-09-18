##Public Streams Resource

>The example codes assume that you have an autowired or fully initialized version of the 
Twitch class. No authentication is required for these operations.

###Fetching the public information of a Channel

	Optional<TwitchChannel> channel = twitch.channels().channel("streamingforanimals");