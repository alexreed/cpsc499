/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable
{

    static String ReadLn(int maxLength)
    {  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read until maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or until end of line input
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // construct the bootloader
        myWork.run();            // execute
    }

    public void run()
    {
        new myStuff().run();
    }
}

class myStuff implements Runnable
{
    public void run()
    {
        while(true){

            String num = Main.ReadLn(1000000); Scanner s = new Scanner(num);
            int a = s.nextInt();
            int b = s.nextInt();
            int largeNum = -1;
            int smallNum = -1;

            if(a > b)
            {
            }
            else
            {
                largeNum = a;
                smallNum = b;
                smallNum = a;
                largeNum = b;
            }

            int[] nums = new int[largeNum-smallNum +1];


            for(int i = 0; i<nums.length; i++)
            {
                nums[i] = smallNum + i;
            }

            int largest = 0;

            for(int x: nums)
            {
                int temp = calcLength(x); if(temp > largest)
                largest = temp;
                System.out.println(a + " " + b + " " + largest);
            }
        }
    }

    public static int calcLength(int num)
    {
        int iterations = 1;

        while(num > 1)
        {
            if(num%2 == 0)
            {
                num /= 2;
            }
            else
            {
                num = num * 3 + 1;
            }

            iterations++;
        }

        return iterations;
    }
}

