package kata;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Game {

    public static final int NUMBER_OF_PINS_PER_ROUND = 10;

    private static final int MAX_ROUNDS = 10;

    private int rollsBonus = 0;

    private int score = 0;

    private final Round[] rounds = this.initRounds();

    public void roll(int numberOfPinsKnockedDown) {
        var nextRoundToPlay = getNextRoundToPlay();
        if (nextRoundToPlay.isPresent()) {
            var round = nextRoundToPlay.get();
            round.roll(numberOfPinsKnockedDown);
            updateScore(numberOfPinsKnockedDown);
            updateRollsBonus(round);
        }
    }

    private void updateScore(int numberOfPinsKnockedDown) {
        score += numberOfPinsKnockedDown;
        if (rollsBonus > 0) {
            applyRollBonus(numberOfPinsKnockedDown);
        }
    }

    private void applyRollBonus(int numberOfPinsKnockedDown) {
        score += numberOfPinsKnockedDown;
        rollsBonus--;
    }

    private void updateRollsBonus(Round round) {
        if (round.isFinished()) {
            rollsBonus = round.getSpareOrStrikeBonus();
        }
    }

    public int score() {
        return score;
    }

    private Round[] initRounds() {
        return IntStream.range(0, MAX_ROUNDS).mapToObj(num -> new Round()).toArray(Round[]::new);
    }

    private Optional<Round> getNextRoundToPlay() {
        return Arrays.stream(this.rounds).filter(Round::isWaiting).findFirst();
    }
}
