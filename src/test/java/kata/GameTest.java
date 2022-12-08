package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void a_new_game_should_have_0_point() {
        var game = new Game();
        Assertions.assertEquals(0, game.score());
    }

    @Test
    public void score_should_be_equal_to_the_number_of_pins_knocked_down_after_one_roll() {
        var game = new Game();
        var numberOfPinsKnockedDown = 5;
        game.roll(numberOfPinsKnockedDown);
        Assertions.assertEquals(numberOfPinsKnockedDown, game.score());
    }

    @Test
    public void score_should_be_equal_to_the_number_of_pins_knocked_down_after_two_roll() {
        var game = new Game();
        var numberOfPinsKnockedDownAfterFirstRoll = 5;
        game.roll(numberOfPinsKnockedDownAfterFirstRoll);
        var numberOfPinsKnockedDownAfterSecondRoll = 2;
        game.roll(numberOfPinsKnockedDownAfterSecondRoll);
        Assertions.assertEquals(numberOfPinsKnockedDownAfterFirstRoll + numberOfPinsKnockedDownAfterSecondRoll, game.score());
    }

    @Test
    public void a_spare_should_double_the_next_roll() {
        var game = new Game();
        var numberOfPinsKnockedDownAfterFirstRoll = 7;
        game.roll(numberOfPinsKnockedDownAfterFirstRoll);
        var numberOfPinsKnockedDownAfterSecondRoll = 3;
        game.roll(numberOfPinsKnockedDownAfterSecondRoll);
        var numberOfPinsKnockedDownAfterThirdRoll = 2;
        game.roll(numberOfPinsKnockedDownAfterThirdRoll);
        Assertions.assertEquals(numberOfPinsKnockedDownAfterFirstRoll + numberOfPinsKnockedDownAfterSecondRoll + numberOfPinsKnockedDownAfterThirdRoll * 2, game.score());
    }

    @Test
    public void a_strike_should_double_the_next_2_roll() {
        var game = new Game();
        var numberOfPinsKnockedDownAfterFirstRoll = 10;
        game.roll(numberOfPinsKnockedDownAfterFirstRoll);
        var numberOfPinsKnockedDownAfterSecondRoll = 3;
        game.roll(numberOfPinsKnockedDownAfterSecondRoll);
        var numberOfPinsKnockedDownAfterThirdRoll = 2;
        game.roll(numberOfPinsKnockedDownAfterThirdRoll);
        Assertions.assertEquals(numberOfPinsKnockedDownAfterFirstRoll + numberOfPinsKnockedDownAfterSecondRoll * 2 + numberOfPinsKnockedDownAfterThirdRoll * 2, game.score());
    }
}