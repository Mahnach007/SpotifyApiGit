# SpotifyApiGit

Summary

This is an API for the Spotify. This project - is an implementation REST API for creating, retrieving, editing and deleting objects by using REST requests: POST, PUT, DELETE, GET.

Requirements

Java version 15.0.2 or higher
Apache Maven version 3.8.6 or higher.
Build and Run

Compile and run a Spotify service application:

Run file:

1. Download the project from GitHub in .zip format and unzip it to any folder or just commit it to your local repository
2. Open the command bar and navigate to the project path (for example: D:\My Projects\SpotifyApi)
3. Execute the command "mvn spring-boot:run" and check the full launch of the program. Make sure that port 8081 is not occupied by another process
4. Go to the Postman application and send the necessary requests to use the API!
The API will be accessible by http://localhost:8081

Detailed

For sending REST requests is easy to use the Postman app.

Link - https://www.postman.com/mahnach007/workspace/spotifyapi/collection/21526511-9bc35429-a214-4ded-b891-7b1dc8cdb12c?action=share&creator=21526511

Get all entities of this type(GET):

getAll() - returns all entities corresponding to this service <br />
http://localhost:8081/album 

http://localhost:8081/artists
http://localhost:8081/song
http://localhost:8081/label
http://localhost:8081/text

Get the object of a certain type by id(GET):

http://localhost:8081/album/{id}
http://http://localhost:8081/artists{id}
http://http://localhost:8081/song{id}
http://http://localhost:8081/label{id}
http://http://localhost:8081/text{id}

Create the object of this type(POST):

http://localhost:8081/album
http://localhost:8081/artists
http://localhost:8081/song
http://localhost:8081/label
http://localhost:8081/text
Edit the object of this type by id(PUT):

http://localhost:8081/album/{id}
http://http://localhost:8081/artists{id}
http://http://localhost:8081/song{id}
http://http://localhost:8081/label{id}
http://http://localhost:8081/text{id}

Delete the object of this type by id(DELETE):

http://localhost:8081/album/{id}
http://http://localhost:8081/artists{id}
http://http://localhost:8081/song{id}
http://http://localhost:8081/label{id}
http://http://localhost:8081/text{id}
