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
 * Created by USER on 10.03.2017.
 */
public class DogsExample {
    public static class DogExamplexml {
        public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
            Dog dog = new Dog("Tomas",12,"Mops");
            Dog dog1 = new Dog("Sharik",10,"Taksa");
            Dog dog2 = new Dog("Bobik",16,"Chau-chau");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("petShop.xml");
            Element dog4 = document.createElement("dog");
            Element element= document.getDocumentElement();
            dog.setName(element.getElementsByTagName("name").item(0).getTextContent());
            System.out.println(dog.getName());

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(document),
                    new StreamResult(new File("petShop.xml")));
        }
    }

}
