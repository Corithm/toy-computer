package main.hardware;

import main.hardware.chip.combinational.Inc16Bit;
import main.tool.Tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 */
public class ROM32K
{
    private BufferedReader input;
    private Hashtable<boolean[], boolean[]> memory = new Hashtable<>();

    /**
     *
     */
    public ROM32K()
    {
        try
        {
            input = new BufferedReader(new FileReader("program.bin"));
            preload();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param address
     * @return
     */
    public boolean[] fetch(boolean[] address) { return memory.get(address); }

    // Read the file and put them into memory.
    private void preload()
    {
        boolean[] address = new boolean[16];
        Inc16Bit inc = new Inc16Bit();

        try
        {
            String line = input.readLine();
            while (line != null)
            {
                memory.put(address, Tools.toBinary(line));

                inc.input(address);
                address = inc.output();

                line = input.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}