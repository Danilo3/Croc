package words;

import java.io.*;

import static words.Main.countWordsInStr;

public class TestWordCount {

    public static void main(String[] args) throws IOException {
        assert testFromTask();
    }

    public static boolean testFromTask() throws IOException {
        String text ="Забыл   Панкрат  Кондратьевич домкрат,\n" +
                "А без домкрату ну  не  поднять на тракте трактор.";

        int answer = 13;

        BufferedReader br  = new BufferedReader(new StringReader(text));

        long result = countWordsInStr(br.readLine()) + countWordsInStr(br.readLine());

        return answer == result;
    }
}
