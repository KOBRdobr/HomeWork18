
import java.io.*;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 27.09.2018
 */

public class Main {
    public static void main(String[] args) throws IOException {
        copyFileWithNewCharser();
        deleteNumberPhone();
    }

    private static void deleteNumberPhone() throws IOException {
        try(FileReader reader = new FileReader("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files\\PhoneNumbers.txt")) {

            int symbol;
            StringBuilder builder = new StringBuilder();

            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
            char[] fileText = builder.toString().toCharArray();
            StringBuilder phoneNumbers = new StringBuilder();

            int count = 0;
            int j = 0;

            for(int i = 0; i < fileText.length; i++) {
                if (Character.isDigit(fileText[i])) {
                    for (j = i; j < fileText.length; j++) {
                        if (!Character.isDigit(fileText[j])) {
                            break;
                        }
                        count++;

                    }
                }
                if(count == 11) {
                    i = j;
                }
                count = 0;
                phoneNumbers.append(fileText[i]);
            }
            String file = phoneNumbers.toString();
            char[] chars = file.toCharArray();

            try(FileWriter writer = new FileWriter("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files\\PhoneNumbers.txt")) {
                for(char eachChar : chars) {
                    writer.write(eachChar);
                }
                writer.flush();

            }catch (IOException e) {
                throw  new IOException("Error in Write file");
            }
        } catch (IOException e) {
            throw new IOException("Error in Read file");
        }
    }


    private static void copyFileWithNewCharser() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files\\Unicode.txt"), "Unicode"))) {

            File directory = new File("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files");
            if(!directory.isDirectory()) directory.mkdir();

            String str;
            StringBuilder builder = new StringBuilder();

            while((str  = reader.readLine()) != null) {
                builder.append(str);
            }


            String newStr = builder.toString();

                try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files\\UTF-8.txt"), "UTF-8") )) {
                    writer.write(newStr);
                    writer.flush();
                } catch (IOException e) {
                    throw new IOException("Error in write file");
                }
        } catch (IOException e) {
            throw new IOException("Error in Read file");
        }
    }


}


