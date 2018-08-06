/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayHost;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Utilities Class for addiotional Operations
 *
 * @author App Inlet (Pty) Ltd
 * @version 1.0
 * @since 1.0
 */
public class Utilities {

    /**
     * Put the Soap Body into a Global Envelope
     *
     * @param soapEnvBody Soap Envelope Body
     * @return Full Soap Message String
     */
    public String envelope(String soapEnvBody) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://www.paygate.co.za/PayHOST\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><SOAP-ENV:Body>" + soapEnvBody + "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
    }

    /**
     * Make an HTTP POST REQUEST
     *
     * @param url Url of the request
     * @param soapAction Action Name
     * @param soapEnvBody Soap Message Body
     * @return Http Post Respsone as String
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     */
    public String callWebService(String url, String soapAction, String soapEnvBody) throws IOException, ParserConfigurationException, SAXException {
        // Create a StringEntity for the SOAP XML.
        String body = envelope(soapEnvBody);
        StringEntity stringEntity = new StringEntity(body, "UTF-8");
        stringEntity.setChunked(true);

        // Request parameters and other properties.
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(stringEntity);
        httpPost.addHeader("Accept", "text/xml");
        httpPost.addHeader("Content-type", "text/xml");
        httpPost.addHeader("SOAPAction", soapAction);

        // Execute and get the response.
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        String strResponse = null;
        if (entity != null) {
            strResponse = EntityUtils.toString(entity);
        }
        /*if (getStatus(strResponse).getProperty("StatusName").equals("Error")) {
            System.out.println("Error : " + getStatus(strResponse).getProperty("ResultDescription"));
        } else {
            System.out.println("No Error");
        }*/
        return strResponse;
    }

    /**
     * Make the http post response pretty with indentation by default : 2
     *
     * @param input SOAP XML String
     * @return String in pretty format
     */
    public static String prettyFormat(String input) {
        return prettyFormat(input, 8);
    }

    /**
     * Make the http post response pretty with indentation
     *
     * @param input Response
     * @param indent Indentation level
     * @return String in pretty format
     */
    public static String prettyFormat(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (IllegalArgumentException | TransformerException e) {
            throw new RuntimeException(e); // simple exception handling, please review it
        }
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
        //System.out.println(nodeList.item(0).getFirstChild().getTextContent());
        MyObject obj = new MyObject();
        //System.out.println(nodeList.item(0).getChildNodes().getLength());
        for (int i = 0; i < 5; i++) {
            obj.setProperty(nodeList.item(0).getChildNodes().item(i).getNodeName().replace("ns2:", ""), nodeList.item(0).getChildNodes().item(i).getTextContent());
        }
        //obj.printProperties();
        return obj;
    }
}
