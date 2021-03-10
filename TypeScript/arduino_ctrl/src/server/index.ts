const express = require('express')
const app = express()

const serverSocket = require('socket.io')
const socketPortNumber = 3000

const serialPort = require('serialport')
const readLine = require('@serialport/parser-readline')
const portName = 'COM10'



const arduinoPort = new serialPort(portName,{baudRate: 9600})
const parser = arduinoPort.pipe(new readLine())


arduinoPort.on('open', ()=>{
    console.log("Port open!")
})

parser.on('data', function(data:string){
    console.log(data)
})


/*
const server = app.listen(socketPortNumber)
const ioSocket = serverSocket(server)

ioSocket.on('connection', ()=>{
    console.log(ioSocket)
})
*/
