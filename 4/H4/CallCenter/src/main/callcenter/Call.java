package callcenter;

public class Call {

    private long begin;

    private long end;

    public long getBegin() {
        return begin;
    }

    public long getEnd() {
        return end;
    }

    public Call(long begin, long end) {
        this.begin = begin;
        this.end = end;
    }
}
