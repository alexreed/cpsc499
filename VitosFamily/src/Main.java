/*
 * Main.java
 * Program Name: Vito's Family
 * UVA: 10041
 * PC: 110401
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
        int numberOfCases = scan.nextInt();

        while(numberOfCases != 0)
        {
            Scanner line = new Scanner(scan.nextLine());

            System.out.println(line.toString());

            ArrayList<Integer> streetNumbers = new ArrayList();

            int minimalSumOfDistances = 0;

            while (line.hasNextInt())
            {
                int numberOfRelatives = line.nextInt();

                while(numberOfRelatives != 0)
                {
                    if(line.hasNextInt())
                        streetNumbers.add(line.nextInt());
                }

                numberOfRelatives--;
            }

            for (int i = 0; i < streetNumbers.size(); i++)
            {
                int sumOfDistances = 0;

                for (int j = i+1; j < streetNumbers.size(); j++)
                {
                    sumOfDistances += Math.abs(streetNumbers.get(i) - streetNumbers.get(j));
                }

                minimalSumOfDistances = Math.min(minimalSumOfDistances,sumOfDistances);
            }

            System.out.println(minimalSumOfDistances);

            numberOfCases--;
        }
    }
}