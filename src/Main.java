
import java.io.*;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 27.09.2018
 */

public class Main {
    public static void main(String[] args) throws IOException {
        CopyFileWithNewCharset firstEx = new CopyFileWithNewCharset();
        firstEx.CopyAndChangeCharset();

        DeleteNumberPhone secEx = new DeleteNumberPhone();
        secEx.delete();
    }
}


