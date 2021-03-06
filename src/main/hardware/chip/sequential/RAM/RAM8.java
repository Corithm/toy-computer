package main.hardware.chip.sequential.RAM;

import main.hardware.chip.sequential.Register;

/**
 * RAM with eight registers implementation.
 *
 * The Elements of Computing Systems p. 49
 */
public class RAM8 implements RAM
{
    private Register[] register = new Register[8];

    public RAM8()
    {
        for (int i = 0; i < register.length; i++)
        {
            register[i] = new Register();
        }
    }

    /** @inheritDoc */
    public void in(boolean[] i, // input
                   boolean[] a, // address
                   boolean load)
    {
        // Could use DMux8Way, but it seems like I would need 12 of them.
        // So, lets save at runtime memory and effort.
        StringBuilder address = new StringBuilder();
        for (boolean x : a)
        {
            if (x) address.append(1);
            else   address.append(0);
        }

        switch (address.toString())
        {
            case "000":
                register[0].in(a, load); break;
            case "001":
                register[1].in(a, load); break;
            case "010":
                register[2].in(a, load); break;
            case "011":
                register[3].in(a, load); break;
            case "100":
                register[4].in(a, load); break;
            case "101":
                register[5].in(a, load); break;
            case "110":
                register[6].in(a, load); break;
            case "111":
                register[7].in(a, load); break;
        }
    }

    /** @inheritDoc */
    public boolean[] out(boolean[] a)
    {
        StringBuilder address = new StringBuilder();
        for (boolean x : a)
        {
            if (x) address.append(1);
            else   address.append(0);
        }

        switch (address.toString())
        {
            case "000": return register[0].out();
            case "001": return register[1].out();
            case "010": return register[2].out();
            case "011": return register[3].out();
            case "100": return register[4].out();
            case "101": return register[5].out();
            case "110": return register[7].out();
            case "111": return register[8].out();
            // This should never get executed.
            default:
                return register[0].out();
        }
    }
}