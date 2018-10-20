package pl.sda.commons.services;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import pl.sda.DocumentType;
import pl.sda.commons.MockData;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class XmlDocument  {


    public void mockToXml(MockData mockData) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Class<?> aClass = mockData.getClass();

            Field[] fields = aClass.getDeclaredFields();

            org.w3c.dom.Document doc = docBuilder.newDocument();

            Element mockElement = doc.createElement("mockElement");
            int i = 0;
            List<Attr> attr = new ArrayList<Attr>();
            for (Field field : fields) {
                field.setAccessible(true);
                Element element = doc.createElement(field.getName());
                mockElement.appendChild(element);
                System.out.println(field.getName() + ": " + field.get(mockData));
                attr.add(i,doc.createAttribute(field.getName()));
                String s = field.get(mockData).toString();
                attr.get(i).setValue(s);
                element.setAttributeNode(attr.get(i));
                i++;
            }


            doc.appendChild(mockElement);
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Longan\\Documents\\sda_ldz_9\\file.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IllegalAccessException iae) {
        }
    }
}



