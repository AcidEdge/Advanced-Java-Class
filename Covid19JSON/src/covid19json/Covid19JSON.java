
package covid19json;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Covid19JSON {

    
    public static void main(String[] args) {
        try {
            
            //setup url and connection, and connect to url
            URL url = new URL("https://api.covid19api.com/summary");
            
            HttpURLConnection conn =(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            //get reponse code, if code is 200, it will work, if not throw exception error
            int responsecode = conn.getResponseCode();
            
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode Error: " + responsecode);
            } else { //if response code is 200:
                //scanner will convert JSON recieved data into a string
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                
                scanner.close();
                
                //parse the string into a JSON Object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);
                
                //get the required object drom the about created object
                JSONObject obj = (JSONObject) data_obj.get("Global");
                
                //get required data using its key
                System.out.println(obj.get("TotalRecovered"));
                
                //create JSON Array with countries as the key
                JSONArray arr = (JSONArray) data_obj.get("Countries");
                
                for (int i = 0; i < arr.size(); i++){
                    JSONObject new_obj = (JSONObject) arr.get(i);
                    
                    if (new_obj.get("Slug").equals("albania")){
                        System.out.println("Total Recovered: " + new_obj.get("TotalRecovered"));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
