public class RollCount implements Comparable<RollCount> {
    private int count;

    public RollCount(int count) {
        this.count = count;
    }

    public void add(RollCount rollCount) {
        count = count + rollCount.count;
    }

    public RollCount increment() {
        return new RollCount(count+1);
    }

    public RollCount incrementByTwo() {
        return new RollCount(count+2);
    }

    public int compareTo(RollCount rollCount) {
        if (count > rollCount.count)
            return 1;

        if (count < rollCount.count)
            return -1;

        return 0;
    }
}
