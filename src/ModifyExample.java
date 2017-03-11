import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by USER on 10.03.2017.
 */
public class ModifyExample {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("petShop.xml");
        Dog dog = new Dog("Tom",18,"dalmatinets");
        insertElement(document,dog);
//        addElement(document);
//changeElement(document);
//        deleteElement(document);
//        readElement(document);
//        readElement(document);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.transform(new DOMSource(document),
                new StreamResult(new File("petShop.xml")));

    }

    public static void addElement(Document document) {
        NodeList dog = document.getElementsByTagName("dog");
        Element element = null;
        for (int i = 0; i < dog.getLength(); i++) {
            element = (Element) dog.item(i);
            Element privifka = document.createElement("privifka");
            privifka.appendChild(document.createTextNode("От бешенства"));
            element.appendChild(privifka);
        }
    }

    public static void changeElement(Document document) {
        NodeList dog = document.getElementsByTagName("dog");
        Element element = null;
        for (int i = 0; i < dog.getLength(); i++) {
            element = (Element) dog.item(i);
            Node weight = element.getElementsByTagName("weight").item(0).getFirstChild();
            weight.setNodeValue("15");

        }

    }

    public static void deleteElement(Document document) {
        NodeList dog = document.getElementsByTagName("dog");
        Element element = null;
        for (int i = 0; i < dog.getLength(); i++) {
            element = (Element) dog.item(i);
            Node privifka = element.getElementsByTagName("privifka").item(0).getFirstChild();
            element.removeChild(privifka);
        }
    }

    public static void readElement(Document document) {
        NodeList dog = document.getElementsByTagName("dog");
        Element element = null;
        for (int i = 0; i < dog.getLength(); i++) {
            element = (Element) dog.item(i);
            System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
        }
    }

    public static void insertElement(Document document,Dog dog) {
//        нормализация корневого элемента
        document.getDocumentElement().normalize();
//        доступ к корневому элементу
        Element element= document.getDocumentElement();
//        создание корневого элемента dog
        Element dogElement = document.createElement("dog");
//        cоздаем внутренний элемент name
        Element name= document.createElement("name");
        name.appendChild(document.createTextNode(dog.getName()));
        dogElement.appendChild(name);
        Element weigt = document.createElement("weight");
        weigt.appendChild(document.createTextNode(String.valueOf(dog.getWeight())));
        dogElement.appendChild(weigt);
        Element poroda = document.createElement("poroda");
        poroda.appendChild(document.createTextNode(dog.getPoroda()));
        dogElement.appendChild(poroda);
//        добавили в корневой элемент
        element.appendChild(dogElement);
    }

    }
