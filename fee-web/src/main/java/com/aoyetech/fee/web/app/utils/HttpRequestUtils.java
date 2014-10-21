package com.aoyetech.fee.web.app.utils;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpRequestUtils {
    public static HttpResponse getHttpResponse(String url, Map<String, String> params)
                                                                                      throws Exception {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, 2 * 60 * 100);
        HttpConnectionParams.setSoTimeout(httpParameters, 2 * 60 * 100);
        DefaultHttpClient client = new DefaultHttpClient(httpParameters);
        HttpGet httpGet = new HttpGet(new URI(url));
        for (Map.Entry<String, String> entry : params.entrySet()) {
            httpGet.setHeader(entry.getKey(), entry.getValue());
        }
        return client.execute(httpGet);
    }

    public static HttpURLConnection getUrlConnection(String url, int bufferSize) throws Exception {
        URL target = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) target.openConnection();
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setChunkedStreamingMode(bufferSize);
        conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("contentType", "UTF-8");
        conn.setRequestProperty("timenow", String.valueOf(System.currentTimeMillis()));
        return conn;
    }

}
