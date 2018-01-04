package main.gate;

/**
 * Implemens 'OR'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#OR">REFRENCE</a>
 */
public class OrGate extends Gate
{
    private NandGate nand1;
    private NandGate nand2;
    private NandGate nand;

    public OrGate()
    {
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand = new NandGate();
    }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        nand1.in(a, a);
        nand2.in(b, b);
        nand.in(nand1.out(), nand2.out());

        out = nand.out();
    }
}
