##Public Streams Resource

>The example codes assume that you have an autowired or fully initialized version of the 
Twitch class. No authentication is required for these operations

###Fetching a list of the top 25 Streams on Twitch

	List<TwitchStream> currentTopList = twitch.streams();

###Get the public information of a stream

	Optional<StreamCheck> twitchStream = twitch.stream("streamingforanimals");
	
The result of the **stream(String streamName)** method is wrapped in an Optional of StreamCheck response. If the Optional returns false for an entity to be present, this means that the stream does not exist and cannot be found on the Twitch.tv servers. If it is present, you can check on the object to see if it is up and running or not.

	twitch.streams().stream("streamingforanimals").get().isOnline()
	
or an elegant alternative
	
	streamChecker.stream("streamingforanimals").ifPresent(
    	stream -> System.out.println(stream.isOnline())
    );	
