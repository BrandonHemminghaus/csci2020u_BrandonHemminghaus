package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

//I used lab 05 to help me get all the info I need for the table
public class train {
    public static ObservableList<Testfile> getAllInfo(){
        ObservableList<Testfile> info = FXCollections.observableArrayList();
        //Path for the ham text files
        String path = "C:\\csci2020u\\Assignment-1\\src\\sample\\data\\train\\ham";
        File newpath = new File(path);
        File[] filelist = newpath.listFiles();

        //Path for the spam text files
        String path2 = "C:\\csci2020u\\Assignment-1\\src\\sample\\data\\train\\spam"; //Path for the spam text files
        File newpath2 = new File(path2);
        File[] filelist2 = newpath2.listFiles();

        //goes throught the given path and reads each file in it
        for(int i =0; i < filelist.length; i++){
            //this is the spam probability
            double Spam = 1.0/filelist2.length;
            double ham = 1.0/filelist.length;
            double Probability = Spam/ham;

            info.add(new Testfile(filelist[i].getName(),Probability,newpath.getName()));
        }
        return info;
    }
}
