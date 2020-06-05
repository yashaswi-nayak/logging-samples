# Simple Springboot Server Logger

This repo contains a simple springboot server.

To run the server, execute the following command.

    $ mvnw spring-boot:run

Browse the url `http://localhost:8080` in your browser.

To package and run the code, execute the following command.

    $ mvn package
    $ cd ./target
    $ java -jar demologger-0.0.1-SNAPSHOT.jar

The server has two APIs available

1. `/` - This returns text 'Hello from Express'
2. `/logs/{logType}` - This returns dynamic text based on the param `{logType}` which can be any of the following - info / error /debug / warn.