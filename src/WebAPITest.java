import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONException;
import org.json.JSONObject;

public class WebAPITest {
    static String checkurl = "http://localhost:1456/api/Values/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // checkurl replace with your JSON URL
        String checkurl = "http://localhost:5291/api/values/5";
        try
        {
            URL connectto = new URL(checkurl);
            HttpURLConnection conn = (HttpURLConnection) connectto.openConnection();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            
            String line;
            String output = null;
            while ((line = br.readLine()) != null) {
            	output = line.replace("[", "").replace("]", "");
            	
                sb.append(line+"\n");
            }
            
            br.close();
            //JSONObject jsonObj = new JSONObject(output.toString());
            
            System.out.println(output);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
