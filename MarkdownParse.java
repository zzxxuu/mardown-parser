import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            if(markdown.contains("[")&&markdown.contains("]")&&
               markdown.contains("(")&&markdown.contains(")")){
                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);
                if(openBracket == -1 || closeBracket == -1 || 
                   openParen == -1 || closeParen == -1){
                    break;
                }
                else if(openParen != closeBracket + 1){
                    currentIndex = closeParen + 1;
                }
                else if(openBracket != 0 &&
                        markdown.substring(openBracket-1, openBracket).equals("!")){
                        System.out.println("Hi");
                        currentIndex = closeParen + 1;
                }
                else{
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
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
