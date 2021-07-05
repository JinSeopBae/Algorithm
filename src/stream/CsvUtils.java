package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtils {

    public static List<List<String>> readToList() {
        List<List<String>> list = new ArrayList<>();
        File csv = new File("./member.csv");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
            Charset.forName("UTF-8");
            String line = "";

            while((line=br.readLine()) != null) {
                String[] token = line.split(",");
                List<String> tempList = new ArrayList<>(Arrays.asList(token));
                list.add(tempList);
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if(br != null) {br.close();}
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return list;
    }
}
