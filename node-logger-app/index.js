const express = require('express');
const app = express();
const port = process.env.PORT || "3000";
const logger = require('./logger');

app.get("/", (req, res) => {
    logger.info('Hello');
    res.status(200).send("Hello from express");
});

app.get("/logs/:type", (req, res) => {
    let message = ''
    switch (req.params.type) {
        case 'info':
            message = 'Here\'s an info message'
            logger.info(message);
            break;
        case 'error':
            message = 'Oops an ERROR'
            logger.error(message);
            break;
        case 'debug':
            message = 'Just a debug message'
            logger.debug(message);
            break;
        case 'warn':
            message = 'I am warning you!'
            logger.warn(message);
            break;
        default:
            message = 'Default debug!!!'
            logger.debug(message);
            break;
    }
    res.status(200).send("Express says: " + message);
})

const server = app.listen(port, (req, res) => {
    logger.info('Listening on Port: ' + port);
})

module.exports = server;