package _9_._9_3_decoupling._9_3_interface;

import _9_._9_3_decoupling._9_3_interface.Apply;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-05 00:04
 */
public class FilterProcessor {
    public static void main(String[] args) {
        Waveform wv = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),wv);
        Apply.process(new FilterAdapter(new HighPass(2.0)),wv);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)),wv);
    }
}
