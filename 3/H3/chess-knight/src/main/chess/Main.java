package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        System.out.print("[in]: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String cellsInput = br.readLine();
            String[] cells = cellsInput.split(" ");
            Knight knight = new Knight(new ChessCell(cells[0]));

            for (int i = 1; i < cells.length; i++) {
                knight.makeMove(new ChessCell(cells[i]));
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IllegalKnightMoveException e){
            System.out.print("[out]: ");
            System.out.println(e.getMessage());
            System.exit(-2);
        }
        System.out.print("[out]: OK");
    }
}
