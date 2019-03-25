package callcenter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("One required parameter: filename ");
            System.exit(-1);
        }
        String filename = args[0];
        if(filename.isEmpty()){
            System.err.println("Filename empty");
            System.exit(-2);
        }

        int peak_call_count = 0;

        try(FileReader fr = new FileReader(filename);
            BufferedReader br  = new BufferedReader(fr)) {

            ArrayList<Call> calls = new ArrayList<>();
            String line = "";
            while((line = br.readLine())!= null){
                String[] input = line.split(",");
                if(input.length == 2) {
                    long from = Long.parseLong(input[0]);
                    long to = Long.parseLong(input[1]);
                    calls.add(new Call(from, to));
                }
            }
            peak_call_count = getPeakCallCount(calls);


        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            System.exit(-3);
        } catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(-4);
        }

        System.out.println(peak_call_count);
    }

    public static int getPeakCallCount(ArrayList<Call> calls){
        if(calls == null){
            throw new IllegalArgumentException("null ArrayList");
        }

        int peak_calls = 0;
        int counter = 0;
        for(Call currentCall : calls){
            for(Call otherCall : calls){
              if ((otherCall.getEnd() <= currentCall.getEnd() && otherCall.getEnd() >= currentCall.getBegin()) ||
                    otherCall.getBegin() <= currentCall.getEnd() && otherCall.getBegin() >= currentCall.getBegin()){
                  counter++;
              }
            }
            if(counter > peak_calls){
                peak_calls = counter;
            }
            counter = 0;
        }


        return peak_calls - 1;
    }
}
