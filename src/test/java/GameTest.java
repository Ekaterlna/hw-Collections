import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Kate", 16);
    Player player2 = new Player(2, "Oleg", 23);
    Player player3 = new Player(2, "Ira", 14);
    Player player4 = new Player(2, "Igor", 23);

    @Test
    public void shouldWinFirstPlayerInRound() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Oleg", "Kate"));
    }

    @Test
    public void shouldWinSecondPlayerInRound() {
        Game game = new Game();
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(2, game.round("Ira", "Igor"));
    }

    @Test
    public void shouldToBeTieBetweenPlayersInRound() {
        Game game = new Game();
        game.register(player2);
        game.register(player4);

        Assertions.assertEquals(0, game.round("Oleg", "Igor"));
    }

    @Test
    public void shouldGenerateExceptionNotRegisteredFirstPlayer() {
        Game game = new Game();
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Helen", "Oleg");
        });
    }

    @Test
    public void shouldGenerateExceptionNotRegisteredSecondPlayer() {
        Game game = new Game();
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Igor", "Olga");
        });
    }
}
