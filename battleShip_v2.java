import java.util.*;
class battleShip_v2 {
    //battlezone  that's kept hidden from the player
    private String bZone[][][];
    //battlezone that's displayed to the user
    private String PlayerBZone[][][];
    private final int level = 3, row = 10, column = 10;
    battleShip_v2(){
        PlayerBZone = new String[level][column][row];
        bZone = new String[level][column][row];
        //Loading the array with "-" all throughout
        for(int i = 0;i<level; i++)
            for(int j = 0;j<column;j++)
                for(int k = 0;k<row;k++) {
                    PlayerBZone[i][j][k] = "-";
                    bZone[i][j][k] = "-";
                }
    }
    //checks whether there is a ship situated in the given parameters
    public boolean CollisionControl(int length, int l, int r, int c, boolean o){
        if(o) {
            for (int i = r; i < r + length; i++)
                if (bZone[l][c][i].compareTo("-") != 0)
                    return true;
        }
        else {
            for (int i = c; i < c + length; i++)
                if (bZone[l][i][r].compareTo("-") != 0)
                    return true;
        }
         return false;
    }
    //function to populate "ship" in bZone
    public void populate(String ship) {
        Random rand = new Random();
        int randLevel, randRow, randColumn;
        boolean orientation = rand.nextBoolean();
        do {
            do {
                randLevel = rand.nextInt(level);
                randRow = rand.nextInt(row);
                randColumn = rand.nextInt(column);
            } while ((orientation) ? ship.length() + randRow >= row : ship.length() + randColumn >= column);
        } while(CollisionControl(ship.length(), randLevel, randRow, randColumn, orientation));
        if (orientation)
            for (int i = randRow; i < randRow + ship.length(); i++)
                bZone[randLevel][randColumn][i] = "" + ship.charAt(0);
        else
            for (int i = randColumn; i < randColumn + ship.length(); i++)
                bZone[randLevel][i][randRow] = "" + ship.charAt(0);

    }
    //display function
    public void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < level; j++) {
                for (int k = 0; k < column; k++) {
                    System.out.print(PlayerBZone[j][k][i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    /*
    public void Display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < level; j++) {
                for (int k = 0; k < column; k++) {
                    System.out.print(bZone[j][k][i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }*/
    //checks whether the player's choice matches with a ship's coordinates
    public void check(int L, int R, int C){
        String boatIni ="";
        if(bZone[L][C][R].compareTo("-")!=0)
            boatIni = bZone[L][C][R];
        else
            return;
        for(int i = 0;i<level;i++)
            for(int j = 0;j<column;j++)
                for(int k = 0;k<row;k++)
                    if(bZone[i][j][k].compareTo(boatIni) == 0)
                        PlayerBZone[i][j][k] = bZone[i][j][k];
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        battleShip_v2 game0 = new battleShip_v2();
        game0.populate("55555");
        game0.populate("4444");
        game0.populate("333");
        game0.populate("22");
        game0.populate("1");
        //game0.Display();
        System.out.println("Hey, Player! This is a three dimensional battlefield");
        game0.display();
        System.out.println("The field consists "+game0.row+" rows,"+game0.column+" columns and "+game0.level+" levels");
        System.out.println("You have 8 tries to complete the game and there are five ships in total");
        System.out.println("Invalid userdata will result in a loop and the code will not move forward until the user enters a valid value.");
        for(int i = 0; i<8;i++){
            int lev, R, col;
            do {
                System.out.println("Please enter a level: ");
                lev = scn.nextInt();
            }while(lev<1 || lev>3);
            do {
                System.out.println("Please enter a column: ");
                R = scn.nextInt();
            }while(R<1 || R>10);
            do {
                System.out.println("Please enter a row: ");
                col = scn.nextInt();
            }while(col<1 || col>10);
            game0.check(lev-1, R-1, col-1);
            game0.display();
            //game0.Display();
        }
    }
}
