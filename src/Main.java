import Entities.Player;
import Remnants.HeroRemnant;

public class Main {
    public static void main(String[] args) {
        DungeonMap test = new DungeonMap(5,5);
        while (test.isAnyOpen()) {
            test.GenerateRooms();
        }
        Player player = new Player(test.getSpawnX(), test.getSpawnY(), 1, test.getRooms(), new HeroRemnant());
        while (true) {
            player.move();
        }

    }
}