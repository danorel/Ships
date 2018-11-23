package ships.dev.functional;

class Ships {
    private static final int xLength = 7;
    private static final int yLength = 7;
    private static int counter = 0;

    private char[][] locationCells = new char[xLength][yLength];
    private char[][] locationHits = new char[xLength][yLength];
    public int numberOfHits = 0;

    public void checkHit(int X, int Y){
        if(locationHits[X][Y] == '0'){
            locationHits[X][Y] = 'x';
            if(locationCells[X][Y] == '1'){
                locationCells[X][Y] = '#';
                locationHits[X][Y] = '#';
                numberOfHits++;
                System.out.println("Hit");
            } else {
                System.out.println("Miss");
            }
        } else {
            System.out.println("Repeat ur move");
        }
    }

    public void clearShips() {
        System.out.println();
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if(locationCells[i][j] == '1'){
                    locationCells[i][j] = '0';
                }
            }
        }
    }

    public void clearHits() {
        System.out.println();
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if(locationHits[i][j] == '#'){
                    locationHits[i][j] = '0';
                }
            }
        }
    }

    public void setBoard(char[][] b) {
        for(int i = 0; i < xLength; i++){
            for(int j = 0; j < yLength; j++){
                locationCells[i][j] = b[i][j];
                locationHits[i][j] = b[i][j];
            }
        }
    }

    public void showBoard(){
        System.out.println("Y axis         " + "X axis");
        for(int i = 0; i < xLength; i++){
            for(int j = 0; j < yLength; j++){
                System.out.print(locationCells[i][j] + "|");
            }
            System.out.println("\n");
        }
    }

    public void showHiddenBoard(){
        System.out.println("Y axis         " + "X axis");
        for(int i = 0; i < xLength; i++){
            for(int j = 0; j < yLength; j++){
                System.out.print(locationHits[i][j] + "|");
            }
            System.out.println("\n");
        }
    }

    public void setShip(){
        int X = (int) ((Math.random() * xLength));
        int Y = (int) ((Math.random() * yLength));
        System.out.println("X: "+ X);
        System.out.println("Y: "+ Y);
        System.out.println();
        if(locationCells[X][Y] == '0'){
            locationCells[X][Y] = '1';
            if(Y + 1 >= xLength && locationCells[X][Y-1] == '0' & locationCells[X][Y-2] == '0'){
                locationCells[X][Y-1] = '1';
                locationCells[X][Y-2] = '1';
            } else if(Y - 1 <= 0 && locationCells[X][Y+1] == '0' & locationCells[X][Y+2] == '0'){
                locationCells[X][Y+1] = '1';
                locationCells[X][Y+2] = '1';
            } else if(locationCells[X][Y-1] == '0' & locationCells[X][Y+1] == '0'){
                locationCells[X][Y-1] = '1';
                locationCells[X][Y+1] = '1';
            }
        }
    }
}
