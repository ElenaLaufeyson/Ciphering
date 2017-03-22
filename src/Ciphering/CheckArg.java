package Ciphering;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckArg {

    private Boolean check16Syst(String args1) {
        Pattern check = Pattern.compile("^[a-fA-F0-9]*$");
        Matcher match = check.matcher(args1);
        return match.matches();
    }

    public Data resultcheck(String []args) {
        if (args.length < 3)
            throw new IllegalArgumentException("Command Line: [-c key] [-d key] " +
                    "inputname.txt [-o outputname.txt");
        if (!args[0].equals("-c") && !args[0].equals("-d"))
            throw new IllegalArgumentException("Expected key -c or -d");
        if (!check16Syst(args[1]))
            throw new IllegalArgumentException("Wrong key - not hexadecimal number");
        if (!(new File(args[2]).exists()))
            throw new IllegalArgumentException("Input file doesn't exist");
        String outputName = "";
        if (args.length == 3) {
            String s[] = args[2].split("\\.");
            StringBuilder out = new StringBuilder();
            out.append(s[0]);
            out.append("_out.txt");
            outputName = out.toString();
        }
        else {
            if (!(args[3].equals("-o")))
                throw new IllegalArgumentException("Incorrect format. Expected -o");
            if (args.length < 5)
                throw new IllegalArgumentException("Couldn't find the name of output file");
            outputName = args[4];
        }
        return new Data(args[1], args[2], outputName);
    }

}