/**
 *
 * @author 90053232
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.LineNumberReader;
import java.util.Scanner;

public class myMain {
    public static ArrayList<String> ar = new ArrayList<String>();
    public static void main(String []args) {
        obtainRecords();//create an array list
        searchRecord();//search in an array list
    }

    public static void obtainRecords(){
        String path = "src/ListOfPatients.txt";
        LineNumberReader lr = null; //allows to read information from the file line by line
        String[] oneRecord = new String[4]; //an array to store info about one patient
        Patient pat;
        
        try { 
        //using try-catch for exception handling to catch
        //possible errors with i/o operations
        FileReader inputStream = new FileReader(path);
        //FileReader reads the file’s contents
        lr = new LineNumberReader(inputStream);
        String str;
        while((str = lr.readLine())!= null) {
        //while the next line exists
        oneRecord = str.split(",");
        //dividing one file line by commas and assigning to array
        pat = new Patient(oneRecord[0], oneRecord[1], oneRecord[2], oneRecord[3]); 
        String patStr = pat.toString();
        ar.add(patStr);//adding patient to the ArrayList
        }
        }
        
        catch(IOException ioe){
            System.out.println("IOExcception occured");
        }
}
    
public static void searchRecord(){
    Scanner sc = new Scanner(System.in);
    System.out.println ("Press S for search, Press E for exit");
    String input = sc.next();//waiting for user input
    boolean searchSwitch = false; 
    int sizePatArrayList = ar.size();//getting the length of patients array list
    if (input.equals("S") || input.equals("s")){//if S
        System.out.println ("Enter Patient ID to search");
        input = sc.next();
        for(int i = 0; i < ar.size(); i++){ //searching for the record
            if (ar.get(i).contains(input)){
                searchSwitch = true;
                System.out.println (ar.get(i) + "\n");
                System.out.println ("Would you like to remove the patient's "
                        + "record(s)?\n" + "Y or N?");
                input = sc.next();
                if (input.equals("Y") || input.equals("y")){
                    ar.remove(i);
                    System.out.println ("Record(s) removed successfully");
                    //System.out.println ("The new list of patients:\n" + ar);
                }
                if (input.equals("N") || input.equals("n")){
                System.out.println (searchSwitch);
                System.out.println ("You've choosed do not delete the record.");
                searchRecord();
                }
            }

        } 
        if (!(searchSwitch)){
            System.out.println ("The search found no matching patient.");
        };
        searchRecord();
    }

    if (input.equals("E") || input.equals("e")){//if E
        System.out.println ("Bye...!"); 
        System.exit(0);
    }
    }
}



