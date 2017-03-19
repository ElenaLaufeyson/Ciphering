package Ciphering;

public class Data {
    private String key, inputname, outputname;

    public Data(String key, String inputname, String outputname) {
        this.key = key;
        this.inputname = inputname;
        this.outputname = outputname;
    }

    public String getKey() {
        return key;
    }

    public String getInputname() {
        return inputname;
    }

    public String getOutputname() {
        return outputname;
    }
}
