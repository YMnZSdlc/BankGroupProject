package pl.sda.commons.services;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pl.sda.commons.strategy.Convertable;
import pl.sda.commons.tools.PathToFile;

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

import static jxl.biff.BaseCellFeatures.logger;

public class XmlDocument implements Convertable {

    private static final String PATH = PathToFile.getPath();
    @Override
    public boolean convert(Object object) {
        boolean resultBoolean = false;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Class<?> aClass = object.getClass();
            Field[] fields = aClass.getDeclaredFields();
            Document doc = docBuilder.newDocument();
            Element mockElement = doc.createElement("mockElement");
            int i = 0;
            List<Attr> attr = new ArrayList<>();
            for (Field field : fields) {
                field.setAccessible(true);
                Element element = doc.createElement(field.getName());
                mockElement.appendChild(element);
                logger.info(field.getName() + ": " + field.get(object));
                attr.add(i, doc.createAttribute(field.getName()));
                String s = field.get(object).toString();
                attr.get(i).setValue(s);
                element.setAttributeNode(attr.get(i));
                i++;
            }
            writeIntoXmlFile(doc, mockElement);
            resultBoolean = true;
        } catch (ParserConfigurationException | TransformerException | IllegalAccessException ex) {
            logger.error("Ops!", ex);
        }
        return resultBoolean;
    }
    private void writeIntoXmlFile(Document doc, Element mockElement) throws TransformerException {
        doc.appendChild(mockElement);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(PATH));
        transformer.transform(source, result);
    }
}