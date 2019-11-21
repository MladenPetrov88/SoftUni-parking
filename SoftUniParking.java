import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, String> nameID = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] temp = scanner.nextLine().split("\\s+");


            if (temp[0].equals("register")) {
                if (!nameID.containsKey(temp[1])) {
                    nameID.put(temp[1], temp[2]);
                    System.out.printf("%s registered %s successfully%n", temp[1], temp[2]);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", temp[2]);
                }
            }

            else if (temp[0].equals("unregister")) {
                if (nameID.containsKey(temp[1])) {
                    nameID.remove(temp[1]);
                    System.out.printf("%s unregistered successfully%n", temp[1]);
                } else {
                    System.out.printf("ERROR: user %s not found%n", temp[1]);
                }
            }
        }

        for (Map.Entry<String, String> entry : nameID.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }

    }
}
