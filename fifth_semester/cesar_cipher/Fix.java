package cesar_cipher;

public class Fix{
    public static void main(String[] args) {
        System.out.println(Cipher.replaceVowels("Eliam cOme CaCA", '*'));
        System.out.println(Cipher.emphasize("Hice caca seca", 'c'));
        System.out.println(Cipher.encrypt("Eliam come pan crudo", 12));
        System.out.println(Cipher.encryptTwoKeys("Eliam come penes", 11, 23));
        System.out.println(Cipher.encryptTwoKeys("Eliam come penes", 8, 10));
    }
}