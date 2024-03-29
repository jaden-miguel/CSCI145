public class DungeonMap {

    private int playerXLocation = 1;
    private int playerYLocation = 1;
    private Room[][] room;
    private Player player;
    private String player_icon;

    private final String MAP_NS_WALL = "-";
    private final String MAP_WE_WALL = "|";
    private final String MAP_CORNER_WALL = "+";
    private final String MAP_FLOOR = " ";
    private final String MAP_EXPLORED = "*";

    public DungeonMap(Player player, int rows, int columns){
        this.player = player;
        this.room = new Room[rows][columns];
        for (int i = 0; i < room.length; i++){
            for (int j = 0; j < room[i].length; j++){
                room[i][j] = new Room();
            }
        }

        setDungeonMap(rows, columns);
    }
    public void setDungeonMap(int x, int y){
        
        player_icon = player.getPlayerLogo();
        for (int i = 0; i < room.length; i++){
            for (int j = 0; j < room[i].length; j++){
                if (j== playerXLocation && i == playerYLocation){
                    room[i][j].setMapIcon (player_icon);
                } 
                else if (j == 0 && i == 0||j == 0 && i == y-1||j == room[i].length-1 && i == 0||j == room[i].length-1 && i == y-1){
                    room[i][j].setMapIcon(MAP_CORNER_WALL);
                } 
                else if(j == 0 || j == x-1) {
                    room[i][j].setMapIcon(MAP_WE_WALL);
                } 
                else if(i == 0 || i == y-1) {
                    room[i][j].setMapIcon(MAP_NS_WALL);
                }
                else{
                    room[i][j].setMapIcon(MAP_FLOOR);
                }
            }
        }

    }

    public boolean playerLocationValid(int x, int y){
        if (playerYLocation + y != 0 && playerYLocation + y != room.length-1 && playerXLocation + x != 0 && playerXLocation + x != room[0].length){
            return true;
        }
        else {
            System.out.println("Not a valid direction.");
            return false;
        }
    }
    public void playerLocation(int x, int y){
        room[playerYLocation][playerXLocation].setMapIcon(MAP_EXPLORED);
        playerYLocation += y;
        playerXLocation += x;
        room[playerYLocation][playerXLocation].setMapIcon(player_icon);
        room[playerYLocation][playerXLocation].enter(player);

    }

    public void print(){
        for (int i = 0; i < room.length; i++){
            for (int j = 0; j < room[i].length; j++){
                System.out.print(room[i][j].getMapIcon() + " ");
            }
            System.out.println();
        }
    }
}