/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayHost;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parent Class for all request types
 *
 * @author App Inlet (Pty) Ltd
 *
 * @version 1.0
 * @since 1.0
 */
public class Parent {

    /**
     * Utilties for all requests
     */
    protected Utilities util;
    /**
     * Primary PayHost Object
     */
    protected PayHost payHost;

    Parent(PayHost payHost) {
        this.util = new Utilities();
        this.payHost = payHost;
    }

    /**
     *
     * Retreive util attribute
     *
     * @return utilities attribute of Class Utilities
     */
    public Utilities getUtil() {
        return util;
    }

    /**
     * Set utilities attribute
     *
     * @param util Object of type Utilities
     */
    public void setUtil(Utilities util) {
        this.util = util;
    }

    /**
     * Retreive payHost primary Object attribute
     *
     * @return payHost attribute
     */
    public PayHost getPh() {
        return payHost;
    }

    /**
     * Set payHost primary Object attribute
     *
     * @param payHost Primary Object for all requests
     */
    public void setPh(PayHost payHost) {
        this.payHost = payHost;
    }

    /**
     * Checks if is there any params related error from the server
     *
     * @param strResponse String
     * @return Boolean whether it has params realated error or not
     * @throws ParserConfigurationException Something
     * @throws SAXException Something
     * @throws IOException Something
     */
    public Boolean error(String strResponse) throws ParserConfigurationException, SAXException, IOException {
        return !this.getStatus(strResponse).getProperty("StatusName").equals("Error");
    }

    /**
     * Parse the resposne and get its status as object of Class "MyObject"
     *
     * @param res The response of the post http request
     * @return object of Class "MyObject"
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     */
    public MyObject getStatus(String res) throws ParserConfigurationException, SAXException, IOException {
        Document doc = parseXmlFromString(res);
        NodeList nodeList = doc.getElementsByTagName("ns2:Status");
        System.out.println(nodeList.item(0).getFirstChild().getTextContent());
        MyObject obj = new MyObject();
        System.out.println(nodeList.item(0).getChildNodes().getLength());
        for (int i = 0; i < 5; i++) {
            obj.setProperty(nodeList.item(0).getChildNodes().item(i).getNodeName().replace("ns2:", ""), nodeList.item(0).getChildNodes().item(i).getTextContent());
        }
        /*obj.setProperty(nodeList.item(0).getFirstChild().getNodeName(), nodeList.item(0).getFirstChild().getTextContent());
        obj.setProperty(nodeList.item(0).getChildNodes().item(1).getNodeName(), nodeList.item(0).getChildNodes().item(1).getTextContent());
        obj.setProperty(nodeList.item(0).getChildNodes().item(2).getNodeName(), nodeList.item(0).getChildNodes().item(2).getTextContent());
        obj.setProperty(nodeList.item(0).getChildNodes().item(3).getNodeName(), nodeList.item(0).getChildNodes().item(3).getTextContent());
        obj.setProperty(nodeList.item(0).getChildNodes().item(4).getNodeName(), nodeList.item(0).getChildNodes().item(4).getTextContent());*/
        obj.printProperties();
        return obj;
    }

    /**
     * Parses the response
     *
     * @param xmlString The response of the http post request
     * @return DocumentBuilder object
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     */
    public Document parseXmlFromString(String xmlString) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
        org.w3c.dom.Document document = builder.parse(inputStream);
        return document;
    }

}
