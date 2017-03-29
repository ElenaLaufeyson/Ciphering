package Ciphering;

public class Main {

    public static void main(String[] args) {
        CheckArg check = new CheckArg(args);
        FileCoder code = new FileCoder(check.getKey(), check.getInputName(), check.getOutputName());
        code.convert();
    }
}
