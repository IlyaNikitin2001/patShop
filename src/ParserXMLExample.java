import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by USER on 06.03.2017.
 */
public class ParserXMLExample {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("petShop.xml");
        Node root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList list = document.getElementsByTagName("dog");
        for(int i = 0 ; i<list.getLength() ; i++){
            Element element = (Element) list.item(i);
            System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
            System.out.println(element.getElementsByTagName("weight").item(0).getTextContent());
            System.out.println(element.getElementsByTagName("poroda").item(0).getTextContent());
                }
        System.out.println(":!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        присваеваем элементу значение из нулевого объкта списка
                Element element1 = (Element) list.item(0);
        Dog dog = new Dog();
//        просим дать нам текстовое содержимое из тега с именем name
        dog.setName(element1.getElementsByTagName("name").item(0).getTextContent());
        System.out.println(dog.getName());
        Dog dog1 = new Dog();
//        просим дать текстовое содержимое с именем weight
       String s = element1.getElementsByTagName("weight").item(0).getTextContent();
//       создание переменной которая принимает вес
       int n= Integer.parseInt(s);
//       задаем вес
       dog1.setWeight(n);
//       выводим вес
        System.out.println(dog1.getWeight());
//        просим дать текстовое содержимое из тега
        dog.setPoroda(element1.getElementsByTagName("poroda").item(0).getTextContent());
//        вывод породы
        System.out.println(dog.getPoroda());

        Element element2 = (Element) list.item(1);
        Dog dog2 = new Dog();
        dog2.setName(element2.getElementsByTagName("name").item(0).getTextContent());
        System.out.println(dog2.getName());
        Dog dog3 = new Dog();
        String b = element2.getElementsByTagName("weight").item(0).getTextContent();
        int i= Integer.parseInt(b);
        dog3.setWeight(i);
        System.out.println(dog3.getWeight());
        dog3.setPoroda(element2.getElementsByTagName("poroda").item(0).getTextContent());
        System.out.println(dog3.getPoroda());
    }

 }