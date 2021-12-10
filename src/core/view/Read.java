package core.view;

import java.util.Scanner;

public class Read {
    private Scanner sc;
    private Scanner sc2;

    public Read() {
        sc = new Scanner(System.in);
        sc2 = new Scanner(System.in);
    }

    public int readInt() {
        return sc.nextInt();
    }

    public double readDouble() {
        return sc.nextDouble();
    }

    public String readString() {
        return sc2.next();
    }

    public String readNextLine() {
        return sc2.nextLine();
    }



}
