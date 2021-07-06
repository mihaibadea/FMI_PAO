import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class CSVHelper {
    private static CSVHelper single_instance = null;

    public static CSVHelper getInstance() {
        if (single_instance == null) {
            single_instance = new CSVHelper();
        }
        return single_instance;
    }

    public ArrayList<String> citesteFisier(String path) throws IOException {
        File file = new File(path);
        ArrayList<String> buf = new ArrayList<>();
        if(file.exists() && file.canRead()){
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                buf.add(sc.nextLine());
            }
            sc.close();
        }
        return buf;
    }

    public void audit(String actiune) throws IOException {
        File file = new File("csv/audit.csv");
        FileWriter file_writer = new FileWriter(file, true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        file_writer.write(actiune + ", " + dtf.format(now) + "\n");
        file_writer.close();
    }

}