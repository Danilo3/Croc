package triangle;

import java.util.Scanner;

public class TriangleSquare {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter six numbers, separated by space");
        Point a = new Point(scanner.nextDouble(), scanner.nextDouble());
        Point b = new Point(scanner.nextDouble(), scanner.nextDouble());
        Point c = new Point(scanner.nextDouble(), scanner.nextDouble());

        Triangle triangle = new Triangle(a, b, c);

        double square = triangle.getSquare();

        System.out.println("Square: " + square);

    }
}

