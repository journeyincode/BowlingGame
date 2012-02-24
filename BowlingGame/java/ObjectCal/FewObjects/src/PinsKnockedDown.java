public class PinsKnockedDown {

	public static final PinsKnockedDown STRIKE = new PinsKnockedDown(10);
	public static final PinsKnockedDown NONE = new PinsKnockedDown(0);
	private int count;

	public PinsKnockedDown(PinsKnockedDown pinsKnockedDown) {
		if (pinsKnockedDown != null)
			this.count = pinsKnockedDown.count;
	}
	
	public PinsKnockedDown(int count) {
		this.count = count;
	}
	
	public PinsKnockedDown add(PinsKnockedDown pinsKnockedDown) {
		return new PinsKnockedDown(count + pinsKnockedDown.count);
	}
	
	@Override
	public boolean equals(Object obj) {
        return PinsKnockedDown.class.isInstance(obj) && ((PinsKnockedDown) obj).count == count;
	}
	
	@Override
	public int hashCode() {
		return 31 * count;
	}
}
