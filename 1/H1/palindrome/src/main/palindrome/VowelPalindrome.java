package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VowelPalindrome {
    public static void main(String[] args) {
        System.out.print("Enter word: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = "";
        try{
            word = br.readLine();
        } catch (IOException exception){
            System.err.println(exception.getMessage());
            System.exit(-1);
        }
        String result = vowelPalindrome(word);
        System.out.println("Answer: "+ result);
    }

    public static String vowelPalindrome(String word){
        char word_vowels[] = new char[word.length()];
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if( isVowel(letter)){
                word_vowels[counter++] = letter;
            }
        }
        char[] palindrome = word.toCharArray();
        counter --;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(isVowel(letter)){
                palindrome[i] = word_vowels[counter--];
            }
        }
        return new String(palindrome);
    }

    /*
        p a l i n d r o m e

     */
    public static String vowelPalindrome2(String word){
        int reverse_counter = word.length() - 1;
        char[] palindrome = word.toCharArray();
        for(int i = 0; i < reverse_counter; i++){
            char letter = word.charAt(i);
            if(isVowel(letter)){
                for (int j = reverse_counter; j >= 0; j--) {
                    char letter_from_end = word.charAt(j);
                    if(isVowel(letter_from_end)){
                        palindrome[j] = letter;
                        palindrome[i] = letter_from_end;
                        reverse_counter--;
                        break;
                    }
                }

            }
        }
        return new String(palindrome);
    }

    public static boolean isVowel(char letter){
        char vowels[] = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (char vowel : vowels) {
            if (letter == vowel) {
                return true;
            }
        }
        return false;
    }
}
