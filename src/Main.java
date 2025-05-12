public class Main {
    public static void main(String[] args) {
        DungeonMap test = new DungeonMap(5,5);
        while (test.anyOpen()) {
            test.GenerateRooms();
        }
        System.out.println(1);
    }
}