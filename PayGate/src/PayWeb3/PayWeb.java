/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayWeb3;

import java.io.IOException;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import PayHost.MyObject;

/**
 * PayWeb primary Object
 *
 * @author App Inlet (Pty) Ltd
 * @see <a href="https://qa.paygate.co.za/api/?java">PayWeb3</a>
 * @version 1.0
 * @since 1.0
 */
public class PayWeb {

    /**
     * http post endopoint URL
     */
    private String url = "https://secure.paygate.co.za/payweb3/initiate.trans";

    /**
     * Init with url for PayWeb Class
     *
     * @param url SOAP Message Endpoint URL
     */
    public PayWeb(String url) {
        this.url = url;
    }

    /**
     * Init with default url for PayWeb Class
     *
     */
    public PayWeb() {

    }

    /**
     * Get URL
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Post Request
     *
     * @param bodyValue String created from body function
     * @return String response of the request
     * @throws java.io.IOException java.io.IOException
     */
    public String request(String bodyValue) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        RequestBody body = RequestBody.create(mediaType, bodyValue);
        Request request = new Request.Builder()
                .url(this.url)
                .post(body)
                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * Build Request Body from params
     *
     * @param object params of the body
     * @return String body of the form post request
     */
    public String body(MyObject object) {
        String body = "";
        Set<String> a = object.getPropertiesAsSet();
        for (String i : a) {
            body += bodyField((String) i, (String) object.getProperty((String) i));
        }
        body += "------WebKitFormBoundary7MA4YWxkTrZu0gW--";
        return body;
    }

    /**
     * Build Request Body Field from key/value
     *
     * @param name the name of the field
     * @param value the value of the field
     * @return String Request Body Field
     */
    public String bodyField(String name, String value) {
        String code = "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"" + name + "\""
                + "\r\n\r\n"
                + value
                + "\r\n";
        return code;
    }

    /**
     * Sample of Initiate for PayWeb3
     *
     * @return String response
     * @throws java.io.IOException java.io.IOException
     */
    public String initiate() throws IOException {
        MyObject object = new MyObject();
        object.setProperty("PAYGATE_ID", "10011072130");
        object.setProperty("REFERENCE", "pgtest_123456789");
        object.setProperty("AMOUNT", "3299");
        object.setProperty("CURRENCY", "ZAR");
        object.setProperty("RETURN_URL", "https://my.return.url/page");
        object.setProperty("TRANSACTION_DATE", "2018-01-01 12:00:00");
        object.setProperty("LOCALE", "en-za");
        object.setProperty("COUNTRY", "ZAF");
        object.setProperty("EMAIL", "customer@paygate.co.za");
        object.setProperty("CHECKSUM", "59229d9c6cb336ae4bd287c87e6f0220");
        return request(body(object));
    }

    /**
     * Sample of Query for PayWeb3
     *
     * @return String response of the Query Request
     * @throws java.io.IOException java.io.IOException
     */
    public String query() throws IOException {
        MyObject object = new MyObject();
        object.setProperty("PAYGATE_ID", "10011072130");
        object.setProperty("REFERENCE", "pgtest_123456789");
        object.setProperty("PAY_REQUEST_ID", "23B785AE-C96C-32AF-4879-D2C9363DB6E8");
        object.setProperty("CHECKSUM", "b41a77f83a275a849f23e30b4666e837");
        return request(body(object));
    }

    /**
     * Sample of Redirect for PayWeb3
     *
     * @return String response for the Redirect request
     */
    public String redirect() {
        return null;
    }

    /**
     *
     * @param args Arguments to pass to main function
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        PayWeb pw = new PayWeb();
        System.out.println(pw.initiate());
        pw = new PayWeb("https://secure.paygate.co.za/payweb3/query.trans");
        System.out.println(pw.query());
    }

    /**
     * Display the body in Request Area Field
     *
     * @param object Params of the request
     * @return String the body to display
     */
    public String bodyDisplay(MyObject object) {
        String body = "";
        Set<String> a = object.getPropertiesAsSet();
        for (String i : a) {
            body += (String) i + " = " + (String) object.getProperty((String) i) + "\n";
        }
        return body;
    }
}
