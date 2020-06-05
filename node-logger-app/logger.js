const {
    createLogger,
    format,
    transports
} = require('winston');
const {
    combine,
    timestamp,
    label,
    printf
} = format;

var fs = require('fs');
var path = require('path');
var logDir = 'logs'

const myFormat = printf(({
    level,
    message,
    label,
    timestamp
}) => {
    return `${timestamp} [${label}] ${level}: ${message}`;
});

var logger = new createLogger({
    transports: [
        new transports.File({
            filename: 'logs/node-server-logfile.log',
            handleExceptions: true,
            json: false,
            prepend: true,
            level: 'debug',
            format: combine(
                label({
                    label: 'Node File Log'
                }),
                timestamp(),
                myFormat
            )
        }),
        new transports.Console({
            level: 'debug',
            handleExceptions: true,
            colorize: true,
            timestamp: true,
            humanReadableUnhandledException: true,
            format: combine(
                format.colorize(),
                label({
                    label: 'Node Console Log'
                }),
                timestamp(),
                myFormat
            )
        })
    ],
    exitOnError: false
});

module.exports = logger;