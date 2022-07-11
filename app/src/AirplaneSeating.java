import java.util.Scanner;

public class AirplaneSeating {

    static int filled = 0;

    public static void main(String[] args) {
        char[][] seats = new char[7][4];
        for (int i = 0; i < 7; i++) {
            seats[i][0] = 'A';
            seats[i][1] = 'B';
            seats[i][2] = 'C';
            seats[i][3] = 'D';
        }

        String seatNumber = " ";
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*==*=*=*=*=*");
        System.out.println("Welcome to the Reina Airline Seating Reservation System.");
        System.out.println("Please enter the seat (Row:1-7 Line:A-D, e.g.- 1A) you wish to reserve.");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*==*=*=*=*=*");
        printSeats(seats);
        Scanner input = new Scanner(System.in);
        seatNumber = input.nextLine().toUpperCase();

        while (filled < 28) {
            if (seatNumber.length() != 2 && seatNumber != "q") {
                System.out.println("Input error. Enter seat to assign (Line:1-7 Row:A-D, e.g.- 1A)");
                seatNumber = input.nextLine().toUpperCase();
            }

            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.toUpperCase().charAt(1) - 'A';
            if (row >= 0 && row <= 6 && col >= 0 && col <= 3) {
                if (seats[row][col] == 'X') {
                    System.out.println("The seat you chose has already been booked.");
                }
                if (seats[row][col] != 'X') {
                    seats[row][col] = 'X';
                    filled++;
                    System.out.println(" ");
                    printSeats(seats);
                }
                if (filled < 28) {
                    System.out.println("Enter seat to assign (Line:1-7 Row:A-D, e.g.- 1A)," + "or q to quit.");
                    seatNumber = input.nextLine();
                    if (seatNumber.equals("q")) {
                        System.out.println("You have left the reservation system.");
                        System.exit(0);
                    }
                }

            } else {
                System.out.println("Input error. Enter seat to assign (Line:1-7 Row:A-D, e.g.- 1A)");
                seatNumber = input.nextLine().toUpperCase();
            }
        }
        input.close();
    }

    private static void printSeats(char[][] seats) {
        System.out.println("Row");
        for (int i = 0; i < seats.length; i++) {
            System.out
                    .println(" " + (i + 1) + "    " + seats[i][0] + " " + seats[i][1] + "  " + seats[i][2]
                            + " " + seats[i][3]);
        }
        int numberOfSeatsAvailable = (28 - filled);
        System.out.println("There are " + numberOfSeatsAvailable + " seats available.");
    }
}