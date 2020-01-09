import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DelimetrCSV {
    public  DelimetrCSV(String fileName, int csvSize) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\viktor.nenashev\\sku\\" + fileName + ".csv"));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        for (int i = 0; i <= lines.size() / csvSize; i++) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\viktor.nenashev\\sku\\" + i + ".csv"));
            try {
                for (int j = 0; j < csvSize; j++) {
                    writer.write(lines.get(j + (csvSize * i)) + System.getProperty("line.separator"));
                    writer.flush();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Значения записаны " + e);
            }
        }
    }
}
