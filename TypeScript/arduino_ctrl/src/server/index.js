"use strict";
var express = require('express');
var app = express();
var serverSocket = require('socket.io');
var socketPortNumber = 3000;
var serialPort = require('serialport');
var readLine = require('@serialport/parser-readline');
var portName = 'COM10';
var arduinoPort = new serialPort(portName, { baudRate: 9600 });
var parser = arduinoPort.pipe(new readLine());
arduinoPort.on('open', function () {
    console.log("Port open!");
});
parser.on('data', function (data) {
    console.log(data);
});
/*
const server = app.listen(socketPortNumber)
const ioSocket = serverSocket(server)

ioSocket.on('connection', ()=>{
    console.log(ioSocket)
})
*/
