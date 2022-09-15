import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main082403
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/24  19:43
 * @Version 1.0
 **/
public class Main082403 {
    public static void main(String[] args) throws Exception {
        String httpDirection = "http://match.sports.sina.com.cn/football/csl/opta_rank.php?item=order&year=2019&lid=8&type=2&dpc=1";
        try {
            //建立连接
            URL url = new URL(httpDirection);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream input = httpUrlConn.getInputStream();

            InputStreamReader read = new InputStreamReader(input, "utf-8");

            BufferedReader br = new BufferedReader(read);
            List<Integer> noList = new ArrayList<>();
            List<String> cnName = new ArrayList<>();
            List<Integer> rank = new ArrayList<>();
            // 读取返回结果
            String content = br.readLine();
            while(content!=null)  {

                System.out.println(content);
                int i = content.indexOf("<tr class");
                if(i != -1){
                    content = br.readLine();
                    System.out.println(content);
//                    System.out.println(content);
                    char[] chars = content.toCharArray();

                    int start0 = content.indexOf("<td>");
                    int end0 = content.indexOf("</td>");
                    noList.add(Integer.valueOf(content.substring(start0,end0 + 1)));
                    content = br.readLine();
//                    System.out.println(content);
                    int start = content.indexOf("target=\"_blank\"");
                    int end = content.indexOf("</a>");
                    cnName.add(content.substring(start,end+1));
                    for(int j = 0; j < 7; j++){
                        content = br.readLine();
//                        System.out.println(content);

                    }
                    content = br.readLine();
//                    System.out.println(content);
                    int rankStart = content.indexOf("<td>");
                    int rankEnd = content.indexOf("</td>");
                    rank.add(Integer.valueOf(content.substring(rankStart,rankEnd)));

                }
                content=br.readLine();
            }
            System.out.println(noList);
            for(int i = 0; i < noList.size(); i++){
                System.out.println("第"+noList.get(i)+"名-"+cnName.get(i)+"，总积分为:"+rank.get(i));
            }



            br.close();
            read.close();
            input.close();
            httpUrlConn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

