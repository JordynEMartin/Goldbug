// GoldBug.java
// 4/30/18
//
// This program will count the frequency of how many times a character appeared
// in a text file and then print them in decreasing order.

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class GoldBug
{
    public static void main(String[] args) throws IOException 
    {
        final int NUM_LETTERS = 26;
        String file = args[0];
        FreqObject[] freq = new FreqObject[NUM_LETTERS];

        if (args.length != 1)
        {
            System.out.println("Usage: java GoldBug " + file);
            System.exit(1);
        }

        for (int i = 0; i < NUM_LETTERS; i++)
            freq[i] = new FreqObject((char)('A' + i));

        try (Scanner fileScan = new Scanner(new File(file)))
        {
            while (fileScan.hasNext())
            {
                String line = fileScan.nextLine().toUpperCase();

                for (int i = 0; i < line.length(); i++)
                {
                    int index = line.charAt(i) - 'A';

                    if (0 <= index && index < NUM_LETTERS)
                        freq[index].increment();
                }
            }
            Arrays.sort(freq);

            for (int i = 0; i < NUM_LETTERS; i++)
            {
                if (freq[i].getCount() >= 1)
                    System.out.println(freq[i]);
            }
        }

        catch (IOException e)
        {
            System.err.println(e);
        }
        
    }
}



                
                



