public class Main {
    private static final String FILE_PATH = "";

    public static void main(String[] args) {

               File csvFile = new File(FILE_PATH);
               if (csvFile.exists()) {

                   try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

                       while ((line = br.readLine()) != null) {

                           //String[] person = line. (cvsSplitBy);
                           //String[] person = line.split(cvsSplitBy);

                       }
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
        }
    }
}
