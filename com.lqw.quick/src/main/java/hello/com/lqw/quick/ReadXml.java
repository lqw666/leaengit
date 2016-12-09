package hello.com.lqw.quick;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXml {

	public static void main(String[] args) {
		
		//paseXml();
		
		try {
			DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder=builderFactory.newDocumentBuilder();
			Document document=documentBuilder.newDocument();
			
			Element root=document.createElement("book");
			root.setAttribute("title", "math");
			
			Element author1=document.createElement("author");
			author1.setAttribute("id", "1");
			Element name1=document.createElement("name");
			name1.setTextContent("lqw");
			Element phone1=document.createElement("phone");
			phone1.setTextContent("123");
			author1.appendChild(name1);
			author1.appendChild(phone1);
			
			Element author12=document.createElement("author");
			author12.setAttribute("id", "2");
			Element name12=document.createElement("name");
			name12.setTextContent("lqw");
			Element phone12=document.createElement("phone");
			phone1.setTextContent("456");
			author12.appendChild(name12);
			author12.appendChild(phone12);
			
			root.appendChild(author1);
			root.appendChild(author12);
			document.appendChild(root);
			
			TransformerFactory factory=TransformerFactory.newInstance();
			Transformer transformer=factory.newTransformer();
			StringWriter stringWriter=new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
			
			System.out.println(stringWriter.toString());
			
			transformer.transform(new DOMSource(document), new StreamResult(new File("createxml.xml")));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void paseXml() {
		try {
			DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=builderFactory.newDocumentBuilder();
			Document document=builder.parse(new File("NewFile.xml"));
			Element root =document.getDocumentElement();
			System.out.println("title="+root.getAttribute("title"));
			NodeList author=root.getElementsByTagName("author");
			for(int j=0;j<author.getLength();j++){
				Element au=(Element) author.item(j);
				System.out.println("---------------------");
				System.out.println("id="+au.getAttribute("id"));
				NodeList clist=au.getChildNodes();
				for(int i=0;i<clist.getLength();i++){
					if(clist.item(i) instanceof Element){
						Node c=clist.item(i);
						System.out.println(c.getNodeName()+"="+c.getTextContent());
						
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
