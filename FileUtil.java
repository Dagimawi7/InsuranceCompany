import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static <T> void writeToFile(String fileName, List<T> items) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : items) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readFromFile(String fileName, Class<T> clazz) {
        List<T> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (clazz == Customer.class) {
                    items.add(clazz.cast(Customer.fromString(line)));
                } else if (clazz == Policy.class) {
                    items.add(clazz.cast(Policy.fromString(line)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}
