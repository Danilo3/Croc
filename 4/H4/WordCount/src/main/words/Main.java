package words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Wrong args");
            System.exit(-4);
        }
        String filename = args[0];
        long word_count_sum = 0L;

        if(filename.isEmpty()) {
            System.err.println("Filename absents");
            System.exit(-1);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine())!=null){
                word_count_sum += countWordsInStr(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(-2);
        } catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(-3);
        }
        System.out.println(word_count_sum);
    }
    public static int countWordsInStr(String str) {
        int word_count = 0;
        boolean isWord = false;

        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i);
            if(Character.isSpaceChar(ch)) {
                if(isWord){
                    isWord = false;
                }
            } else if(!isWord) {
                isWord = true;
                word_count++;
            }
        }
        return word_count;
    }
}

