package _9_._9_3_decoupling._9_3_interface;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-04 23:06
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}

class LowPass extends Filter {
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}

class HighPass extends Filter {
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}

class BandPass extends Filter {
    double lowCutOff,highCutOff;

    public BandPass(double lowCutOff,double highCutOff) {
        this.lowCutOff = lowCutOff;
        this.highCutOff = highCutOff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
