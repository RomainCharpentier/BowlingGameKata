package kata;

public class Roll {
    private int numberOfPinsKnockedDown = 0;

    private RollStatus status = RollStatus.WAITING;

    public void roll(int numberOfPinsKnockedDown) {
        this.numberOfPinsKnockedDown = numberOfPinsKnockedDown;
        this.status = RollStatus.LAUNCHED;
    }

    public int getNumberOfPinsKnockedDown() {
        return numberOfPinsKnockedDown;
    }

    public RollStatus getStatus() {
        return status;
    }
}
