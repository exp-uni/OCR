import org.json.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
public class CharSearch{
  JSONObject alphabet;
  
  public CharSearch(String filename){
    try{
      alphabet = new JSONObject(Files.readAllLines(Paths.get(filename), Charset.defaultCharset()));
    }
    catch (IOException e){
      System.out.println(e);
    }
  }


}