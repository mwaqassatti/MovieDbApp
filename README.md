# MovieDbApp
This App uses themoviedb API so to run and use this app, you need to create file in root directory of the project as "keys.properties".
Inside this "keys.properties" file add your API key your got from themoviedb account as below
MOVIEDB_API_KEY=YOUR_APP_API_KEY
So the app level build.gradle read API key from keys.properties and uses it within project for API calls
