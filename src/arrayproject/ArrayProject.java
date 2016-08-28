package arrayproject;

import java.io.*;
import java.util.*;

/**
 * @author george oster
 */
public class ArrayProject {


    public static void main(String[] args) throws IOException, Exception 
    {//begin main method
     Scanner pauser = new Scanner(System.in);
     String thepause;

    System.out.println("This program demonstrates the functionality of the arrayOfIntegers, arrayOfStrings, and");
    System.out.println("arrayOfObjects classes. We will start with the arrayOfIntegers class.");
    System.out.println("An instance of the class arrayOfIntegers will be instantiated and loaded from the file integers.txt.");
    System.out.println("Then whatIsHappening() will be called to display the current state.");
    System.out.print("Press enter when ready");
    thepause = pauser.nextLine();
    
    arrayOfIntegers george = new arrayOfIntegers("integers.txt");
    george.whatIsHappening();
      
    System.out.println("\nPlease confirm that what is displayed matches what is in integers.txt");
    System.out.print("Press enter when ready to continue. ");
    thepause = pauser.nextLine();
    
    System.out.println("\nNow we will test writeAsObject() and readAsObject().");
    System.out.println("We will call writeAsObject() which will write the instance of ");
    System.out.println("arrayOfIntegers to a object file named georgeArrayOfIntegersAsAnObject.ser");
    System.out.print("Press enter when ready to continue. ");
    thepause = pauser.nextLine();
    
    george.writeAsObject("george", george);
    
    System.out.println("\nPlease verify that the file georgeArrayOfIntegersAsAnObject.ser has been written.");
    System.out.print("and press enter when ready to continue. ");
    thepause = pauser.nextLine();
    
    System.out.println("\nNow we will create a new blank instance of arrayOfIntegers and use readAsObject() to ");
    System.out.println("load it from georgeArrayOfIntegersAsAnObject.ser.");
    System.out.println("Then we will call whatIsHappening() to display the new arrayOfInteger");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfIntegers professor = new arrayOfIntegers();
    professor = professor.readAsObject("george");
    professor.whatIsHappening();
    
    System.out.println("\nNotice that the new array which was read from the georgeArrayOfIntegersAsAnObject.ser");
    System.out.println("matches the original array which was read from the text file.");
    System.out.println("Now we will show that writeAsTextFile() and readFromTextFile() works.");
    System.out.println("We will call writeAsTextFile() first.");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    professor.writeAsTextFile("professor");
    
    System.out.println("\nPlease verify that professorArrayOfIntegersAsTextFile.txt has been created, and");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("\nNow we will create a new blank instance of arrayOfIntegers and load it");
    System.out.println("from professorArrayOfIntegersAsTextFile.txt");
    System.out.println("Then we will call whatIsHappening() to display the new instance of arrayOfIntegers.");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfIntegers professorfromtext = new arrayOfIntegers();
    professorfromtext.readFromTextFile("professorArrayOfIntegersAsTextFile.txt");
    professorfromtext.whatIsHappening();
    
    System.out.println("\nNotice that the new array matches the old array.");
    System.out.println("Now we will test deleteFromArray(), insertAt() and appendTo()");
    System.out.println("First we will attempt to insert the integer 109 into index position 3, which will not work because currently the array is full");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    george.insertAt(3, 109);
   
    System.out.println("\nNow we will delete element 3 from the array, and insert the integer 109 into element 3");
    System.out.println("and call whatIsHappening() to display the result.");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    george.deleteFromArray(3);
    george.insertAt(3, 109);
    george.whatIsHappening();
    
    System.out.println("\nNow we will delete element 3 from the array, and use appendTo()  to append the integer 256");
    System.out.println("and then call whatIsHappening() to display the result.");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    george.deleteFromArray(3);
    george.appendTo(256);
    george.whatIsHappening();
    
    System.out.println("\nNow we will sort and call whatIsHappening() to display the sorted array.");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    george.sort();
    george.whatIsHappening();
    
    System.out.println("\nNow we will search for 6789876 which does not exist.");
    System.out.print("Press enter when ready. ");
    thepause = pauser.nextLine();
    
    george.search(6789876);
    
    System.out.println("\nNow we will search for 256, which does exist.");
    System.out.print("Press enter when ready. ");
    thepause = pauser.nextLine();
    
    george.search(256);
    
    System.out.println("\nNow we will use getElement() and set Element().");
    System.out.println("First we will setElement 3 to be 1111111, then we will getElement 3 to see if it worked.");
    System.out.print("Press enter when ready. ");
    thepause = pauser.nextLine();
    
    george.setElement(3, 1111111);
  
    System.out.println("getElement(3) returns: " + george.getElement(3));
     
    System.out.println("\nNow we will demonstrate cloneArray().");
    System.out.println("We will instantiate an empty instance of arrayOfIntegers and then use cloneArray() to load it.");
    System.out.println("We will then use setElement() to change array[0] in the original instance and then run whatIsHappening for both instances");
    System.out.println("to show that they have different values for array[0], thus demonstrating that cloneArray() worked properly");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfIntegers clone = new arrayOfIntegers();
    clone.array = george.cloneArray();
    george.setElement(0, 858688576);
    System.out.println("\nhere is the orignal array which has had array[0] set to a random number after it was cloned");
    george.whatIsHappening();
    System.out.println("And here is the cloned array, which should still have the original value of array[0]");
    clone.whatIsHappening();
    
    System.out.println("\nPress enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("\nLastly, we will demonstrate isFull() and isEmpty().");
    System.out.println("Currently, george is an instance of an array which is full. we will call isFull to show that.");
    System.out.print("Press enter when ready.");
    thepause = pauser.nextLine();
    
    if (george.isFull() == false)
        System.out.println("The array is full");
    if (george.isFull() == true)
        System.out.println("The array is not full");

    System.out.print("\nPress enter when ready. ");
    thepause = pauser.nextLine();
    
    System.out.println("\nNow we will delete an element and call isFull()");
    System.out.print("Press enter when ready. ");
    thepause = pauser.nextLine();
    
    george.deleteFromArray(2);
    if (george.isFull() == false)
        System.out.println("The array is full");
    if (george.isFull() == true)
        System.out.println("The array is not full");
    
    System.out.println("\nNow we will test isEmpty().");
    System.out.println("we will check if the instance george isEmpty(), which of course, it is not empty.");
    System.out.println("Press enter when ready. ");
    thepause = pauser.nextLine();
    
    if (george.isEmpty() == false)
        System.out.println("The array is not empty");
    if (george.isEmpty() == true)
        System.out.println("The array is empty");
    
    System.out.println("\nWe will now create a new instance that is in fact empty");
    System.out.println("and then call isEmpty()");
    System.out.print("Press enter when ready. ");
    thepause = pauser.nextLine();
    
    arrayOfIntegers blank = new arrayOfIntegers();
    if (blank.isEmpty() == false)
        System.out.println("The array is not empty");
    if (blank.isEmpty() == true)
        System.out.println("The array is empty");
    
    System.out.println("\nPress enter when ready to continue.");
    thepause = pauser.nextLine();
    
    System.out.println("\nWe have demonstrated that every method in the arrayOfIntegers class functions properly.");
    System.out.println("We will now do the same thing all over again to demonstrate that every method");
    System.out.println("in the arrayOfStrings class functions properly.");
    System.out.println("Press enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("First we instantiate an instance of the class and load it from the file newspapers.txt");
    System.out.println("then we call the method whatIsHappening() which simply displays the array as it currently is.");
    
    arrayOfStrings georgeString = new arrayOfStrings("newspapers.txt");
    georgeString.whatIsHappening();
    
    System.out.println("I will wait for you to confirm that what is displayed matches what is in newspapers.txt");
    System.out.println("Please hit enter when you are ready to continue");
    thepause = pauser.nextLine();
    
    System.out.println("Now we will test the writeAsObject() method and the readAsObject() method.");
    System.out.println("We will call the writeAsObject() method which will write the instance of ");
    System.out.println("arrayOfStrings to a object file named georgeStringArrayOfStringsAsAnObject.ser");
    
    georgeString.writeAsObject("georgeString", georgeString);
    
    System.out.println("please hit enter once you have verified that the file georgeStringArrayOfStringsAsAnObject.ser has be written.");
    thepause = pauser.nextLine();
    
    System.out.println("Now we will create a new blank instance of arrayOfStrings and use the readAsObject() method to ");
    System.out.println("load it from georgeStringArrayOfStringsAsAnObject.ser");
    System.out.println("then we will call the whatIsHappening() method to display the new arrayOfInteger");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfStrings professorString = new arrayOfStrings();
    professorString = professorString.readAsObject("georgeString");
    professorString.whatIsHappening();
    
    System.out.println("Notice that the new array which was read from the georgeStringArrayOfStringsAsAnObject.ser");
    System.out.println("matches the original array which was read from the text file.");
    System.out.println("Now we will show that writeAsTextFile() and readFromTextFile() works.");
    System.out.println("We will call writeAsTextFile() first.");
    
    professorString.writeAsTextFile("professorString");
    
    System.out.println("Please hit enter after you have verified that professorStringArrayOfStringsAsTextFile.txt exists");
    thepause = pauser.nextLine();
    
    System.out.println("Now we will create a new blank instance of arrayOfStrings and load it");
    System.out.println("from professorStringArrayOfStringsAsTextFile.txt");
    System.out.println("Then we will call whatIsHappening() to display the new instance of arrayOfStrings.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfStrings professorStringfromtext = new arrayOfStrings();
    professorStringfromtext.readFromTextFile("professorStringArrayOfStringsAsTextFile.txt");
    professorStringfromtext.whatIsHappening();
    
    System.out.println("Notice that the new array matches the old array");
    System.out.println("Now we will test deleteFromArray(), insertAt() and appendTo()");
    System.out.println("First we will attempt to insert GEORGE'S AWESOME NEWSPAPER into index position 3, which will not work because currently the array is full");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeString.insertAt(3, "GEORGE'S AWESOME NEWSPAPER");
    
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
   
    System.out.println("So that did not work because the array was full.");
    System.out.println("Now we will delete element 3 from the array");
    System.out.println("and insert GEORGE'S AWESOME NEWSPAPER into element 3");
    System.out.println("and then call whatIsHappening to display that it worked.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeString.deleteFromArray(3);
    georgeString.insertAt(3, "GEORGE'S AWESOME NEWSPAPER");
    georgeString.whatIsHappening();
    
    System.out.println("So that worked. Now we will delete element 3 from the array"); 
    System.out.println("and use the appendTo() method to append GEORGE'S AWESOME NEWSPAPER");
    System.out.println("and then call whatIsHappening to display that it worked.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeString.deleteFromArray(3);
    georgeString.appendTo("GEORGE'S AWESOME NEWSPAPER");
    georgeString.whatIsHappening();
    
    System.out.println("So that worked.");
    System.out.println("Now we will sort and call whatIsHappening() to display the sorted array.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeString.sort();
    georgeString.whatIsHappening();
    
    System.out.println("So that worked. Now we will search for PROFESSOR NEWSPAPER which does not exist.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeString.search("PROFESSOR NEWSPAPER");
    
    System.out.println("Now we will search for GEORGE'S AWESOME NEWSPAPER, which does exist.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeString.search("GEORGE'S AWESOME NEWSPAPER");
    
    System.out.println("Now we will use getElement and set Element.");
    System.out.println("First we will setElement 3 to be THE BRAND NEW NEWSPAPER");
    System.out.println("then we will getElement 3 to see if it worked.");
    
    georgeString.setElement(3, "THE BRAND NEW NEWSPAPER");
    
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("getElement(3) returns: " + georgeString.getElement(3));
     
    System.out.println("Now we will demonstrate that cloneArray() works.");
    System.out.println("We will instantiate an empty instance of arrayOfStrings and then use cloneArray() to load it");
    System.out.println("We will then use setElement() to change array[0] in the original instance and then run whatIsHappening for both instances");
    System.out.println("to show that they have different values for array[0], thus demonstrating that cloneArray() worked properly");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfStrings cloneString = new arrayOfStrings();
    cloneString.array = georgeString.cloneArray();
    georgeString.setElement(0, "ELEMENT ZERO NEWSPAPER");
    System.out.println("here is the orignal array which has had array[0] set to ELEMENT ZERO NEWSPAPER after it was cloned");
    georgeString.whatIsHappening();
    System.out.println("And here is the cloned array, which should still have the original value of array[0]");
    cloneString.whatIsHappening();
    
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("lastly, we will demonstrate that isFull() and isEmpty() work properly.");
    System.out.println("currently, georgeString is an instance of an array which is full. we will call isFull to show that.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    if (georgeString.isFull() == false)
        System.out.println("The array is full");
    if (georgeString.isFull() == true)
        System.out.println("The array is not full");

    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("Now we will delete an element and call isFull()");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeString.deleteFromArray(2);
    if (georgeString.isFull() == false)
        System.out.println("The array is full");
    if (georgeString.isFull() == true)
        System.out.println("The array is not full");
    
    System.out.println("So that works. Now we will test isEmpty().");
    System.out.println("we will check if the instance georgeString isEmpty(), which of course, it is not empty.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    if (georgeString.isEmpty() == false)
        System.out.println("The array is not empty");
    if (georgeString.isEmpty() == true)
        System.out.println("The array is empty");
    
    System.out.println("so that works. we will now create a new instance that is in fact empty");
    System.out.println("and call isEmpty()");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfStrings blankString = new arrayOfStrings();
    if (blankString.isEmpty() == false)
        System.out.println("The array is not empty");
    if (blankString.isEmpty() == true)
        System.out.println("The array is empty");
    
    System.out.println("Hit enter when ready to continue.");
    thepause = pauser.nextLine();
    
    System.out.println("We have demonstrated that every method in the arrayOfStrings class functions properly.");
    System.out.println("We will now do the same thing all over again to demonstrate that every method");
    System.out.println("in the arrayOfObjects class functions properly.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    

    System.out.println("First we instantiate an instance of the class and load it from the file newspapersData.csv");
    System.out.println("then we call the method whatIsHappening() which simply displays the array as it currently is.");
        
    arrayOfObjects georgeObject = new arrayOfObjects("newspapersData.csv");
    georgeObject.whatIsHappening();
      
    System.out.println("I will wait for you to confirm that what is displayed matches what is in newspapersData.csv.");
    System.out.println("Please hit enter when you are ready to continue");
    thepause = pauser.nextLine();
    System.out.println("Now we will test the writeAsObject() method and the readAsObject() method.");
    System.out.println("We will call the writeAsObject() method which will write the instance of ");
    System.out.println("arrayOfObjects to a object file named georgeObjectArrayOfObjectsAsAnObject.ser");
    
    georgeObject.writeAsObject("georgeObject", georgeObject);
    
    System.out.println("please hit enter once you have verified that the file georgeObjectArrayOfObjectsAsAnObject.ser has be written.");
    thepause = pauser.nextLine();
    
    System.out.println("Now we will create a new blank instance of arrayOfObjects and use the readAsObject() method to ");
    System.out.println("load it from georgeObjectArrayOfObjectsAsAnObject.ser");
    System.out.println("then we will call the whatIsHappening() method to display the new arrayOfObjects");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfObjects professorObject = new arrayOfObjects();
    professorObject = professorObject.readAsObject("georgeObject");
    professorObject.whatIsHappening();
    
    System.out.println("Notice that the new array which was read from the georgeObjectArrayOfObjectsAsAnObject.ser");
    System.out.println("matches the original array which was read from newspapersData.csv");
    System.out.println("Now we will show that writeAsCSV() and readFromCSV() work.");
    System.out.println("We will call writeAsCSV() first.");
    
    professorObject.writeAsCSV("professorObject");
    
    System.out.println("Please hit enter after you have verified that professorObjectArrayOfNewspapersAsCSVFile.csv exists");
    thepause = pauser.nextLine();
    
    System.out.println("Now we will create a new blank instance of arrayOfObjects and load it");
    System.out.println("from professorObjectArrayOfNewspapersAsCSVFile.csv");
    System.out.println("Then we will call whatIsHappening() to display the new instance of arrayOfObjects.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfObjects professorfromtextObject = new arrayOfObjects();
    professorfromtextObject.readFromCSV("professorObjectArrayOfNewspapersAsCSVFile.csv");
    professorfromtextObject.whatIsHappening();
    
    System.out.println("Notice that the new array matches the old array");
    System.out.println("Now we will test deleteFromArray(), insertAt() and appendTo()");
    System.out.println("First we will attempt to insert GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222 into index position 3, which will not work because currently the array is full");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeObject.insertAt(3, "GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222");
    
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
   
    System.out.println("So that did not work because the array was full.");
    System.out.println("Now we will delete element 3 from the array");
    System.out.println("and insert GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222 into element 3");
    System.out.println("and then call whatIsHappening to display that it worked.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeObject.deleteFromArray(3);
    georgeObject.insertAt(3, "GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222");
    georgeObject.whatIsHappening();
    
    System.out.println("So that worked. Now we will delete element 3 from the array"); 
    System.out.println("and use the appendTo() method to append GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222");
    System.out.println("and then call whatIsHappening to display that it worked.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeObject.deleteFromArray(3);
    georgeObject.appendTo("GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222");
    georgeObject.whatIsHappening();
    
    System.out.println("So that worked.");
    System.out.println("Now we will sort and call whatIsHappening() to display the sorted array.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeObject.sort();
    georgeObject.whatIsHappening();
    
    System.out.println("So that worked. Now we will search for ISSN 987654321 which does not exist.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeObject.search("987654321");
    
    System.out.println("Now we will search for 0362-4331, which does exist.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeObject.search("0362-4331");
    
    System.out.println("Now we will use getElement and set Element.");
    System.out.println("First we will setElement 3 to be GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222");
    System.out.println("then we will getElement 3 to see if it worked.");
    
    georgeObject.setElement(3, "GEORGE'S AWESOME NEWSPAPER,123456,SOUTH PHILLY,PA,1111-2222");
    
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("getElement(3) returns: " + georgeObject.getElement(3));
     
    System.out.println("Now we will demonstrate that cloneArray() works.");
    System.out.println("We will instantiate an empty instance of arrayOfObjects and then use cloneArray() to load it");
    System.out.println("We will then use setElement() to change array[0] in the original instance and then run whatIsHappening for both instances");
    System.out.println("to show that they have different values for array[0], thus demonstrating that cloneArray() worked properly");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfObjects cloneObject = new arrayOfObjects();
    cloneObject = cloneObject.cloneArray(georgeObject);    
    georgeObject.setElement(0, "ZERO ELEMENT NEWSPAPER,432432,NEW BOLD,PA,55555-4444");
    System.out.println("here is the orignal array which has had array[0] set to ZERO ELEMENT NEWSPAPER,432432,NEW BOLD,PA,55555-4444 after it was cloned");
    georgeObject.whatIsHappening();
    System.out.println("And here is the cloned array, which should still have the original value of array[0]");
    cloneObject.whatIsHappening();
    
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("lastly, we will demonstrate that isFull() and isEmpty() work properly.");
    System.out.println("currently, georgeObject is full. we will call isFull to show that.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    if (georgeObject.isFull() == false)
        System.out.println("The array is full");
    if (georgeObject.isFull() == true)
        System.out.println("The array is not full");

    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    System.out.println("Now we will delete an element and call isFull()");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    georgeObject.deleteFromArray(2);
    if (georgeObject.isFull() == false)
        System.out.println("The array is full");
    if (georgeObject.isFull() == true)
        System.out.println("The array is not full");
    
    System.out.println("So that works. Now we will test isEmpty().");
    System.out.println("we will check if the instance georgeObject isEmpty(), which of course, it is not empty.");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    if (georgeObject.isEmpty() == false)
        System.out.println("The array is not empty");
    if (georgeObject.isEmpty() == true)
        System.out.println("The array is empty");
    
    System.out.println("so that works. we will now create a new instance that is in fact empty");
    System.out.println("and call isEmpty()");
    System.out.println("Hit enter when ready.");
    thepause = pauser.nextLine();
    
    arrayOfObjects blankObject = new arrayOfObjects();
    if (blankObject.isEmpty() == false)
        System.out.println("The array is not empty");
    if (blankObject.isEmpty() == true)
        System.out.println("The array is empty");
    
    System.out.println("Hit enter when ready to continue.");
    thepause = pauser.nextLine();
    
    System.out.println("We have demonstrated that every method in arrayOfIntegers, arrayOfStrings, and arrayOfObjects works properly");
    System.out.println("Thanks you and good night.");
    
    }//end main method
    
}//end class ArrayProject














