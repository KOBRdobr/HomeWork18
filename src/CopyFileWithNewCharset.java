import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 04.10.2018
 */

public class CopyFileWithNewCharset {
        public void CopyAndChangeCharset() throws IOException {
            try(FileInputStream streamInput = new FileInputStream("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files\\Unicode.txt")) {
                File directory = new File("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files");
                if(!directory.isDirectory()) directory.mkdir();

                int symbol;
                StringBuilder builder = new StringBuilder();

                while((symbol = streamInput.read()) != -1) {
                    builder.append((char) symbol);
                }

                byte[] bytes = builder.toString().getBytes("UTF-8");

                try(FileOutputStream streamOutput = new FileOutputStream("C:\\Users\\Nail\\IdeaProjects\\HomeWork18\\Files\\UTF-8.txt")) {
                    for(byte eachByte : bytes) {
                        streamOutput.write(eachByte);
                    }
                    streamOutput.flush();
                } catch (IOException e) {
                    throw new IOException("Error in write file");
                }
            } catch (IOException e) {
                throw new IOException("Error in Read file");
            }
        }
}
