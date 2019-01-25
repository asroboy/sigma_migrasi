/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ridho
 */
public class TestXml {

    private static Document document;
    private static String fileIdentifier = "RBI100019992000DAERAHMANA";
    private static String title = "RBI 1:1000 DAERAH MANA";
    private static String fileIdentifierList = "FILEIDENTIFIER1, FILEIDENTIFIER2";
//    private static String SQL = "SELECT * FROM MD_METADATA WHERE FILEIDENTIFIER = \'RBI500020131209BANDUNGUTARA_11\'";
//    private static String SQL_TABLE = "select column_id as id, COLUMN_NAME as name, data_type as dataType, char_length as dataLength from USER_TAB_COLUMNS where TABLE_NAME= \'MD_METADATA\'";
//    private static HashMap<String, MdData> data;

    public static void main(String[] a) {
        try {
            String path = "C:/migrasi/metadata-xml/template/";
            String pathTarget = "C:/migrasi/metadata-xml/publikasi/";
            String templateFileName = "template-iso19115";
            File templateXmlFile = new File(path + templateFileName + ".xml");
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            document = docBuilder.parse(templateXmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                //MD_Metadata NODE index 0 ==> root
                Node node = nodeList.item(i);
                extractNode(node, 1);
            }

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult sr = new StreamResult(new File(pathTarget + templateFileName + "-target" + ".xml"));
            tf.transform(domSource, sr);

//            SigmaXmlWriter xmlWriter = new SigmaXmlWriter();
//            xmlWriter.saveToXML("C:/migrasi/metadata-xml/test/test.xml");
//            System.out.print("Halo");
            System.exit(0);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void extractNode(Node node, int parentCode) {
        NodeList childs = getNodeChilds(node);
        String name = node.getNodeName();
        name = name.replace("gmd:", "").toUpperCase();
        if (!name.equalsIgnoreCase("#text")) {
            String empty_ = " ";
            for (int z = 0; z < parentCode; z++) {
                empty_ = empty_ + empty_;
            }
//            System.out.println(name);
            if (node.getParentNode().getNodeName().equals("gmd:fileIdentifier")) {
                if (node.getNodeName().equalsIgnoreCase("gco:CharacterString")) {
                    System.out.println("WRITING .. " + fileIdentifier);
                    node.setTextContent(fileIdentifier);
                }
            }

            if (node.getParentNode().getNodeName().equals("gmd:title")) {
                Node parent2 = node.getParentNode().getParentNode();
                System.out.println("HALO.." + parent2.getNodeName());
                if (parent2.getNodeName().equals("gmd:CI_Citation")) {

                    Node parent3 = parent2.getParentNode();
                    if (parent3.getNodeName().equals("gmd:citation")) {
                        Node parent4 = parent3.getParentNode();
                        if (parent4.getNodeName().equals("gmd:MD_DataIdentification")) {
                            Node parent5 = parent4.getParentNode();
                            if (parent5.getNodeName().equals("gmd:identificationInfo")) {
                                if (node.getNodeName().equalsIgnoreCase("gco:CharacterString")) {
                                    System.out.println("WRITING .. " + title);
                                    node.setTextContent(title);
                                }
                            }
                        }
                    }
                }
            }

            if (node.getParentNode().getNodeName().equals("gmd:abstract")) {
                Node parent4 = node.getParentNode().getParentNode();
                if (parent4.getNodeName().equals("gmd:MD_DataIdentification")) {
                    Node parent5 = parent4.getParentNode();
                    if (parent5.getNodeName().equals("gmd:identificationInfo")) {
                        if (node.getNodeName().equalsIgnoreCase("gco:CharacterString")) {
                            System.out.println("WRITING .. " + fileIdentifierList);
                            node.setTextContent(fileIdentifierList);
                        }
                    }
                }
            }

//            System.out.println(empty_ + name);
            if (childs.getLength() > 0) {
                extractNodeList(childs, parentCode);
            }
        }

    }

    private static void extractNodeList(NodeList nodeList, int parentCode) {
        int in = parentCode + 1;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
//            if (node.getParentNode().getNodeName().equals("gmd:MD_Metadata") || node.getParentNode().getNodeName().equals("fileIdentifier")) {
            extractNode(node, in);
//            }

        }
    }

    private static NodeList getNodeChilds(Node node) {
        return node.getChildNodes();
    }

    public static Connection getConnection() throws IOException {
        String driverName = "oracle.jdbc.OracleDriver";
        String url = "";

        url = "jdbc:oracle:thin:@//virtua.co/id:1522/igsver2";

        String username = "METADATA";
        String password = "METADATA";
        try {
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;

        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    url, username, password
            );
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }

        if (connection == null) {
            System.out.println("Koneksi null");
        }

        return connection;
    }

    private static File copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }

        return dest;
    }
}
