/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read until maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
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
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{

    private ArrayList<Integer> stack = new ArrayList();

    public void run()
    {
        while(true)
        {
            String input = Main.ReadLn(100000);

            if(input.isEmpty())
                break;

            Scanner scanner = new Scanner(input);

            while(scanner.hasNextInt())
            {
                int flapjack = scanner.nextInt();

                stack.add(0,flapjack);

                System.out.print(flapjack + " ");
            }

            System.out.println();
            perfectStack();
        }
    }

    private void perfectStack()
    {
        for(int flipPointer = 0; flipPointer < stack.size()-1; flipPointer++)
        {
            int greatestPointer = -1;

            for(int greaterThanPointer = flipPointer+1; greaterThanPointer < stack.size();greaterThanPointer++)
            {
                if(stack.get(greaterThanPointer) > stack.get(flipPointer))
                {
                    if(greatestPointer == -1)
                    {
                         greatestPointer = greaterThanPointer;
                    }
                    else
                    {
                          if(stack.get(greaterThanPointer) > stack.get(greatestPointer))
                          {
                              greatestPointer = greaterThanPointer;
                          }
                    }

                }
            }

            if(greatestPointer == stack.size()-1)    //require one flip
            {
                flip(flipPointer+1);

                System.out.print(flipPointer+1 + " ");
            }
            else if(greatestPointer != -1) //require two flip
            {
                flip(greatestPointer+1);

                System.out.print(greatestPointer+1 + " ");

                flip(flipPointer+1);

                System.out.print(flipPointer+1 + " ");
            }
        }

        stack.clear();

        System.out.println(0);
    }

    private void flip(int positionInStack)
    {
        positionInStack = positionInStack-1;

        //2 5 7 6 4 8
        List<Integer> miniStack = stack.subList(positionInStack,stack.size());

        //7 6 4 8
        Collections.reverse(miniStack);

        for(int positionInMiniStack = 0; positionInMiniStack < miniStack.size(); positionInMiniStack++)
        {
             stack.set(positionInStack, miniStack.get(positionInMiniStack));

            positionInStack++;
        }

        //System.out.println(stack.toString());
    }
    // You can insert more classes here if you want.
}
