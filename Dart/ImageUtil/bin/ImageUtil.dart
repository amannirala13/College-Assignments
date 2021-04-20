import 'package:image/image.dart';
import 'dart:core';
import 'dart:io' as io;

// Variable definition for image object and path
Image image;
String path;

// The main function
void main(List<String> arguments) {

  print('----------------- IMAGE CONVERTOR -----------------');

  print('Enter JPG image path: ');
  path = io.stdin.readLineSync();   // Accept image path

  choosePresentFormat();

}

// Choosing present file format to get the raw byte data
void choosePresentFormat() {
  print('Select the format of your image:\n'
      '1 - JPG\n'
      '2 - PNG\n'
      '3 - WEBP\n'
      '4 - ICO\n'
      '5 - PSD\n');

  // Input of choice
  var choice = int.parse(io.stdin.readLineSync());
  switch(choice){
    case 1: loadJPGImage(path);break;
    case 2: loadPNGImage(path);break;
    case 3: loadWebPImage(path);break;
    case 4: loadIcoImage(path);break;
    case 5: loadPsdImage(path);break;
    default:
      print('Invalid choice');
      choosePresentFormat();
  }

  chooseAction();
}

// Choosing the format to export the image
void chooseAction() {
  print('Select the output format of your image:\n'
      '1 - JPG\n'
      '2 - PNG\n'
      '3 - ICO\n'
      '4 - Byte\n');
  var choice = int.parse(io.stdin.readLineSync());
  switch(choice){
    case 1: exportToJPG();break;
    case 2: exportToPNG();break;
    case 3: exportToICO();break;
    case 4: exportToByte();break;
    default:
      print('Invalid choice');
      chooseAction();
  }
}

// Loading a JPG image
void loadJPGImage(String uri){
  try{
    image = decodeJpg(io.File(uri).readAsBytesSync());
  }catch(e){
    print(e);
  }
}

// Loading a PNG image
void loadPNGImage(String uri){
  try{
    image = decodePng(io.File(uri).readAsBytesSync());
  }catch(e){
    print(e);
  }
}

// Loading an ICO image
void loadIcoImage(String uri){
  try{
    image = decodeIco(io.File(uri).readAsBytesSync());
  }catch(e){
    print(e);
  }
}

// Loading a WEBP image
void loadWebPImage(String uri){
  try{
    image = decodeWebP(io.File(uri).readAsBytesSync());
  }catch(e){
    print(e);
  }
}

// Loading a PSD file
void loadPsdImage(String uri){
  try{
    image = decodePsd(io.File(uri).readAsBytesSync());
  }catch(e){
    print(e);
  }
}



// Exporting to JPG image file
void exportToJPG(){
  try {
    var output = encodeJpg(image);
    io.File('${DateTime
        .now()
        .microsecond}.jpg').writeAsBytes(output);
  }catch(e){
    print(e);
  }
}

// Exporting to PNG image file
void exportToPNG(){
  try{
  var output = encodePng(image);
  io.File('${DateTime.now().microsecond}.png').writeAsBytes(output);
  }catch(e){
    print(e);
  }

}

// Exporting to ICO image file
void exportToICO(){
  try{
  var output = encodeIco(image);
  io.File('${DateTime.now().millisecond}.ico').writeAsBytes(output);}
  catch(e){
    print(e);
  }
}

// Exporting to Byte file
void exportToByte(){
  try{
    io.File('${DateTime.now().millisecond}.bytes').writeAsBytes(image.data);}
  catch(e){
    print(e);
  }
}
