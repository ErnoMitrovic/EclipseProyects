package cesar_cipher;
public class Cipher {
  static boolean isVowel(char ch) {
      String character = Character.toString(ch);
      character = character.toLowerCase();
      String vowels = "aeiou";
      boolean result = false;
      if (vowels.contains(character)) {
          result = true;
      }
      return result;
  }
  static String replaceVowels(final String phrase, char ch) {
      StringBuilder replacedVowels = new StringBuilder();
      for (int i = 0; i < phrase.length(); i++) {
          if (isVowel(phrase.charAt(i))) {
              replacedVowels.insert(i, ch);
          } else
              replacedVowels.insert(i, phrase.charAt(i));
      }
      return replacedVowels.toString();
  }
    static String emphasize(String phrase,char ch) {
        String enPhrase = "";
        StringBuilder encrypted = new StringBuilder(phrase);
        for (int i = 0; i < encrypted.length(); i++ ) {
            char currChar = encrypted.charAt(i);
            char lowerCh = Character.toUpperCase(ch);
            char upperCh = Character.toLowerCase(ch);
            if (currChar == lowerCh || currChar == upperCh ) {
                if ( i%2 == 0 || i == 0) {
                    encrypted.setCharAt(i, '*');
                } else {
                    encrypted.setCharAt(i, '+');
                }
            }
        }
        enPhrase = encrypted.toString();
        return enPhrase;
    }
    public static String encrypt(String input,int key ) {
        String encrypted = "";
        StringBuilder encriptedMessage = new StringBuilder(input);
        String alphabetUpper ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String shiftalphabetUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0,key);
        String shiftalphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0,key);
        for (int i = 0; i < encriptedMessage.length(); i++ ) {
            char currChar = encriptedMessage.charAt(i);
            int alphabetindexUpper = alphabetUpper.indexOf(currChar);
            int alphabetindexLower = alphabetLower.indexOf(currChar);
            if (alphabetindexUpper != -1) {
                char newChar = shiftalphabetUpper.charAt(alphabetindexUpper);
                encriptedMessage.setCharAt(i, newChar);
            } else if (alphabetindexUpper == -1 && alphabetindexLower != -1 ) {
                char newChar = shiftalphabetLower.charAt(alphabetindexLower);
                encriptedMessage.setCharAt(i, newChar);
            }
        }
        encrypted = encriptedMessage.toString();
        return encrypted;
    }
    public static String encryptTwoKeys(String message, int key1, int key2) {
        StringBuilder messageEncrypt = new StringBuilder(message);

        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower= "abcdefghijklmnopqrstuvwxyz";

        String shiftAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftAlphabet1Lower = shiftAlphabet1.toLowerCase();

        String shiftAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        String shiftAlphabet2Lower = shiftAlphabet2.toLowerCase();

        for (int i=0; i <messageEncrypt.length(); i++) {
            char current = messageEncrypt.charAt(i);
            if ((i+1)%2==0) {
                int index = alphabet.indexOf(current);
                int indexLower = alphabetLower.indexOf(current);
                if (index != -1) {
                    char encrypt = shiftAlphabet2.charAt(index);
                    messageEncrypt.setCharAt(i, encrypt);
                }
                else if (index == -1 && indexLower != -1) {
                    char encrypt = shiftAlphabet2Lower.charAt(indexLower);
                    messageEncrypt.setCharAt(i, encrypt);
                }
            }
            else{
                int index = alphabet.indexOf(current);
                int indexLower = alphabetLower.indexOf(current);
                if (index != -1) {
                    char encrypt = shiftAlphabet1.charAt(index);
                    messageEncrypt.setCharAt(i, encrypt);
                }
                else if (index == -1 && indexLower != -1) {
                    char encrypt = shiftAlphabet1Lower.charAt(indexLower);
                    messageEncrypt.setCharAt(i, encrypt);
                }
            }
        }
        return messageEncrypt.toString();
    }
}
