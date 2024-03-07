import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    final static int MAX_NUMBER = 6;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantidade de jogos: ");
        int games = sc.nextInt();
        sc.close();

        int[][] sequence = new int[games][MAX_NUMBER];
        int count = 0;
        do {
            sequence[count] = generateSequence();
            Arrays.sort(sequence[count]);
            count++;
        } while (count < games);

        System.out.println();
        for (int i = 0; i < games; i++) {
            String game = Arrays.stream(sequence[i])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("Jogo " + (i + 1) + ": " + game);
        }
    }

    private static int[] generateSequence() {
        int[] sequence = new int[MAX_NUMBER];
        for (int i = 0; i < MAX_NUMBER; i++) {
            int number = generateNumber();
            if (isRepeated(sequence, number)) {
                i--;
                continue;
            }
            sequence[i] = number;
        }
        return sequence;
    }

    private static int generateNumber() {
        int number = (int) Math.round(Math.random() * 100);
        if (number > 0 && number <= 60) {
            return number;
        }
        return generateNumber();
    }

    private static boolean isRepeated(int[] sequence, int number) {
        for (int i : sequence) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }
}
