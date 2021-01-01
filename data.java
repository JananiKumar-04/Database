package database;

import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


 
public class data {
   private static FileWriter file;

   public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
   	
   	Scanner s=new Scanner(System.in);
   	JSONObject obj = new JSONObject();
   	JSONParser jsonParser = new JSONParser();
   	{
   	System.out.println("Enter key:");
   	String k=s.nextLine();
   	System.out.println("Enter first name:");
   	String f=s.nextLine();
   	System.out.println("Enter last name:");
   	String l=s.nextLine();
   	System.out.println("Enter your role:");
   	String r=s.nextLine();
   	
       
       obj.put("Key",k);
       obj.put("FirstName", f);
       obj.put("LastName", l);
       obj.put("role", r);
       
       JSONObject employeeObject = new JSONObject(); 
       employeeObject.put("employee", obj);
       
   	}
   	
   	JSONArray employeeList = new JSONArray();
    employeeList.add(obj);
       try {

          file = new FileWriter("filename.txt",true);
          file.write(employeeList.toJSONString());
          file.append('\n');
           
           

       } catch (IOException e) {
           e.printStackTrace();

       } finally {

           try {
               file.flush();
               file.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           
       }
       
       
       System.out.println("Do you want to delete the file:Yes/No");
       String str=s.nextLine();
       if(str.equals("Yes"))
       {
       	File myObj = new File("filename.txt"); 
           if (myObj.delete()) { 
             System.out.println("Deleted the file: " + myObj.getName());
           } else {
             System.out.println("Failed to delete the file.");
           } 
        
           
   }

   }

private static void parseEmployeeObject(JSONObject employee) 
{
    //Get employee object within list
    JSONObject employeeObject = (JSONObject) employee.get("employee");
     
    //Get employee first name
    String firstName = (String) employeeObject.get("FirstName");    
    System.out.println(firstName);
     
    //Get employee last name
    String lastName = (String) employeeObject.get("LastName");  
    System.out.println(lastName);
     
}
}
