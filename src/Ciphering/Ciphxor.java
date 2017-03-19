package Ciphering;

public class Ciphxor {
    private byte key[];

    public Ciphxor(String key) {
        this.key = key.getBytes(); //ключ хранится как массив байт
    }

    public byte[] xorCoder(byte text[]) {
        byte result[] = new byte[text.length];
        for (int i=0; i<text.length;i++) {
            result[i] = (byte)(text[i]^key[i%key.length]);
        }
        return result;
    }
}
