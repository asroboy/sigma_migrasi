/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.xml;

import java.util.ArrayList;
import model.metadata.xml.XmlModel;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author wallet
 */
public class XmlReader {
    
     public ArrayList<XmlModel> getModels(NodeList nList, String unsur) {

        return null;
    }
    
   private ArrayList<XmlModel> xmlModels;
    
    public String getNode(Document document,String unsur){
        
           xmlModels = new ArrayList<>();
        
           cetaknodeTest(document.getChildNodes(), 1, "");
            
           //print("MODEL", "" + xmlModels.size());
           
           for (XmlModel model : xmlModels) {
                    
               if(String.valueOf(model.getLevelCode()).equals(unsur.toLowerCase())){
                   
//                        print("TAG ", model.getTag());
//                        print("Value ", model.getValue());
//                        print("LEVEL ", String.valueOf(model.getLevel()));
//                        print("LEVEL CODE", String.valueOf(model.getLevelCode()));
//                        print("PATH",model.getPath());
//                        print("", "====");
                        if(model.getValue()!=null && !model.getValue().isEmpty()){
                              return String.valueOf(model.getValue());
                        }else{
                             //print("Value ", "-");
                             return "-";
                        }
                        //return String.valueOf(model.getValue());
               }
            }
            
        
        return null;
        
    }
    
    public String[] getNodeLoop(Document document,String unsur){
        
           xmlModels = new ArrayList<>();
           String iterator="";
        
           cetaknodeTest(document.getChildNodes(), 1, "");
            
           //print("MODEL", "" + xmlModels.size());
           
           for (XmlModel model : xmlModels) {
                    
               if(String.valueOf(model.getLevelCode()).equals(unsur.toLowerCase())){
                   
//                        print("TAG ", model.getTag());
//                        print("Value ", model.getValue());
//                        print("LEVEL ", String.valueOf(model.getLevel()));
//                        print("LEVEL CODE", String.valueOf(model.getLevelCode()));
//                        print("PATH",model.getPath());
//                        print("", "====");
                        
                        iterator+=String.valueOf(model.getValue())+"^";
               }
            }
            
        
        return StringToArray(iterator);
        
        
    }
    
    public void cetaknodeTest(NodeList nList, int parentCode, String code) {
        
        for (int i = 0; i < nList.getLength(); i++) {
            org.w3c.dom.Node node = nList.item(i);
            XmlModel model = new XmlModel();
            if (!node.getNodeName().equals("#text")) {
                if (!node.getNodeName().equals("#comment")) {
//                    print("LEVEL ", String.valueOf(parentCode));
//                    print("LEVEL CODE ", code);
//                    print("TAG", node.getNodeName());
                    model.setLevel(parentCode);
                    model.setTag(node.getNodeName());
                    boolean isHasAttributes = (node.hasAttributes());
//                    print("isHasAttributes", String.valueOf(isHasAttributes));
                    boolean isHasChild = (node.getChildNodes().getLength() > 0);
                    if (isHasChild && node.getChildNodes().getLength() == 1) {
                        model.setValue(node.getChildNodes().item(0).getTextContent());
//                        print("VALUE", node.getChildNodes().item(0).getTextContent());
                    }
//                    print("is has child", String.valueOf(isHasChild));
//                    print("child Size", String.valueOf(node.getChildNodes().getLength()));
//                    int s = Integer.parseInt(code);
//                    char[] charArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
//                    String t = code;
//                    if (s > 10) {
//                        int v = s - 10;
//                        t = String.valueOf(charArray[v]);
//                    }
                    String child = "";
                    String path="";
                    if (code.equals("")) {
                        child = "" + node.getNodeName().toLowerCase().split(":")[1];
                    } else {
                      //  child = code + "." + node.getNodeName().toLowerCase().split(":")[1];
                        child = code + "." + node.getNodeName().toLowerCase();
                    }

                    model.setLevelCode(child);
                    xmlModels.add(model);
                    if (isHasChild) {
//                        print("======", "CHILD" + " :==========");

                        cetaknodeTest(node.getChildNodes(), parentCode + 1, child);
                    }

//                    print("======", "================");
                }

            }

        }
    }
    
     public static void print(String tag, String message) {
        System.out.println(tag + ": " + message);
    }
     
    public String[] StringToArray(String arrayValue){
        
         String TypeReplace = arrayValue.replace("^", ",");
         String[] type = TypeReplace.split(",");
         
         return type;
    }
}
