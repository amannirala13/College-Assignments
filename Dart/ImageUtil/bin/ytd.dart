import 'package:youtube_explode_dart/youtube_explode_dart.dart';
import 'package:youtube_explode_dart/src/youtube_explode_base.dart';
import 'dart:io';

String url;
var yt = YoutubeExplode();
Video video;

void main(List<String> arguments){

  if(arguments.isEmpty){
    print('Enter youtube video URL: ');
    url = stdin.readLineSync();
  }else{
    url = arguments[0];
  }
  loadVideoFromURL();
}

void loadVideoFromURL() {
  print('Loading video... Please wait...');
  var videoRes = yt.videos.get(url);
  videoRes.then((value) =>
    gotVideo(value));
}

void gotVideo(Video value) {
  video = value;
  print('Title: ${video.title}');
  print('Description: ${video.description}');
  print('Duration: ${video.duration}');
  print('Author: ${video.author}');

  yt.videos.streamsClient.getManifest(url).then((value) => getStreamManifest(value));

}

void getStreamManifest(StreamManifest value) async {
  var manifest = value;
  var streamInfo = manifest.muxed.sortByVideoQuality().last;
  if(streamInfo != null){
    var stream = yt.videos.streamsClient.get(streamInfo);
    var file = File('test.mp4');
    var filestream = file.openWrite();
    print('Downloading... Please wait...');
    await stream.pipe(filestream);
    print('Done!');
  }
}