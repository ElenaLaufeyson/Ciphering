package Ciphering;
import org.kohsuke.args4j.*;

import java.io.File;
import java.util.regex.*;

public class CheckArg {

    @Option(name = "-c", aliases = {"-d"}, metaVar = "key", required = true,
            usage = "Set connection coding/decoding")
    private String key;

    @Option(name = "-o", metaVar = "outputName", usage = "Output file coding")
    private String outputName;

    @Argument(required = true, metaVar = "inputName", usage = "Input file name")
    private String inputName;

    public void ReadCommLine(String []args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            if (!check16Syst(key))
                throw new IllegalArgumentException("Wrong key - not hexadecimal number or wrong byte");
            if (!(new File(inputName).exists()))
                throw new IllegalArgumentException("Input file doesn't exist");
            if (outputName == null) {
                String s[] = inputName.split("\\.");
                StringBuilder out = new StringBuilder();
                out.append(s[0]);
                out.append("_out.txt");
                outputName = out.toString();
            }
        } catch (CmdLineException e) {
            throw new IllegalArgumentException("Command Line: [-c key] [-d key] " +
                    "inputname.txt [-o] outputname.txt");
        }
    }

    private Boolean check16Syst(String args1) {
        Pattern check = Pattern.compile("^(([a-fA-F0-9]{2})*)$");
        Matcher match = check.matcher(args1);
        return match.matches();
    }

    public String getKey() {return this.key; }

    public String getInputName() {
        return this.inputName;
    }

    public String getOutputName() {
        return this.outputName;
    }

}
