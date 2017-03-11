import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by USER on 09.03.2017.
 */
public class DogExamplexml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Dog dog = new Dog("Tomas",12,"Mops");
        Dog dog1 = new Dog("Sharik",10,"Taksa");
        Dog dog2 = new Dog("Bobik",16,"Chau-chau");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("petShop.xml");
        document.getDocumentElement().normalize();
        Element element= document.getDocumentElement();

        Element dog3 = document.createElement("dog");

        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(dog.getName()));
        dog3.appendChild(name);

        Element weight = document.createElement("weight");
        weight.appendChild(document.createTextNode(String.valueOf(dog.getWeight())));
        dog3.appendChild(weight);

        Element poroda = document.createElement("poroda");
        poroda.appendChild(document.createTextNode(dog.getPoroda()));
        dog3.appendChild(poroda);


        Element dog4 = document.createElement("dog");
        Element name1 = document.createElement("name");
        name1.appendChild(document.createTextNode(dog1.getName()));
        dog4.appendChild(name1);

        Element weight1 = document.createElement("weight");
        weight1.appendChild(document.createTextNode(String.valueOf(dog1.getWeight())));
        dog4.appendChild(weight1);
        Element poroda1 = document.createElement("poroda");
        poroda1.appendChild(document.createTextNode(dog1.getPoroda()));
        dog4.appendChild(poroda1);


        Element dog5 = document.createElement("dog");
        Element name2 = document.createElement("name");
        name2.appendChild(document.createTextNode(dog2.getName()));
        dog5.appendChild(name2);

        Element weight2 = document.createElement("weight");
        weight2.appendChild(document.createTextNode(String.valueOf(dog2.getWeight())));
        dog5.appendChild(weight2);
        Element poroda2 = document.createElement("poroda");
        poroda2.appendChild(document.createTextNode(dog2.getPoroda()));
        dog5.appendChild(poroda2);

        element.appendChild(dog3);
        element.appendChild(dog4);
        element.appendChild(dog5);




        document.getDocumentElement().normalize();

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.transform(new DOMSource(document),
                new StreamResult(new File("petShop.xml")));
    }
}
