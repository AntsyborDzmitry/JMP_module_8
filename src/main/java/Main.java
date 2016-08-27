import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src\\main\\resources\\test.txt";

    public static void main(String[] args) {
          List<String> cache = new ArrayList<String>();

        //case with substring leaks - launch with Java version before 7.6

            /*for (int i = 15000; i>=0; i--){
                try {
                    readFile(cache);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }*/


       //case with Integer leaks -  due to not proper equals() implementation in Key class
        /*
            Map m = new HashMap();
            while (true)
            for (int i = 0; i < 10_000; i++)
            if (!m.containsKey(i)){
            m.put(new Key(i), "Number:" + i);
            }
        */
    }

    private static void  readFile(List cache ) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        File csvFile = new File(FILE_PATH);
        if (csvFile.exists()) {
           try  {
               String line = "";
               while ((line = br.readLine()) != null) {
                   cache.add(line.substring(0,1));
               }
               Thread.sleep(1);
           } catch (IOException e) {
               throw new RuntimeException(e);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }

    static class Key {
        Integer id;
        Key(Integer id) {
            this.id = id;
        }
        @Override
        public int hashCode() {
        return id.hashCode();
        }
    }
}