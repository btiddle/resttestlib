package com.btiddle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TestFramework extends ResponseObj {

    public static boolean DEBUG = true;
    public static String BASE_URL = "https://example.com";


    public static String getQueryString(String[][] keyValuePairs) throws Exception {

        // TODO: url encode all parameters
        // Construct key value pair parameters
        String parameters = "?";
        int count = 0;
        for (String[] keyValuePair : keyValuePairs) {
            if (count > 0) parameters += "&";
            parameters += keyValuePair[0] + "=";
            if (keyValuePair[0].toLowerCase() != "term")
                parameters += keyValuePair[1];
            else
                parameters += URLEncoder.encode(keyValuePair[1], "UTF-8");
            count++;
        }
        return (parameters);
    }

    public static ResponseObj httpGet(String url) throws IOException {

        // Create object to be returned by method
        ResponseObj responseObj = new ResponseObj();

        // Create http client
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        // Send request
        HttpGet request = new HttpGet(url);

        // Get response
        CloseableHttpResponse response = httpclient.execute(request);

        try {

            // Get status code
            responseObj.statusCode = response.getStatusLine().getStatusCode();

            if (DEBUG) {
                // Status Line
                System.out.println("Status Line:                  " + responseObj.statusCode);
            }

            // Get context
            HttpEntity entity = response.getEntity();
            //String responseContent = entity.getContent().toString();
            //JSONObject jsonObject = new JSONObject(responseContent);

            // Entity Content Body - Version #2
            InputStream in = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            if (DEBUG) {
                boolean status = reader.ready();
                System.out.println("reader.ready():               " + status);
            }

            // Get body
            String responseBody = "";
            String line = reader.readLine();
            while (line != null) {
                responseBody += line;
                line = reader.readLine();
            }

            // TODO: If content type is json, then convert to json
            if (responseObj.statusCode == 200)
                responseObj.body = new JSONObject(responseBody);

            if (DEBUG) {
                System.out.println(responseBody);
            }

            // Consume entity
            EntityUtils.consume(entity);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            response.close();
        }

        return (responseObj);
    }

    public static ResponseObj httpGetBasicAuth(String uri, String username, String password) throws IOException {

        // Create object to be returned by method
        ResponseObj responseObj = new ResponseObj();

        String header = "Basic ";
        String headerValue = username + ":" + password;
        String encodedHeaderValue = Base64.encodeBase64String(headerValue.getBytes());
        String headerBasic =  header + encodedHeaderValue;

        Header authHeader = new BasicHeader("Authorization", headerBasic);
        ArrayList<Header> headers = new ArrayList<Header>();
        headers.add(authHeader);

        HttpClient client = HttpClients.custom().setDefaultHeaders(headers).build();

        HttpUriRequest request = RequestBuilder.get().setUri(uri).build();
        HttpResponse response = client.execute(request);

        int responseCode = response.getStatusLine().getStatusCode();

        try {

            // Get status code
            responseObj.statusCode = response.getStatusLine().getStatusCode();

            if (DEBUG) {
                // Status Line
                System.out.println("Status Line:                  " + responseObj.statusCode);
            }

            // Get context
            HttpEntity entity = response.getEntity();
            //String responseContent = entity.getContent().toString();
            //JSONObject jsonObject = new JSONObject(responseContent);

            // Entity Content Body - Version #2
            InputStream in = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            if (DEBUG) {
                boolean status = reader.ready();
                System.out.println("reader.ready():               " + status);
            }

            // Get body
            String responseBody = "";
            String line = reader.readLine();
            while (line != null) {
                responseBody += line;
                line = reader.readLine();
            }

            // TODO: If content type is json, then convert to json
            if (responseObj.statusCode == 200)
                responseObj.body = new JSONObject(responseBody);

            if (DEBUG) {
                System.out.println(responseBody);
            }

            // Consume entity
            EntityUtils.consume(entity);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            //response.close();
        }

        return (responseObj);
    }


    public static ResponseObj httpGetBasicAuth2(String uri, String username, String password) throws IOException {

        // Create object to be returned by method
        ResponseObj responseObj = new ResponseObj();

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        //uri = uri.substring(7);

        HttpHost targetHost = new HttpHost(uri, 80, "http");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                new UsernamePasswordCredentials(username, password));




        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);

        // Add AuthCache to the execution context
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);

        HttpGet httpget = new HttpGet(uri);
        for (int i = 0; i < 3; i++) {
            CloseableHttpResponse response = httpclient.execute(
                    targetHost, httpget, context);
            try {
                HttpEntity entity = response.getEntity();
                responseObj.statusCode = response.getStatusLine().getStatusCode();

            } finally {
                response.close();
            }
        }


        return (responseObj);

    }


    public static ResponseObj httpPost(String baseURL, String[][] parameters) throws IOException {

        // Create object to be returned by method
        ResponseObj responseObj = new ResponseObj();

        // Create http client
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        // Declare request with baseURL
        HttpPost request = new HttpPost(baseURL);

        // Add name value pairs to request
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        for (String params[] : parameters) {
            nameValuePairs.add(new BasicNameValuePair(params[0], params[1]));
            request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        }

        // Get response
        CloseableHttpResponse response = httpclient.execute(request);

        try {


            // Get status code
            responseObj.statusCode = response.getStatusLine().getStatusCode();

            if (DEBUG) {
                // Status Line
                System.out.println("Status Line:                  " + responseObj.statusCode);
            }

            // Get context
            HttpEntity entity = response.getEntity();
            //String responseContent = entity.getContent().toString();
            //JSONObject jsonObject = new JSONObject(responseContent);

            // Entity Content Body - Version #2
            InputStream in = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            if (DEBUG) {
                boolean status = reader.ready();
                System.out.println("reader.ready():               " + status);
            }

            // Get body
            String responseBody = "";
            String line = reader.readLine();
            while (line != null) {
                responseBody += line;
                line = reader.readLine();
            }

            // TODO: If content type is json, then convert to json.
//            if (responseObj.statusCode == 200)
//                responseObj.body = new JSONObject(responseBody);

            if (DEBUG) {
                System.out.println(responseBody);
            }

            // Consume entity
            EntityUtils.consume(entity);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            response.close();
        }

        return (responseObj);
    }

}
