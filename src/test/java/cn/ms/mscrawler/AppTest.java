package cn.ms.mscrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import us.codecraft.xsoup.XElements;
import us.codecraft.xsoup.Xsoup;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        String url = "http://localhost:8080";
        String filePath = "C:\\Users\\weizheng\\Desktop\\elasticsearch-2.3.2.zip";
        RestTemplate rest = new RestTemplate();
        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("fileName", "test.txt");
        param.add("file", resource);
//        String forObject = rest.getForObject(url, String.class, param);
        String string = rest.postForObject(url, param, String.class);
        System.out.println(string);

//        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String,Object>>(param);
//        ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.POST, httpEntity, String.class);
//        System.out.println(responseEntity.getBody());
    }

    @Test
    public void testSelect() {
        String html = "<div style='display:none' >" +
                "<xml id='dataisxxb_sum2'><xxblist>\n" +
                "<jsjs><jsjs1>201507</jsjs1><jsjs2>201507</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201508</jsjs1><jsjs2>201508</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201509</jsjs1><jsjs2>201509</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201510</jsjs1><jsjs2>201510</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201511</jsjs1><jsjs2>201511</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201512</jsjs1><jsjs2>201512</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201601</jsjs1><jsjs2>201601</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201602</jsjs1><jsjs2>201602</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201603</jsjs1><jsjs2>201603</jsjs2><jsjs3>9764.4</jsjs3><jsjs4>781.2</jsjs4><jsjs5>9764.4</jsjs5><jsjs6>195.3</jsjs6><jsjs7>9764.4</jsjs7><jsjs8>48.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201604</jsjs1><jsjs2>201604</jsjs2><jsjs3>7772.6</jsjs3><jsjs4>621.8</jsjs4><jsjs5>7772.6</jsjs5><jsjs6>155.5</jsjs6><jsjs7>7772.6</jsjs7><jsjs8>38.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201605</jsjs1><jsjs2>201605</jsjs2><jsjs3>7772.6</jsjs3><jsjs4>621.8</jsjs4><jsjs5>7772.6</jsjs5><jsjs6>155.5</jsjs6><jsjs7>7772.6</jsjs7><jsjs8>38.9</jsjs8></jsjs>\n" +
                "<jsjs><jsjs1>201606</jsjs1><jsjs2>201606</jsjs2><jsjs3>7772.6</jsjs3><jsjs4>621.8</jsjs4><jsjs5>7772.6</jsjs5><jsjs6>155.5</jsjs6><jsjs7>7772.6</jsjs7><jsjs8>38.9</jsjs8></jsjs>\n" +
                "</xxblist></xml></div>";

        Document document = Jsoup.parse(html);
        XElements xElements = Xsoup.select(html, "//jsjs");
        String s = xElements.get();
        System.out.println(s);

        Elements elements = xElements.getElements();
        for (Element element : elements) {
            System.out.println(element.tagName());
        }

        String result = Xsoup.select(document, "//jsjs").get();
        Assert.assertEquals("https://github.com", result);

        result = Xsoup.compile("//a/@href").evaluate(document).get();
        Assert.assertEquals("https://github.com", result);
    }
}
