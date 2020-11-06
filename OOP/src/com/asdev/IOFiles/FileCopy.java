package com.asdev.IOFiles;

import java.io.*;

public class FileCopy {

    public FileInputStream input = null;
    public FileOutputStream output = null;

    public File getFile(String address) {
        return new File(address);
    }

    public void copyContent(String from, String to, boolean isAppend) throws IOException {
        input = new FileInputStream(getFile(from));
        output = new FileOutputStream(getFile(to), isAppend);
        int c;
        try{
        while((c = input.read()) != -1){
            output.write(c);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        if(input!=null)
            input.close();
        if(output!=null)
            output.close();
    }


    public static void main(String[] args) {
        FileCopy f = new FileCopy();
        try {
            f.copyContent("D:\\Academics\\CollegeMaterial\\College-Assignments-Github\\OOP\\src\\com\\asdev\\array\\test.txt",
                    "D:\\Academics\\CollegeMaterial\\College-Assignments-Github\\OOP\\src\\com\\asdev\\array\\output.txt",
                    false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
