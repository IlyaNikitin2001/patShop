import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by USER on 09.03.2017.
 */
public class DogWriterExample {
    public static void main(String[] args) throws Exception {
//        фабрика
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        строитель
        DocumentBuilder builder = factory.newDocumentBuilder();
//        создание документа
        Document document = builder.parse(new FileInputStream(new File("petShop.xml")));
//        елемент
        document.getDocumentElement().normalize();
        Element element= document.getDocumentElement();
//        вывод корневого элемента
        System.out.println(element.getNodeName());
//        создаем новый узел
        Element dog = document.createElement("dog");
//        dog.appendChild(document.createTextNode("dog"));
        Element name = document.createElement("name");
        name.appendChild(document.createTextNode("Bob"));
        dog.appendChild(name);
        Element weight = document.createElement("weight");
        weight.appendChild(document.createTextNode("10"));
        dog.appendChild(weight);
        Element poroda = document.createElement("poroda");
        poroda.appendChild(document.createTextNode("Mops"));
        dog.appendChild(poroda);
//        добавляем дочерний узел
        element.appendChild(dog);
        document.getDocumentElement().normalize();
//        addElement(document);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.transform(new DOMSource(document),
                new StreamResult(new File("petShop.xml")));

    }
    public static final void prettyPrint(Document xml) throws Exception {
//        создаем трансформер который будет изменять текст
        Transformer tf = TransformerFactory.newInstance().newTransformer();
//        задаем настройки дя трансформера
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
//        трасформация завершена
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());

    }
    private static void addElement(Document doc) {

//  список узлов с именем dog
        NodeList dog = doc.getElementsByTagName("dog");
//        создаем элемент
        Element d = null;

        //loop for each employee
        for(int i=0; i<dog.getLength();i++){
//            инициализируем d
            d = (Element) dog.item(i);
//            создаем элемент с именем name и придаем
            Element name = doc.createElement("name");
//            создаем запись внутри тега
            name.appendChild(doc.createTextNode("Bob"));
//            добавляем имя внутрь элемента d
            d.appendChild(name);
        }
}
}
