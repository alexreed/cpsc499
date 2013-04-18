/*
 * Main.java
 * Program Name: Common Permutation
 * UVA: 10252
 * PC: 110303
 * Created By: Alex Reed, 230081937
 */

import java.util.*;

class Main implements Runnable{


    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{

    public void run()
    {
        Scanner scan = new Scanner(System.in);

        long input = scan.nextLong();

        while(input != 0)
        {
            long squareRoot = (long) Math.floor(Math.sqrt(input));

            long square = squareRoot * squareRoot;

            if(square == input)
                System.out.println("Yes");
            else
                System.out.println("No");

            input = scan.nextLong();
        }
    }
}