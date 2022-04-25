package ch7;

import javax.swing.text.html.HTML;

public class ParserTest {
    public static void main(String[] args) {
        Parseable p = ParserManager.getParser("XML"); // new XMLParser() 객체 생성
        p.parse("document.xml");
        p = ParserManager.getParser("HTML"); // new HTMLParser() 객체 생성
        p.parse("document.html");
    }
}
interface Parseable {
    // 구문 분석작업 수행
    public abstract void parse(String fileName); // public abstract 생략 가능 -> 추상 메서드
}
class XMLParser implements Parseable {
    public void parse(String fileName) {
        System.out.println(fileName + "- XML parsing completed.");
    }
}
class HTMLParser implements Parseable {
    public void parse(String fileName) {
        System.out.println(fileName + "- HTML parsing completed.");
    }
}
class ParserManager {
    // 리턴 타입이 Parseable Interface이다.
    public static Parseable getParser(String type) { // return type이 Parseable인 method
        if(type.equals("XML")) {
            return new XMLParser();
        }else{
            return new HTMLParser();
        }
    }
}