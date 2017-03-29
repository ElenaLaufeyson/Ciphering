package Ciphering;

import java.io.*;

public class FileCoder {

    private String inputFile, outputFile, key;

    public FileCoder(String key, String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.key = key;
    }

    public void convert () {
        CiphXor coder = new CiphXor(key);
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        int max = 100; //по сколько считываем байт
        int lengh = 0;
        byte text[] = new byte[max];
        byte cut[];
        try {
            fileIn = new FileInputStream(inputFile);
            fileOut = new FileOutputStream(outputFile);
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
