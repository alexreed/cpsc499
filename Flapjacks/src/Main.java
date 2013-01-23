/**
 * Created with IntelliJ IDEA.
 * User: curtis
 * Date: 2013-01-22
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */


/*
 * Main.java
 *  java program model for www.programming-challenges.com
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

    private ArrayList<Integer> stack = new ArrayList();
    private ArrayList<Integer> flipLocations = new ArrayList();
    String OrigLine = null;

    public void run()
    {

        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine())
        {

            OrigLine  = scan.nextLine();

            Scanner line = new Scanner(OrigLine);

            while(line.hasNextInt())
            {

                stack.add(0,line.nextInt());

            }

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

                flipLocations.add(flipPointer+1);
            }
            else if(greatestPointer != -1) //require two flip
            {
                flip(greatestPointer+1);

                flipLocations.add(greatestPointer+1);

                flip(flipPointer+1);

                flipLocations.add(flipPointer+1);
            }
        }

        System.out.println(OrigLine);
        printFlipList(flipLocations);

        flipLocations.clear();
        stack.clear();
        OrigLine = null;

    }

    private void printFlipList(ArrayList<Integer> list)
    {

        StringBuilder string = new StringBuilder();

        for(Integer listIndex : list)
        {

            string.append(listIndex);
            string.append(" ");


        }

        string.append(0);

        System.out.println(string);

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

    }
}