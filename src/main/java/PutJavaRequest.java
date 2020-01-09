import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PutJavaRequest {
    public PutJavaRequest(int fileName, int quantity) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\viktor.nenashev\\sku\\" + fileName + ".csv"));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        for(String s : lines) {
            new ApiRequest(s, quantity);
        }
    }
}
