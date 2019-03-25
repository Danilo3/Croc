package comments;

import java.io.*;


/*

   Cases:
    - simple single-line
    - single-line in commas - is not deleted
    - single-line in multiline
    - simple multiline on several lines
    - multiline in one line
    - multiline in commas - is not deleted
 */
public class Main {

    public static void abort(String msg, int status){
        System.err.println(msg);
        System.exit(status);
    }


    public static void main(String[] args) {
        if(args.length != 1){
            abort("Wrong arguments. Need only file name", -1 );
        }

        String filename = args[0];

        if(filename.isEmpty()){
            abort("Empty filename", -2);
        }

        try(FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            OutputStreamWriter osw = new OutputStreamWriter(System.out);
            BufferedWriter bw = new BufferedWriter(osw)){

            writeWithoutComments(br, bw);

        }catch (FileNotFoundException e ){
            abort(e.getMessage(), -3);
        } catch (IOException e){
            abort(e.getMessage(), -4);
        }
    }

    public static boolean isEmptyString(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isSpaceChar(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
        @param pattern - string which length()== 2 and doesn't contain commas
        @return position of first entry of pattern in line, or -1 if it wasn't found
     */

    public static int contains(String line, String pattern){
        boolean isStart = false;
        boolean isCommas = false;
        for (int i = 0; i < line.length() ; i++) {
            char ch = line.charAt(i);
            if(ch == pattern.charAt(0) && !isStart){
                isStart = true;
                continue;
            } else if(ch == '\"' && !isCommas){
                isCommas = true;
                isStart = false;
                continue;
            } else if(ch == '\"'){
                isCommas = false;
            }
            if(ch == pattern.charAt(1) && isStart && !isCommas){
                return i-1;
            } else {
                isStart = false;
            }
        }
        return -1;
    }

    public static void writeWithoutComments(BufferedReader reader, BufferedWriter writer ) throws IOException {
        if(reader == null || writer == null){
            throw new IllegalArgumentException("Null io objects");
        }

        String line = "";
        boolean isMultilineComment = false;

        while((line = reader.readLine())!= null){
            int begin_multi = contains(line, "/*");
            int end_multi = contains(line, "*/");
            int begin_single = contains(line,"//" );

            if(end_multi >= 0 && begin_multi >= 0 ){
                line = line.substring(0, begin_multi) + line.substring(end_multi + 2);
                if(!isEmptyString(line)) {
                    writer.write(line);
                    writer.newLine();
                }
            } else if(begin_multi >= 0){
                isMultilineComment = true;
                continue;
            } else if(end_multi >= 0 && isMultilineComment){
                isMultilineComment = false;
                continue;
            } else if(begin_single >= 0 ){
                line = line.substring(0, begin_single);
                if(!isEmptyString(line)) {
                    writer.write(line);
                    writer.newLine();
                }
            } else if(!isMultilineComment){
                writer.write(line);
                writer.newLine();
            }
        }
        writer.flush();

    }

}
