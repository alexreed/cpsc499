/*
 * Main.java
 * Program Name: Common Permutation
 * UVA: 10252
 * PC: 110303
 * Created By: Alex Reed, 230081937
 */

import java.math.BigInteger;
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
        StringBuilder output = new StringBuilder();

        int numberOfCases = Integer.parseInt(scan.nextLine());

        System.out.println("Cases:" + numberOfCases);

        while(numberOfCases > 1)
        {
            int n = Integer.parseInt(scan.nextLine());

            output.append(piecesOfLand(n)).append("\n");

            numberOfCases--;

            System.out.println("Cases:" + numberOfCases);
        }

        System.out.println(output);
    }

    private BigInteger piecesOfLand(int n)
    {
        BigInteger bigger = BigInteger.valueOf(n);

        return bigger.pow(4).subtract(bigger.pow(3).multiply(BigInteger.valueOf(6))).add(bigger.pow(2).multiply(BigInteger.valueOf(23))).subtract(bigger.multiply((BigInteger.valueOf(18)))).add(BigInteger.valueOf(24).divide(BigInteger.valueOf(24)));
    }

}