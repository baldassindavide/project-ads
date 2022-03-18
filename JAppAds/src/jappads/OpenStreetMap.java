/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jappads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author baldassin_davide
 */
public class OpenStreetMap {

    public OpenStreetMap() {

    }

    public List<JTown> getPaese(URL url) throws IOException, ParserConfigurationException, SAXException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String singleLineOSM, XAMLtext = "";
        do {
            singleLineOSM = in.readLine();
            if (singleLineOSM != null) {
                XAMLtext += singleLineOSM;
            }
        } while (singleLineOSM != null);

        //System.out.println(XAMLext);
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodeList;

        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(url.openStream());
        root = document.getDocumentElement(); // gets the first element
        nodeList = root.getElementsByTagName("place");
        
        List listTown = new ArrayList<JTown>();
        for(int i = 0; i < nodeList.getLength(); i++){
            listTown.add(nodeToTown(nodeList.item(i)));
        }
        
        return listTown;
    }
    
    public JTown nodeToTown(Node node){
        JTown t = new JTown(node);
        return t;
    }
}
