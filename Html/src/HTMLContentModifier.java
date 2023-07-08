import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class HTMLContentModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入网页的URL: ");
        String url = scanner.nextLine();

        try {
            String html = fetchHTML(url);
            if (html != null) {
                System.out.println("原始 HTML 内容：");
                System.out.println(html);

                String modifiedHtml = modifyHTMLContent(html, "p", "\\d+", "999");
                System.out.println("修改后的 HTML 内容：");
                System.out.println(modifiedHtml);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fetchHTML(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.html();
    }

    public static String modifyHTMLContent(String html, String elementSelector, String regex, String replacement) {
        // 解析 HTML
        Document doc = Jsoup.parse(html);

        // 查找指定元素
        Elements elements = doc.select(elementSelector);

        // 修改元素内容
        for (Element element : elements) {
            String text = element.ownText(); // 获取元素文本
            String modifiedText = text.replaceAll(regex, replacement); // 替换文本
            element.text(modifiedText); // 更新元素文本
        }

        // 返回修改后的 HTML
        return doc.html();
    }
}
