package arrayproject;

import java.io.*;
import java.util.*;

public class arrayOfObjects implements Serializable {

    int size;
    int foundornot;
    newspaper[] array;
    String[] temp;

    File input;
    File output;
    
    //declaring these as transient allows the class to have a method to write itself as an object file
    
    transient PrintWriter write;
    transient FileInputStream arrayReadAsObject;
    transient FileOutputStream arrayWrittenAsObject;
    transient ObjectInputStream objectFileReader;
    transient ObjectOutputStream objectFileWriter;
    transient Scanner infile;
    transient FileReader text;
    transient BufferedReader reader;

    public arrayOfObjects() {
    }

    public arrayOfObjects(int s) {
        
        size = s;
        array = new newspaper[size];
        
    }

    public arrayOfObjects(String filename) throws Exception {
        
        text = new FileReader(filename);
        reader = new BufferedReader(text);
        input = new java.io.File(filename);
        infile = new Scanner(input);
        size = 0; // just in case someone instantiates and then tries to use this method
        // this way size will still be how many elements are currently in the array

        while (reader.readLine() != null) 
            size++;
        
        array = new newspaper[size];
        temp = new String[5];

        for (int i = 0; i < size; i++) {
            
            temp = infile.nextLine().split(",");
            array[i] = new newspaper();
            array[i].setName(temp[0]);
            array[i].setCirculation(temp[1]);
            array[i].setCity(temp[2]);
            array[i].setState(temp[3]);
            array[i].setISSN(temp[4]);
            
        }
        
        reader.close();
    }

    
    public void readFromCSV(String filename) throws FileNotFoundException, IOException {
        
        text = new FileReader(filename);
        reader = new BufferedReader(text);
        input = new java.io.File(filename);
        infile = new Scanner(input);
        size = 0; // just in case someone instantiates and then tries to use this method
        // this way size will still be how many elements are currently in the array

        while (reader.readLine() != null) 
            size++;

        array = new newspaper[size];
        temp = new String[5];

        for (int i = 0; i < size; i++) {
            
            temp = infile.nextLine().split(",");
            array[i] = new newspaper();
            array[i].setName(temp[0]);
            array[i].setCirculation(temp[1]);
            array[i].setCity(temp[2]);
            array[i].setState(temp[3]);
            array[i].setISSN(temp[4]);
            
        }
        
        reader.close();
    }

    
    public arrayOfObjects readAsObject(String name) throws Exception {
        
        arrayReadAsObject = new FileInputStream(name + "ArrayOfObjectsAsAnObject.ser");
        objectFileReader = new ObjectInputStream(arrayReadAsObject);

        arrayOfObjects tempFromObjectFile;
        tempFromObjectFile = (arrayOfObjects) objectFileReader.readObject();

        objectFileReader.close();
        return tempFromObjectFile;
        
    }

    
    public void writeAsCSV(String name) throws FileNotFoundException {
        
        output = new java.io.File(name + "ArrayOfNewspapersAsCSVFile.csv");
        write = new java.io.PrintWriter(output);

        for (int i = 0; i < size - 1; i++) 
            write.println(array[i].getName() + "," + array[i].getCirculation() + "," + array[i].getCity() + "," + array[i].getState() + "," + array[i].getISSN());
        
        write.print(array[size - 1].getName() + "," + array[size - 1].getCirculation() + "," + array[size - 1].getCity() + "," + array[size - 1].getState() + "," + array[size - 1].getISSN());
        write.close();
        
    }

    
    public void writeAsObject(String name, arrayOfObjects instance) throws FileNotFoundException, IOException {
        
        arrayWrittenAsObject = new FileOutputStream(name + "ArrayOfObjectsAsAnObject.ser");
        objectFileWriter = new ObjectOutputStream(arrayWrittenAsObject);
        objectFileWriter.writeObject(instance);
        objectFileWriter.close();
        
    }

    
    public void insertAt(int n, String tobeadded) {
        
        if (size >= array.length) 
            System.out.println("I'm sorry, but the array is full. You must delete an item before you can insert one.");
        
        if (size < array.length) {
            for (int i = size; i > n; i--) {
                array[i] = array[i - 1];
            }

            temp = new String[5];
            temp = tobeadded.split(",");
            array[n] = new newspaper();
            array[n].setName(temp[0]);
            array[n].setCirculation(temp[1]);
            array[n].setCity(temp[2]);
            array[n].setState(temp[3]);
            array[n].setISSN(temp[4]);

            size++;
        }
    }

    
    public void appendTo(String tobeadded) {
        
        if (size >= array.length) 
            System.out.println("I'm sorry, but the array is full. You must delete an item before you can insert one.");
        

        if (size < array.length) {
            temp = new String[5];
            temp = tobeadded.split(",");

            array[size] = new newspaper();
            array[size].setName(temp[0]);
            array[size].setCirculation(temp[1]);
            array[size].setCity(temp[2]);
            array[size].setState(temp[3]);
            array[size].setISSN(temp[4]);

            size++;
        }
    }

    public void deleteFromArray(int n) {
        
        for (int i = n; i < size - 1; i++) 
            array[i] = array[i + 1];
        
        array[size - 1] = null;

        size--;
        
    }

    
    public void sort() {
        
        boolean swapped;
        do {
            swapped = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1].getName().compareToIgnoreCase(array[i].getName()) < 0) {
                    newspaper swapper = new newspaper();

                    swapper = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swapper;

                    swapped = true;
                }//end if 
            }// end for 
        } while (swapped);
    }

    
    public arrayOfObjects cloneArray(arrayOfObjects toBeCloned) {
        
        arrayOfObjects placeholder = new arrayOfObjects(toBeCloned.size);

        for (int i = 0; i < toBeCloned.size; i++) {
            
            placeholder.array[i] = new newspaper();
            placeholder.array[i].setName(toBeCloned.array[i].getName());
            placeholder.array[i].setCirculation(toBeCloned.array[i].getCirculation());
            placeholder.array[i].setCity(toBeCloned.array[i].getCity());
            placeholder.array[i].setState(toBeCloned.array[i].getState());
            placeholder.array[i].setISSN(toBeCloned.array[i].getISSN());
            
        }

        return placeholder;
    }

    
    public void search(String tobefound) {
        foundornot = 0;
        for (int i = 0; i < size; i++) 
            if (array[i].getISSN().equals(tobefound)) 
                foundornot++;
          
        if (foundornot > 0) 
            System.out.println("The item you are searching for does exist.");
        
        if (foundornot < 1) 
            System.out.println("The item you are searching for does not exists");

    }

    
    public newspaper getElement(int n) {
        return array[n];
    }

    public void setElement(int n, String newelement) {
        temp = newelement.split(",");
        array[n] = new newspaper();

        array[n].setName(temp[0]);
        array[n].setCirculation(temp[1]);
        array[n].setCity(temp[2]);
        array[n].setState(temp[3]);
        array[n].setISSN(temp[4]);
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

}//end class arrayOfObjects
