package br.com.invistaja.invistaja.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

public class ConexaoHttp {
    public JSONObject post(String url, JSONObject obj)throws IOException, JSONException {
        try {
            HttpContext context = new BasicHttpContext();
            HttpParams params = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(params, 50000);
            HttpClient client = new DefaultHttpClient(params);
            HttpPost post = new HttpPost(url);
            post.setHeader("Content-type", "application/json");
            post.setEntity(new StringEntity(obj.toString()));
            HttpResponse response = client.execute(post, context);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            String resultString = convertStreamToString(stream);
            JSONObject json = new JSONObject(resultString);
            stream.close();
            return json;
        }catch(Exception ex){
            throw ex;
        }
    }

    private String convertStreamToString(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sBuilder = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
        }
        return sBuilder.toString();
    }
}
