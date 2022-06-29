package testrestassured;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 1.Read a xml file, change some values and write the xml in to new file.
EG:<name>Wipro</name> to <name>Wipro Ltd<name>

Ans:

Input XML File-

<?xml version = "1.0" encoding = "UTF-8"?>
<Company>
<Details>
         <type>IT</type>
         <name>Wipro</name>
         <address>Bangalore</address>
         <country>India</country>
         <Area>Asia Pacific</Area>
     </Details>
</Company>

Output XML File-

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<Company>
<Details>
         <type>IT</type>
         <name>Wipro Ltd</name>
         <address>Bangalore</address>
         <country>India</country>
         <Area>Asia Pacific</Area>
     </Details>
</Company>

 */
public class ReadXmlChangeValuesWriteXmlNewFile {

	public static void main(String[] args) {
		
		String filePath="C://TextXML//test.xml";
		File xmlFile=new File(filePath);
		DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder=dbFactory.newDocumentBuilder();
			Document doc= dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList company= doc.getElementsByTagName("Details");
			Element details=null;
			details= (Element) company.item(0);
			//Reading the name Value
			Node name= details.getElementsByTagName("name").item(0).getFirstChild();
			//Printing the name value
			System.out.println(name);
			
			//Changing the name value from Wipro to Wipro Ltd
			name.setNodeValue("Wipro Ltd");
			//Printing the changed value
			System.out.println(name);
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
		    Transformer transformer=transformerFactory.newTransformer();
		    DOMSource source= new DOMSource(doc);
		    //Creating the new file
		    StreamResult result= new StreamResult(new File("C://TextXML//updatedtest.xml"));
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    //Transfering  the updated values to newly created XML file
		    transformer.transform(source, result); 
		    System.out.println("Succesfully Written To Another File");
			
		}
		catch(Exception e) {
		e.printStackTrace();
		
		}

		
	}
}

