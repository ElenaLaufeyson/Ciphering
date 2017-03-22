package Ciphering;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CheckArg check = new CheckArg(args);
        convert(check.getKey(), check.getInputName(), check.getOutputName());
    }

    public static void convert (String key, String inputName, String outputName) {
        CiphXor coder = new CiphXor(key);
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        int max = 100; //по сколько считываем байт
        int lengh = 0;
        byte text[] = new byte[max];
        byte cut[];
        try {
            fileIn = new FileInputStream(inputName);
            fileOut = new FileOutputStream(outputName);
            while ((lengh = fileIn.read(text))!= -1) {
                if (lengh < max) {
                    cut = new byte[lengh];
                    System.arraycopy(text, 0, cut, 0, lengh);
                    fileOut.write(coder.xorCoder(cut));
                }
                else fileOut.write(coder.xorCoder(text));
            }
            fileIn.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
    }
}

