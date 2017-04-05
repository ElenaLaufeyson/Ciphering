package Ciphering;

public class Main {

    public static void main(String[] args) {
        CheckArg check = new CheckArg();
        check.ReadCommLine(args);
        FileCoder code = new FileCoder(check.getKey());
        code.convert(check.getInputName(), check.getOutputName());
    }
}
