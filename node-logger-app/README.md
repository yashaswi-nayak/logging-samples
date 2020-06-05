# Simple Node Server Logger

This repo contains a simple node-express server.

To run the server, execute the following commands.

    $ npm install 
    $ node index.js

Browse the url `http://localhost:3000` in your browser.

The server has two APIs available

1. `/` - This returns text 'Hello from Express'
2. `/logs/:type` - This returns dynamic text based on the param `:type` which can be any of the following - info / error /debug / warn