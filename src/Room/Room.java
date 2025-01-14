package Room;

import java.util.Random;

import Character.Player;

public class Room {
    int number;
    RoomType type;

    public enum RoomType {
        COMBAT, TREASURE, EMPTY, TRAP
    }

    public Room(int number, RoomType type) {
        this.number = number;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public static Room generateRandomRoom(int number) {
        Random random = new Random();
        RoomType type;
        if (random.nextBoolean()) {
            type = RoomType.COMBAT;
        } else {
            RoomType[] eventTypes = {RoomType.TREASURE, RoomType.EMPTY, RoomType.TRAP};
            type = eventTypes[random.nextInt(eventTypes.length)];
        }
        return new Room(number, type);
    }

    public static class roomAction {
    
        public void roomEffect(Player player) {
            player.setHealth(player.getHealth() - 20);
        }

        public void roomEmpty() {
            return;
        }

        public void roomCombat(Player player) {
            return;
        }

        public void roomTreasure(Player player) {
            return;
        }
    }


}