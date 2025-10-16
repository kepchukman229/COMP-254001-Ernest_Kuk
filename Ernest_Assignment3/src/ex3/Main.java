package ex3;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("hi");
        String path = "D:\\Desktop\\Data Structures\\COMP-254001-Ernest_Kuk";
        String fileName = "Main.java";
        find(path, fileName);
    }

    public static void find(String path, String fileName){
        File directory = new File(path);

        if(directory.isDirectory()){
            for(File file : directory.listFiles()){
                //recursion in case if tehre are subdirs
                if(file.isDirectory()){
                    find(file.getAbsolutePath(), fileName);
                }
                else if (file.getName().equalsIgnoreCase(fileName)){
                    System.out.println("File found at: " + file.getAbsolutePath());
                }
            }
        }
        else{
            System.out.println("Invalid directory: " + path);
            return;
        }

    }
}
