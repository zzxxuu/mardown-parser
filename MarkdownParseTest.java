import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void test1() throws IOException{
        ArrayList<String> links = new ArrayList<>();
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        links.add("https://something.com");
        links.add("some-thing.html");
        assertEquals(links, MarkdownParse.getLinks(content));
    }
    @Test
    public void test2() throws IOException{
        ArrayList<String> links = new ArrayList<>();
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        assertEquals(links, MarkdownParse.getLinks(content));
    }
    @Test
    public void test3() throws IOException{
        ArrayList<String> links = new ArrayList<>();
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        assertEquals(links, MarkdownParse.getLinks(content));
    }
    @Test
    public void test4() throws IOException{
        ArrayList<String> links = new ArrayList<>();
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        links.add("https://something.com");
        assertEquals(links, MarkdownParse.getLinks(content));
    }

    @Test
    public void test5() throws IOException{
        ArrayList<String> links = new ArrayList<>();
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        assertEquals(links, MarkdownParse.getLinks(content));
    }
}

/**
 * public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            if(markdown.contains("[")&&markdown.contains("]")&&markdown.contains("(")&&markdown.contains(")")){
                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);
                if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                    break;
                }
                else if(openBracket != 0 &&markdown.substring(openBracket-1, openBracket).equals("!")){
                    currentIndex = closeParen + 1;
                }
                else if(openParen == closeBracket + 1){
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                }
                else{
                    currentIndex = closeParen + 1;
                }
            }
            else{
                break;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
 */
