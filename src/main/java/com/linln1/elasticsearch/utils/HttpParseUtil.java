package com.linln1.elasticsearch.utils;

import com.linln1.elasticsearch.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


@Component
public class HttpParseUtil {

    public static void main(String[] args) throws IOException {
        new HttpParseUtil().parseJD("原味").forEach(System.out::println);
    }

    public ArrayList<Content> parseJD(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements li = element.getElementsByTag("li");

        ArrayList<Content> goodList = new ArrayList<>();

        for (Element l : li) {
            String img_url = l.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = l.getElementsByClass("p-price").eq(0).text();
            String title = l.getElementsByClass("p-name").eq(0).text();

            Content content = new Content();
            content.setTitle(title);
            content.setPrice(price);
            content.setImg(img_url);
            goodList.add(content);
        }
        return goodList;
    }
}
