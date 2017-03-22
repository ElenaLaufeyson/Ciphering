package Ciphering;

public class CiphXor {
    private byte key[];

    public CiphXor(String strKey) {
        key = new byte[strKey.length()/2];
        String twoChar = "";
        Integer n;
        for (int i=0, j=0;i<strKey.length();i+=2) {
            twoChar = strKey.substring(i, i+2);
            n = Integer.parseInt(twoChar,16);
            key[j++] = n.byteValue();
        }
    }

    public byte[] xorCoder(byte text[]) {
        byte result[] = new byte[text.length];
        for (int i=0; i<text.length;i++) {
            result[i] = (byte)(text[i]^key[i%key.length]);
        }
        return result;
    }
}
