package comments;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.StringWriter;

import static comments.Main.contains;
import static comments.Main.writeWithoutComments;

public class RemoveCommentsTest {
    public static void main(String[] args) throws Exception {

        assert testContainsMethod();
        assert testContainsMethod2();
        assert testContainsMethod3();

        assert testFromTask();

        assert testWithCommas();
    }

    public static boolean testContainsMethod(){
        String line = " \"/*comment in string*/\" ";
        return contains(line, "/*") == -1;
    }

    public static boolean testContainsMethod2(){
        String line = "/*just multiline comment*/";
        return contains(line, "/*") >= 0;
    }
    public static boolean testContainsMethod3(){
        String line = " // single-line comment  ";
        return  contains(line, "//") == 1;
    }

    public static boolean testFromTask() throws Exception{
        String filename = "test.java";

        String right_answer  = "class Hello { \n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hi!\"); \n" +
                "    }\n" +
                "} \n";

        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);

        writeWithoutComments(br, bw);

        return sw.toString().equals(right_answer);

    }

    public static boolean testWithCommas() throws Exception{
        String filename = "testWithCommas.java";

        String right_answer  = "class Hello { \n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hi!\"); \n" +
                "        System.out.println(\"/* i am a multiline comment */ \");\n" +
                "        String comment = \"// i am a single-line comment\";\n" +
                "    }\n" +
                "} \n";

        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);

        writeWithoutComments(br, bw);

        return sw.toString().equals(right_answer);
    }
}
