package HttpClient_study.HttpClient_1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sunfch
 * @create 2018-04-27 9:10
 * @desc httpclient_get请求学习
 **/
public class Httpclient_get {

    public String get(String url) {

        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            result = entityToString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    private String entityToString(HttpEntity entity) throws IOException {
        String result = null;
        if (entity != null) {
            long lenth = entity.getContentLength();
            if (lenth != -1 && lenth < 2048) {
                result = EntityUtils.toString(entity, "UTF-8");
            } else {
                InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
                CharArrayBuffer buffer = new CharArrayBuffer(2048);
                char[] tmp = new char[1024];
                int l;
                while ((l = reader1.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }
                result = buffer.toString();
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        System.out.println("Httpclient 学习。。。。。");
//        Httpclient_get httpclient_get = new Httpclient_get();
//        String result = httpclient_get.get("https://www.cnblogs.com/xiaosiyuan/p/6726668.html");
//        System.out.println("输出结果是：>>>>>" + result);



        String test="{\"100102012_298\":\"100102013_302&100102017_280\",\"100102006_18\":\"100102017_280\"}";

        JSONObject jsonObject = JSONObject.parseObject(test);

       String str = jsonObject.getString("100102012_298");

        System.out.println(str);


        String[] split = str.split("&");

        for (String st:split){
            System.out.println(st);
        }
    }
}
