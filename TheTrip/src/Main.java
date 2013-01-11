import java.io.*;
import java.text.DecimalFormat;
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
            while (length < maxLength){//Read untill maxlength
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
class myStuff implements Runnable
{
    public void run()
    {
        ArrayList<Double> output = new ArrayList();

         while(true)
         {
             int numStudents = Integer.parseInt(Main.ReadLn(1000000));


             double runningTotal = 0;
             double current = 0;
             double average = 0;
             double runningTransfer = 0;

             if(numStudents == 0)
                 break;
             else if(numStudents > 1000)
                 throw new NumberFormatException();
             else if(numStudents % 2 == 0)
                 throw new NumberFormatException();

             ArrayList<Double> expenses = new ArrayList();

             for(int i = 0; i < numStudents; i++)
             {
                current = Double.parseDouble(Main.ReadLn(1000000));
                runningTotal = runningTotal + current;

                expenses.add(current);

                if(current > 10000 ||current < 0)
                    throw new NumberFormatException();
             }

             average = Math.floor((runningTotal*100) / numStudents) / 100;

             for(Double d : expenses)
             {
                if(d.doubleValue() < average)
                {
                    runningTransfer = runningTransfer + (average - d.doubleValue());
                }
             }

             output.add(runningTransfer);
         }


        Iterator it = output.iterator();
        StringBuilder builder = new StringBuilder();

        while(it.hasNext())
        {
            builder.append("$" + String.format("%.2f", it.next()));

            if (it.hasNext()) {
                builder.append("\n");
            }
            else
            {
                break;
            }
        }

        System.out.println(builder);
    }

}
