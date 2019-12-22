package _9_._9_3_decoupling._9_3_interface;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-04 23:04
 */
public class Waveform {
    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}
