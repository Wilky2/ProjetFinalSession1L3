package core.view;

import java.util.Scanner;

public class Read {
    private Scanner sc;

    public Read() {
        sc = new Scanner(System.in);
    }

    public int readInt() {
        int n = sc.nextInt();
        readNextLine();
        return n;
    }

    public double readDouble() {
        double n = sc.nextDouble();
        readNextLine();
        return n;
    }

    public String readString() {
        return sc.nextLine();
    }

    public String readNextLine() {
        return sc.nextLine();
    }



}
