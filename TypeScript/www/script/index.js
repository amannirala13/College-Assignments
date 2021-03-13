"use strict";
const videoPlayer = document.getElementById('video_player');
const videoPlayerContainer = document.getElementById('video_player_container');
videoPlayerContainer.height = window.innerHeight;
videoPlayerContainer.width = window.innerWidth;
/*import {SockJS} from "./sockjs.min.js"*/
// @ts-ignore
let sock = new SockJS("http://127.0.0.1:3000/arduino");
sock.onopen = () => {
    console.log("Connection to backend open!");
};
sock.onmessage = (e) => {
    console.log(e.data);
};
sock.onclose = () => {
    console.log("Connection to backend closed!");
};
