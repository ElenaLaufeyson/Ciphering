package Ciphering;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CheckArg check = new CheckArg();
        Data dat = check.resultcheck(args);
        Ciphxor coder = new Ciphxor(dat.getKey());
        FileInputStream filein = null;
        FileOutputStream fileout = null;
        int max = 100; //по сколько считываем байт
        int lengh = 0;
        byte text[] = new byte[max];
        byte cut[];
        try {
            filein = new FileInputStream(dat.getInputname());
            fileout = new FileOutputStream(dat.getOutputname());
            while ((lengh = filein.read(text))!= -1) {
                if (lengh < max) {
                    cut = new byte[lengh];
                    System.arraycopy(text, 0, cut, 0, lengh);
                    fileout.write(coder.xorCoder(cut));
                }
                else fileout.write(coder.xorCoder(text));
            }
            filein.close();
            fileout.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(2);
        }
    }
}
