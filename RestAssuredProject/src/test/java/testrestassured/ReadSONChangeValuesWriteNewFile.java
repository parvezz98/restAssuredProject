package testrestassured;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 2. Read a JSON file, change some values and write the xml in to new file.
EG: name : 'Wipro' to name : 'Wipro Ltd'
Ans:

Input Json File-

{
      "address":"Bangalore",
	  "country": "India",
      "offices":[
   
      "city:bangalore",
      "area:electroniccity"
   ],
    "Name":"Wipro"
}


Output JSON File-

{
   "country":"India",
   "address":"Bangalore",
   "offices":[
      "city:bangalore",
      "area:electroniccity"
   ],
   "Name":"Wipro Ltd"
}

 */

public class ReadSONChangeValuesWriteNewFile {
	
	public static void main(String[] args) {
		 JSONParser parser = new JSONParser();
	      try {
	    	  //Reading the file
	         Object obj = parser.parse(new FileReader("C:/TextXML/testJson.json"));
	         JSONObject jsonObject = (JSONObject)obj;
	         
	         //Reading the name from JSON
	         String name = (String)jsonObject.get("Name");
	         //Printing the name value
	         System.out.println("Name: " + name);
	         
	         //Changing Name value from Wipro to Wipro Ltd
	         jsonObject.put("Name", "Wipro Ltd");
	         String newname = (String)jsonObject.get("Name");
	         //Printing the new value
	         System.out.println(newname);
	         
	         //Creating new file
	         FileWriter file = new FileWriter("C:/TextXML/newtestJson.json") ;
	        	 
	         //Writing updated json to newly created file
	             file.write(jsonObject.toJSONString());
	             file.flush();

	        
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
	}


