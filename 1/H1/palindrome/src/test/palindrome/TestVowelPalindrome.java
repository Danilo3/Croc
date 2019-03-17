package palindrome;
/*
  run with -ea option
 */
public class TestVowelPalindrome {

    public static void main(String[] args) {
        assert TestFromTask();
        assert TestNoVowels();
        assert TestAllVowels();
        assert TestObvious();
        assert TestObvious2();

    }

    static boolean TestFromTask(){
        String answer = VowelPalindrome.vowelPalindrome("palindrome");
        return answer.equals("pelondrima");
    }

    static boolean TestNoVowels(){
        String word = "djkrtplkq";
        String answer = VowelPalindrome.vowelPalindrome(word);
        return answer.equals(word);
    }

    static boolean TestAllVowels(){
        String word = "aeiouy";
        String answer = VowelPalindrome.vowelPalindrome(word);
        return answer.equals("yuoiea");
    }

    static boolean TestObvious(){
        String word = "python";
        String answer = VowelPalindrome.vowelPalindrome(word);
        return answer.equals("pothyn");
    }

    static boolean TestObvious2(){
        String word = "palindrome";
        String answer = VowelPalindrome.vowelPalindrome2(word);
        return answer.equals("pelondrima");
    }
}
