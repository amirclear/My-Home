package src;
import src.Control.Control;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args ) {
        int numberOfChoice = sc.nextInt();
        sc.nextLine();

        Control Task = new Control();

        for ( int i = 0 ; i < numberOfChoice ; i++) {
            String choice = sc.nextLine();
            String[] spliteOfChoice = choice.split(" ");
            switch (spliteOfChoice[0].trim().toLowerCase()) {
                case "add_device":
                    Task.addDevice(spliteOfChoice[1], spliteOfChoice[2], spliteOfChoice[3]);
                    break;

                case "set_device":
                    Task.setDevice(spliteOfChoice[1], spliteOfChoice[2], spliteOfChoice[3]);
                    break;

                case "remove_device" :
                    Task.removeDevice(spliteOfChoice[1]);
                    break;

                case "list_devices":
                    Task.listDevices();
                    break;

                case "add_rule":
                    Task.addRule(spliteOfChoice[1], spliteOfChoice[2], spliteOfChoice[3]);
                    break;

                case "check_rules":
                    Task.checkRule(spliteOfChoice[1]);
                    break;

                case "list_rules":
                    Task.listRule();
                    break;

                default: {
                    System.out.println("wrong choice");
                }

            }

        }

    }

}
