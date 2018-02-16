package kagoyume;

import java.io.InputStream;
import org.w3c.dom.Node;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;


import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.HashMap;



public class xmlReader {
    public static ArrayList getXMLFromHttp(Boolean search,String query) throws  Exception{
        HttpURLConnection connection = null;
        ArrayList<HashMap> Items = new ArrayList<HashMap>();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//xml読む準備
            DocumentBuilder db = dbf.newDocumentBuilder();
            String newURL = "";
            if(search){
                newURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch?appid=dj00aiZpPURLSklxcnZZRXltbSZzPWNvbnN1bWVyc2VjcmV0Jng9NDA-&query="+query;
            }else{
                newURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemLookup?appid=dj00aiZpPURLSklxcnZZRXltbSZzPWNvbnN1bWVyc2VjcmV0Jng9NDA-&itemcode="+query;
            }
            Document doc = db.parse(new URL(newURL).openStream());
            NodeList nodelist=doc.getElementsByTagName("Hit");
            loop: for(int k=0 ; k<nodelist.getLength();k++){
                NodeList gchildren = nodelist.item(k).getChildNodes();
                HashMap<String, String> Item =new HashMap<String, String>();
                for(int  x = 0; x<gchildren.getLength();x++){
                    Node one_of_hit_children=gchildren.item(x);
                    if(one_of_hit_children.getNodeName().equals("Name")){
                        Item.put("Name", one_of_hit_children.getTextContent());
                    }
                    if (one_of_hit_children.getNodeName().equals("Image")){//Imageタグ内からIDとmediumのURLを取得
                            Node IDNode = one_of_hit_children.getFirstChild();
                            Node ImageNode = one_of_hit_children.getFirstChild().getNextSibling();
                            Item.put("ID", IDNode.getTextContent());
                            if (ImageNode.getNextSibling()==null){//smallがあるかどうかの判定
                                Item.put("Image", ImageNode.getTextContent());
                            }else{
                                Item.put("Image", ImageNode.getNextSibling().getTextContent());
                            }
                        }
                    if (one_of_hit_children.getNodeName().equals("Price")){//Priceタグ内から価格を取得
                            Item.put("Price", one_of_hit_children.getTextContent());
                            Items.add(Item);
                        }                    
                }                
            }
        String foo;    
            foo = "bar";
        }catch(Exception e){
            throw e;            
        }finally{
            if (connection != null) {
                connection.disconnect();
            }
        }
        return Items;
    }
    public static ArrayList getXMLFromHttpByItemID() throws  Exception{
        HttpURLConnection connection = null;
        ArrayList<HashMap> Items = new ArrayList<HashMap>();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//xml読む準備
            DocumentBuilder db = dbf.newDocumentBuilder();
            String newURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemLookup?appid=dj00aiZpPURLSklxcnZZRXltbSZzPWNvbnN1bWVyc2VjcmV0Jng9NDA-&itemcode=mtgec_9591301431";
            Document doc = db.parse(new URL(newURL).openStream());
            NodeList nodelist=doc.getElementsByTagName("Hit");
            loop: for(int k=0 ; k<nodelist.getLength();k++){
                NodeList gchildren = nodelist.item(k).getChildNodes();
                HashMap<String, String> Item =new HashMap<String, String>();
                for(int  x = 0; x<gchildren.getLength();x++){
                    Node one_of_hit_children=gchildren.item(x);
                    if(one_of_hit_children.getNodeName().equals("Name")){
                       //Item.remove("Name");
                        Item.put("Name", one_of_hit_children.getTextContent());
                        
                    }
                    if (one_of_hit_children.getNodeName().equals("Image")){//Imageタグ内からIDとmediumのURLを取得
                            Node IDNode = one_of_hit_children.getFirstChild();
                            Node ImageNode = one_of_hit_children.getFirstChild().getNextSibling();
                            Item.put("ID", IDNode.getTextContent());
                            if (ImageNode.getNextSibling()==null){//smallがあるかどうかの判定
                                Item.put("Image", ImageNode.getTextContent());
                            }else{
                                Item.put("Image", ImageNode.getNextSibling().getTextContent());
                            }
                        }
                    if (one_of_hit_children.getNodeName().equals("Price")){//Priceタグ内から価格を取得
                            Item.put("Price", one_of_hit_children.getTextContent());
                            Items.add(Item);
                        }                    
                }                
            }
            
        }catch(Exception e){
            throw e;            
        }finally{
            if (connection != null) {
                connection.disconnect();
            }
        }
        return Items;
    }

   
}