import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void register (Player player) {
        players.add(player);
    }

    


}
