package pers.panqt.springcloud.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author panqt 2019/04/10 8:04
 */
public class Test {
    public static void main(String[] args) {

        new Thread(new Test().new Run()).start();
        new Thread(new Test().new Run()).start();
        new Thread(new Test().new Run()).start();
        new Thread(new Test().new Run()).start();
        new Thread(new Test().new Run()).start();
        new Thread(new Test().new Run()).start();
        new Thread(new Test().new Run()).start();
        new Thread(new Test().new Run()).start();

    }

    class Run implements Runnable{
        @Override
        public void run() {
            BufferedReader in = null;
            try {
                String result = "";
                while (true) {
                    //Thread.sleep(10);
                    result = "";
                    URL realUrl = new URL("http://localhost:7000/comsumer/comsumer/user/get/2?accessToken=111");
                    URLConnection connection = realUrl.openConnection();
                    connection.setRequestProperty("accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

                    connection.connect();
                    connection.getHeaderFields();

                    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        result += line;
                    }
                    if(result ==null || result.indexOf("null")>0){
                        System.out.println("result is error");
                    }

                }
            } catch (Exception e) {
                System.out.println("send get request error！" + e);
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
