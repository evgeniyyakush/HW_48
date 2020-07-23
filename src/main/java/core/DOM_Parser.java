
//after getting the result we can just compare it with expected result in AllureReport or ExtendReports
//I will be given XML element and what they should be equal to...
//DOM - it's document object model


//API testing it's all about what should I grab and what should it be equal to...
package core;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOM_Parser {

	public static void main(String[] args) throws Exception {

		String url = "http://alex.academy/ebay.xml";

		String node = "kadu-response";

		String element_01 = "orig-kw";
		String element_02 = "engine";
		String element_03 = "kadu-version";
		String element_04 = "response-time";
		String element_05 = "deals";
		String attribute_01 = "count";

		// Get the DOM Builder Factory
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder b = f.newDocumentBuilder();

		// Load and Parse the XML document contains the complete XML as a Tree.
		Document doc = b.parse(url);

		// Optional
		//We do method "normalize" in case if XML will come broken and shapeless, it will put it into normal order(it will fix it)
		doc.getDocumentElement().normalize();

		// Parsing elements
		//"item(0)" here we take the first Element;                   //we could put "orig-kw" instead of "element_01"
		System.out.println("Key Word: \t " + ((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_01).item(0).getChildNodes().item(0).getNodeValue());
		System.out.println("Engine: \t " + ((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_02).item(0).getChildNodes().item(0).getNodeValue());
		System.out.println("Version: \t " + ((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_03).item(0).getChildNodes().item(0).getNodeValue());
		//System.out.println("Lang ID: \t " + ((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName("lang_id").item(0).getChildNodes().item(0).getNodeValue());
		System.out.println("Response time: \t " + ((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_04).item(0).getChildNodes().item(0).getNodeValue());
		
		
		//or can be like this
		//if(true) {System.out.println("Language is English");}
		
		//if("ok".equals("ok")) {System.out.println("Language is English");}
		//or
		//IT'S REAL TESTING
		//Report
		// "1" it's English 
		if (((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName("orig-kw").item(0).getChildNodes().item(0).getNodeValue().equals("sony")) {
			System.out.println("Report: Search keyword is sony");}
		else {System.out.println("Report: Search keyword is NOT sony");}
			
		// Parsing attribute
		System.out.println("Number of deals: " + ((Element) doc.getElementsByTagName(element_05).item(0)).getAttribute(attribute_01).trim());
	}
}