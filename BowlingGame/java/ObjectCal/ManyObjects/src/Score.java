public class Score extends Pins {
    public Score(int hit) {
        super(hit);
    }

    @Override
    public boolean equals(Object obj) {
        return Score.class.isInstance(obj) && ((Score) obj).hit == hit;
    }
}
