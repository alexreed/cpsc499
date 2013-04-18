/**
 * Created with IntelliJ IDEA.
 * User: curtis
 * Date: 2013-01-22
 * Time: 3:45 PM
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

    private Scanner scan = new Scanner(System.in);
    private char[][] letter;
    private String[] Words;
    private ArrayList<Integer> location = new ArrayList<Integer>();
    private int height, width, numOfWords;

    public void run()
    {
        // Take in number for program loop count
        Scanner findInt = new Scanner(scan.nextLine());

        int runs = findInt.nextInt();

        for(int i = 0; i < runs; i++)
        {

            // Skips a blank line
            scan.nextLine();

            // Takes in the grid size and make a grid of that size
            Scanner GridSize = new Scanner(scan.nextLine());

            height = GridSize.nextInt();

            width = GridSize.nextInt();

            //System.out.println(height + " " + width);

            letter = new char[height][width];


            // Fills the grid it all of the letters
            fillTable();

            // Take in number to tell the program on how many words to look for
            findInt = new Scanner(scan.nextLine());
            numOfWords = findInt.nextInt();

            // Fills table with word to look for
            getWords();

            // Finds the word within the table
            findWords();

            // Prints out the locations
            printLocations();

        }

    }

    public void fillTable()
    {

        String Gridline;

        for(int h = 0; h < height; h++)
        {

            Gridline = scan.nextLine().toLowerCase();

            for(int w = 0; w < width; w++)
            {

                letter[h][w] = Gridline.charAt(w);

            }

        }

    }

    public void getWords()
    {

        Words = new String[numOfWords];

        for(int i = 0; i < numOfWords; i++)
        {

            Words[i] = scan.nextLine().toLowerCase();

        }

    }

    public void findWords()
    {

        boolean found = false;

        for(String Word : Words)
        {

            for(int h = 0; h < height; h++)
            {

                for(int w = 0; w < width; w++)
                {

                    if(Word.charAt(0) == letter[h][w])
                    {

                        found = findNextLetters(Word, 1, h, w);

                    }
                    if(found)
                    {

                        location.add(h+1);
                        location.add(w+1);

                        //System.out.println(h+1 + " " + w+1);

                        break;

                    }

                }
                if(found) break;

            }

            found = false;

        }


    }

    public boolean findNextLetters(String Word, int nextCharSpot, int h, int w)
    {

        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // At Top left corner
        else if(h == 0 && w == 0)
        {

            if(Word.charAt(nextCharSpot) == letter[h+1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w+1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h+1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w+1);
            }
            else return false;

        }

        // At Top Right corner
        else if(h == 0 && w == (width - 1))
        {

            if(Word.charAt(nextCharSpot) == letter[h+1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w-1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h+1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w-1);
            }
            else return false;

        }

        // At Bottom Left corner
        else if(h == (height - 1) && w == 0)
        {

            if(Word.charAt(nextCharSpot) == letter[h-1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w+1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h-1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w+1);
            }
            else return false;

        }

        // At Bottom Right corner
        else if(h == (height - 1) && w == (width - 1))
        {

            if(Word.charAt(nextCharSpot) == letter[h-1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w-1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h-1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w-1);
            }
            else return false;

        }

        // Top edge
        else if(h == 0)
        {

            if(Word.charAt(nextCharSpot) == letter[h][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w-1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w+1);
            }else if(Word.charAt(nextCharSpot) == letter[h+1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w);
            }else if(Word.charAt(nextCharSpot) == letter[h+1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w-1);
            }else if(Word.charAt(nextCharSpot) == letter[h+1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w+1);
            }
            else return false;

        }

        // Left edge
        else if(w == 0)
        {

            if(Word.charAt(nextCharSpot) == letter[h-1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h+1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w);
            }else if(Word.charAt(nextCharSpot) == letter[h-1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w+1);
            }else if(Word.charAt(nextCharSpot) == letter[h][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w+1);
            }else if(Word.charAt(nextCharSpot) == letter[h+1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w+1);
            }
            else return false;

        }

        // Right edge
        else if(w == (width - 1))
        {

            if(Word.charAt(nextCharSpot) == letter[h-1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h+1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w);
            }else if(Word.charAt(nextCharSpot) == letter[h-1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w-1);
            }else if(Word.charAt(nextCharSpot) == letter[h][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w-1);
            }else if(Word.charAt(nextCharSpot) == letter[h+1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w-1);
            }
            else return false;

        }

        // Bottom edge
        else if(h == (height - 1))
        {

            if(Word.charAt(nextCharSpot) == letter[h][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w-1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w+1);
            }else if(Word.charAt(nextCharSpot) == letter[h-1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w);
            }else if(Word.charAt(nextCharSpot) == letter[h-1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w-1);
            }else if(Word.charAt(nextCharSpot) == letter[h-1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w+1);
            }
            else return false;

        }

        // In the middle somewhere
        else
        {

            if(Word.charAt(nextCharSpot) == letter[h+1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h+1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w+1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h+1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h+1, w-1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w+1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w-1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h-1][w+1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h, w+1);
            }
            else if(Word.charAt(nextCharSpot) == letter[h-1][w])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w);
            }
            else if(Word.charAt(nextCharSpot) == letter[h-1][w-1])
            {
                return findNextLetters(Word, nextCharSpot + 1, h-1, w-1);
            }
            else return false;

        }

    }

    public void printLocations()
    {

        StringBuilder sb;

        for(int i = 0; i < numOfWords; i++)
        {
            sb = new StringBuilder();

            sb.append(location.get(i*2));
            sb.append(' ');
            sb.append(location.get((i*2)+1));

            System.out.println(sb.toString());

        }

    }
}