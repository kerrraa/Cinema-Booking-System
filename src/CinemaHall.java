public class CinemaHall {
    private int[][] seats;

    public CinemaHall(int[][] seats){
        this.seats = seats;
    }

    public void showScheme() {
        System.out.println("    1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < seats.length; i++){
            System.out.printf("%2d  ", i + 1);
            for (int j = 0; j < seats[i].length; j++){
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean bookSeat(int row, int col){
        row--;
        col--;
        if (row < 4) {
            if (this.seats[row][col] == 0) {
                this.seats[row][col] = 1;
                return true;
            } else {
                return false;
            }
        } else if (row < 9) {
            int secondCol;

            if (col % 2 == 0){
                secondCol = col + 1;
            } else{
                secondCol = col - 1;
            }

            if (this.seats[row][col] == 0 && this.seats[row][secondCol] == 0) {
                this.seats[row][col] = 1;
                this.seats[row][secondCol] = 1;
                return true;
            } else {
                return false;
            }
        } else {
            int secondCol;

            if (col % 2 == 0){
                secondCol = col + 1;
            } else {
                secondCol = col - 1;
            }

            if (this.seats[row][col] == 0 && this.seats[row][secondCol] == 0) {
                this.seats[row][col] = 1;
                this.seats[row][secondCol] = 1;
                return true;
            } else {
                return false;
            }
        }
    }

    public int calculateRevenue(){
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if(i < 4){
                for (int j = 0; j < 10; j++) {
                    if (this.seats[i][j] == 1){
                        total += 500;
                    }
                }
            } else if (i < 9) {
                for (int j = 0; j < 10; j += 2) {
                    if (this.seats[i][j] == 1){
                        total += 1200;
                    }
                }
            } else {
                for (int j = 0; j < 10; j += 2) {
                    if (this.seats[i][j] == 1){
                        total += 2000;
                    }
                }
            }
        }

        return total;
    }
}
