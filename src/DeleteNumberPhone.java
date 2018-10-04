import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 04.10.2018
 */

public class DeleteNumberPhone {
    public void delete() throws IOException {

        try(FileReader file = new FileReader("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files\\PhoneNumbers.txt")) {
            int symbol;
            StringBuilder builder = new StringBuilder();

            while ((symbol = file.read()) != -1) {
                builder.append((char) symbol);
            }
            char[] fileText = builder.toString().toCharArray();

            StringBuilder numbers = new StringBuilder();


            for(int i = 0; i < fileText.length; i++) {
                for (int j = 0; j < 12; i++) {
                    numbers.append(fileText[j]);
                }

                System.out.println();
            }


        } catch (IOException e) {
            throw new IOException("Error in Read file");
        }
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
