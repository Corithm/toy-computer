package main.hardware.chip.sequential.RAM;

/**
 *
 * The Elements of Computing Systems p. 49
 */
public interface RAM
{
    /**
     * Sets the output value.
     *
     * @param i indexz
     * @param a address
     * @param load the value, false means not load.
     */
    void in(boolean[] i, boolean[] a, boolean load);

    /**
     * Returns the output value.
     *
     * @param a address
     */
    boolean[] out(boolean[] a);
}
