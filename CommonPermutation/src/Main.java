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
        ArrayList permutation = new ArrayList();

        while(scan.hasNextLine())
        {
            String a = scan.nextLine();
            String b = scan.nextLine();

            for(char ah: a.toCharArray())
            {
                for(char bh: b.toCharArray())
                {
                    if(ah == bh)
                    {
                        permutation.add(ah);
                        break;
                    }
                }
            }

            Collections.sort(permutation);
            System.out.println(permutation.toString());
            permutation.clear();
        }
    }
}