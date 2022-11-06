package Java_lab24;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Homework {
    public static void main(String[] args) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("test.xml"));
        Element root = doc.getDocumentElement();
        NodeList nl = root.getElementsByTagName("PLANT");
        int sum = 0;
        for (int i = 0; i < nl.getLength(); ++i)
        {
            Element plant = (Element) nl.item(i);
            sum += Integer.parseInt(String.valueOf(plant.getAttribute("plantid")));
        }
        System.out.println(sum);
    }
}
