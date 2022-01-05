import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader {

    /**
     * чтение отчета за месяц
     */
    public ArrayList<ItemInfo> createMonthReport(String path) throws IOException {
        String fileContents = readFileContents(path);
        String[] lines = fileContents.split("\\n");
        ArrayList<ItemInfo> lineContents = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] line = lines[i].split(",");
            lineContents.add(new ItemInfo(line[0], Boolean.parseBoolean(line[1]), Integer.parseInt(line[2]),
                    Integer.parseInt(line[3])));
        }
        return lineContents;
    }

    /**
     * чтение годового отчета
     */
    public ArrayList<YearLineInfo> createYearReport(String path) throws IOException {
        String fileContents = readFileContents(path);
        String[] lines = fileContents.split("\\n");
        ArrayList<YearLineInfo> lineContents = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] line = lines[i].split(",");
            lineContents.add(new YearLineInfo(Integer.parseInt(line[0]), Integer.parseInt(line[1]),
                    Boolean.parseBoolean(line[2])));
        }
        return lineContents;
    }

    private String readFileContents(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
}
