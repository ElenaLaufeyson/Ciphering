import Ciphering.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CiphTests {

    @Tag("Checking cmd")
    @Test
    void CheckCmd() {
        String s = "";
        String args[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args));
    }

    @Tag("Checking -c/-d & key")
    @Test
    void CheckKey() {
        String s = "cafe inputname.txt";
        String args[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args));
        s = "-s cafe in.txt";
        String args1[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args1));
        s = "-c bad inputname.txt";
        String args2[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args2));
        s = "-d sdaf in.txt";
        String args3[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args3));
    }

    @Tag("Checking inputname")
    @Test
    void CheckInputName() {
        String s = "-c cafe ";
        String args[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args));
    }

    @Tag("Checking -o & outputname")
    @Test
    void CheckOutputName() {
        String s = "-c cafe in.txt -o";
        String args[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args));
        s = "-c cafe in.txt -p";
        String args1[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args1));
        s = "-c cafe in.txt out.txt";
        String args2[] = s.split("\\s+");
        assertThrows(IllegalArgumentException.class,
                () -> new CheckArg(args2));
        }

    @Tag("Cheking CiphXor")
    @Test
    void CheckCiphXor() throws IOException {
        Main.convert("cafe", "in.txt", "out.txt");
        Main.convert("cafe", "out.txt", "out_out.txt");
        FileInputStream file1 = new FileInputStream("in.txt");
        FileInputStream file2 = new FileInputStream(("out_out.txt"));
        int b1=0,b2=0;
        try {
            while ((b1 = file1.read()) != -1) {
                b2 = file2.read();
                if (b1 != b2) throw new IllegalAccessError("Error ciphering");
            }
        } catch (IllegalAccessError e) {
            System.out.println("Error ciphering");
        }
        file1.close();
        file2.close();
    }

}