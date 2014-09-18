##Disclaimer
As this is an ongoing development, there has not been an official release yet. The moment we do, our packages will be available in the public maven repository. As of now, you'll have to install the module on your own development machine. Our first release is expected by **the end of September 2014**.

##Including the Twitch Boot Starter module in your Spring Boot Application

Including the Twitch Boot Starter module in your own spring boot application is a piece of cake. We made sure you had to do as less work as possible, so **you can focus on your own project**.

*build.gradle*

	
	dependencies {
	    compile("org.springframework.boot:spring-boot-starter:1.1.6.RELEASE")
	    compile project('com.de-swaef.twitch:twitch-boot-starter:1.0.0-SNAPSHOT')
	}

*application.properties*

	twitch.baseUrl=https://api.twitch.tv/kraken
	twitch.clientId=[client id comes here]
	twitch.clientSecret=[client secret comes here]
	twitch.redirectURI=[redirect URI comes here]

That's it.

Your application can now successfully connect to twitch using the API. 

##Accessing the API
We automatically provide an instance