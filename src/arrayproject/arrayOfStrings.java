package arrayproject;

import java.io.*;
import java.util.*;

/**
 * @author george oster
 */
class arrayOfStrings implements Serializable {

    File input;
    File output;
    int size = 0;
    String array[];
    int foundornot;
    
    //declaring these as transient allows the class to have a method to write itself as an object file
    
    transient PrintWriter write;
    transient FileInputStream arrayReadAsObject;
    transient FileOutputStream arrayWrittenAsObject;
    transient ObjectInputStream objectFileReader;
    transient ObjectOutputStream objectFileWriter;
    transient FileReader text;
    transient BufferedReader reader;
    transient Scanner infile;
   

    public arrayOfStrings() {
    }

    public arrayOfStrings(int s) {
        size = s;
        array = new String[size];
    }

    public arrayOfStrings(String filename) throws IOException {
        
        text = new FileReader(filename);
        reader = new BufferedReader(text);
        input = new java.io.File(filename);
        infile = new Scanner(input);

        if (filename.endsWith(".txt")) {//begin endsWith .txt

            while (reader.readLine() != null) 
                size++;
          
            array = new String[size];

            for (int i = 0; i < size; i++) 
                array[i] = infile.nextLine();
            
            reader.close();
        }//end endsWith .txt

        if (filename.endsWith(".csv")) {//begin endsWith .csv   
           
            while (reader.readLine() != null) 
                size++;
            
            array = new String[size];

            for (int i = 0; i < size; i++) 
                array[i] = infile.nextLine();
            
            reader.close();

        }//end endsWith.csv
    }

    public void writeAsObject(String name, arrayOfStrings instance) throws Exception {
        
        arrayWrittenAsObject = new FileOutputStream(name + "ArrayOfStringsAsAnObject.ser");
        objectFileWriter = new ObjectOutputStream(arrayWrittenAsObject);
        objectFileWriter.writeObject(instance);
        objectFileWriter.close();
        
    }

    
    public void writeAsTextFile(String name) throws FileNotFoundException {
        
        output = new java.io.File(name + "ArrayOfStringsAsTextFile.txt");
        write = new java.io.PrintWriter(output);

        for (int i = 0; i < size - 1; i++) 
            write.println(array[i]);
        
        write.print(array[size - 1]);
        write.close();
        
    }

    
    public void writeAsCSVFile(String name) throws FileNotFoundException {
        
        output = new java.io.File("ArrayOfStringsAsCSVFile.csv");
        write = new java.io.PrintWriter(output);

        for (int i = 0; i < size - 1; i++) 
            write.print(array[i] + ",");
        
        write.print(array[size - 1]);
        write.close();
        
    }

    
    public arrayOfStrings readAsObject(String name) throws Exception {
        
        arrayReadAsObject = new FileInputStream(name + "ArrayOfStringsAsAnObject.ser");
        objectFileReader = new ObjectInputStream(arrayReadAsObject);

        arrayOfStrings tempFromObjectFile;
        tempFromObjectFile = (arrayOfStrings) objectFileReader.readObject();

        objectFileReader.close();
        return tempFromObjectFile;
        
    }

    
    public void readFromTextFile(String filename) throws IOException {
        
        text = new FileReader(filename);
        reader = new BufferedReader(text);
        input = new java.io.File(filename);
        infile = new Scanner(input);
        size = 0; // just in case someone instantiates and then tries to use this method
        // this way size will still be how many elements are currently in the array

        while (reader.readLine() != null) 
            size++;
        
        array = new String[size];

        for (int i = 0; i < size; i++) 
            array[i] = infile.nextLine();
        
        reader.close();
    }

    
    public void readFromCSVFile(String filename) throws IOException {
        text = new FileReader(filename);
        reader = new BufferedReader(text);
        input = new java.io.File(filename);
        infile = new Scanner(input);
        size = 0; // just in case someone instantiates and then tries to use this method
        // this way size will still be how many elements are currently in the array

        while (reader.readLine() != null) 
            size++;
        
        array = new String[size];

        for (int i = 0; i < size; i++) 
            array[i] = (infile.nextLine());
        
        reader.close();
    }

    
    public void insertAt(int n, String tobeadded) {
        if (size >= array.length) 
            System.out.println("I'm sorry, but the array is full. You must delete an item before you can insert one.");
       
        if (size < array.length) {
            for (int i = size; i > n; i--) 
                array[i] = array[i - 1];
            
            array[n] = tobeadded;
            size++;
        }
    }

    
    public void appendTo(String tobeadded) {
        if (size >= array.length) 
            System.out.println("I'm sorry, but the array is full. You must delete an item before you can insert one.");

        if (size < array.length) {
            array[size] = tobeadded;
            size++;
        }
    }

    public void sort() {
        boolean swapped;
        do {
            swapped = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1].compareToIgnoreCase(array[i]) < 0) {

                    String temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    swapped = true;
                }//end if loop
            }// end for loop
        } while (swapped);
    }

    
    public void search(String tobefound) {
       
        foundornot = 0;
        for (int i = 0; i < size; i++) 
            if (array[i].equalsIgnoreCase(tobefound)) 
                foundornot++;
            
      
        if (foundornot > 0) 
            System.out.println("The item you are searching for does exist.");
        
        if (foundornot < 1) 
            System.out.println("The item you are searching for does not exist");
        
    }

    
    public void deleteFromArray(int n) {
        for (int i = n; i < size - 1; i++) 
            array[i] = array[i + 1];
        
        array[size - 1] = null;

        size--;
    }

    
    public String getElement(int n) {
        return array[n];
    }

    
    public void setElement(int n, String newelement) {
        array[n] = newelement;
    }

    
    public String[] cloneArray() {
        String[] temp = new String[array.length];
        for (int i = 0; i < array.length; i++) 
            temp[i] = array[i];
        
        return temp;
    }

    
    public boolean isFull() {
        boolean fullOrNot = true;
        if (size == array.length) 
            fullOrNot = false;
        
        return fullOrNot;
    }

    
    public boolean isEmpty() {
        boolean emptyOrNot = false;
        if (size == 0) 
            emptyOrNot = true;
        
        return emptyOrNot;
    }

    
    public void whatIsHappening() {
        System.out.println("Here is the array as it stands right now");
        for (int i = 0; i < array.length; i++) 
            System.out.println(array[i]);
        
    }

}//end arrayOfIntegers

