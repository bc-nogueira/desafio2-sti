import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Connection {
    private final String USER_AGENT = "Mozilla/5.0";
    
    public void sendGet() throws Exception {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("nominatim.openstreetmap.org/")
                .setPath("/search")
                .setParameter("street", "Rua Doutor Nilo Peçanha")
                .setParameter("city", "Niterói")
                .setParameter("format", "json")
                .setParameter("addressdetails", "1")
                .build();
        
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(uri);

        request.addHeader("User-Agent", USER_AGENT);
        
        HttpResponse response = client.execute(request);
        
        String json = EntityUtils.toString(response.getEntity(), "UTF-8");
        JSONArray jsonArray = new JSONArray(json);
        
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            
            String lat = obj.getString("lat");
            System.out.println(i + ": " + lat);
            String lon = obj.getString("lon");
            System.out.println(i + ": " + lon);
        }
    }
}
