package kagoyume;


import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class sampleHandler extends DefaultHandler {


    public void startDocument() {
        System.out.println("startDocument");
    }

    public void endDocument() {
        System.out.println("endDocument");
    }

    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts) {

        System.out.println("startElement: " + qName);
    }

    public void endElement(String namespaceURI,
                           String localName,
                           String qName) {

        System.out.println("endElement: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.print("characters: ");
        for (int i = 0; i < length; i++) {
            System.out.print(ch[start + i]);
        }
        System.out.println();
    }
}