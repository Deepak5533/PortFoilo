import java.util.Scanner;

class tic_tac_toe {
    public static boolean change(char arr[], int user, char player) {
        if (arr[user - 1] == '-') {
            arr[user - 1] = player;
            return true;
        } else {
            return false;
        }
    }

    public static void display(char arr[]) {
        for (int i = 0; i < arr.length; i++) {
            {
                System.out.print(arr[i]);
                if ((i + 1) % 3 == 0) {
                    System.out.println();
                }
            }

        }

    }

    public static boolean check(char arr[], int user, char player) {
        for (int i = 0; i < 9; i += 3) {
            if (arr[i] == player && arr[i + 1] == player && arr[i + 2] == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (arr[i] == player && arr[i + 3] == player && arr[i + 6] == player) {
                return true;
            }
        }

        if (arr[0] == player && arr[4] == player && arr[8] == player) {
            return true;
        }
        if (arr[2] == player && arr[4] == player && arr[6] == player) {
            return true;
        }
        return false;
    }

    public static boolean isDraw(char arr[]) {
        for (char c : arr) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char arr[] = { '-', '-', '-', '-', '-', '-', '-', '-', '-' };
        char player = 'x';

        for (int i = 0; i < arr.length; i++) {
            Scanner values = new Scanner(System.in);
            System.out.println("enter the number between 1-9");
            int user = values.nextInt();

            if (user < 1 || user > 9) {
                System.out.println("you entered a invalid number");
                i--;
                continue;
            }
            boolean moveSuccessful = change(arr, user, player);
            if (!moveSuccessful) {
                System.out.println("your entered a wrong place");
                i--;
                continue;
            }

            display(arr);
            player = (player == 'x') ? 'o' : 'x';

            if (check(arr, user, player)) {
                System.out.println(player + "is wins");
                break;
            }

            if (isDraw(arr)) {
                System.out.println("The game is a draw!");
                break;

            }

        }

    }

}