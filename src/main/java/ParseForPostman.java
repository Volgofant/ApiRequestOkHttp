import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseForPostman {
    public  ParseForPostman(int fileName, int quantity) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\viktor.nenashev\\sku\\" + fileName + ".csv"));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        for(String s : lines) {
            System.out.println("    {\n" +
                    "\t    \"sku\": \"" + s +"\",\n" +
                    "        \"stockType\": \"virtualShopStock\",\n" +
                    "        \"location\": null,\n" +
                    "        \"quality\": 1,\n" +
                    "        \"quantity\": "+ quantity + "\n" +
                    "    },");
        }
    }
}
