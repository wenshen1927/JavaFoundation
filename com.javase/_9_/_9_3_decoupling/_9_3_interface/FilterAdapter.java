package _9_._9_3_decoupling._9_3_interface;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-05 00:02
 */
public class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}

