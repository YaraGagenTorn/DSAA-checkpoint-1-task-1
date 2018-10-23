/**
 * @author 90053232 Yara Gagen-Torn
 **/

public class Patient {
/* Class Patient has 4 fields:
* Patient ID: [patientID]
* Name: [name]
* Check In Date: [checkInDate]
* Assigned Medical Personnel: [assignedPersonnel]
*/
    
  private String patientID;
  private String name;
  private String checkInDate;
  private String assignedPersonnel;

  //Class constructor, assigne the value to the each field
  public Patient (String patientID, String name, String checkInDate, String assignedPersonnel){
    this.patientID = patientID;
    this.name = name;
    this.checkInDate = checkInDate;
    this.assignedPersonnel = assignedPersonnel;
}

  //Display patient information
  
@Override  
public String toString(){
    return "Patient ID: " + patientID + "\nName: " + name +"\nCheck In Date: " 
            + checkInDate + "\nAssigned Medical Personnel: " + assignedPersonnel;
   }
}