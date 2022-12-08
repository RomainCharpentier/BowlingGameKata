package kata;

public class Round {

    private final Roll firstRoll = new Roll();

    private final Roll secondRoll = new Roll();

    public boolean isFinished() {
        return this.firstRoll.getStatus() == RollStatus.LAUNCHED &&
                (this.secondRoll.getStatus() == RollStatus.LAUNCHED || isStrike());
    }

    public boolean isWaiting() {
        return !this.isFinished();
    }

    public void roll(int numberOfPinsKnockedDown) {
        if (this.firstRoll.getStatus() == RollStatus.WAITING) {
            this.firstRoll.roll(numberOfPinsKnockedDown);
        } else {
            this.secondRoll.roll(numberOfPinsKnockedDown);
        }
    }

    public int getSpareOrStrikeBonus() {
        if (isStrike()) {
            return 2;
        } else if (isSpare()) {
            return 1;
        }
        return 0;
    }

    private boolean isStrike() {
        return firstRoll.getNumberOfPinsKnockedDown() == Game.NUMBER_OF_PINS_PER_ROUND;
    }

    private boolean isSpare() {
        return !isStrike() && (firstRoll.getNumberOfPinsKnockedDown() + secondRoll.getNumberOfPinsKnockedDown() == Game.NUMBER_OF_PINS_PER_ROUND);
    }
}
