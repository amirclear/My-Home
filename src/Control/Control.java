package src.Control;

import src.Device.Device;
import src.Device.Light;
import src.Device.Thermostat;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Control {
    Map<String, Device> device = new LinkedHashMap<>();
    ArrayList<Rule> rule = new ArrayList<>();

    public void addDevice(String type, String name, String protocol) {
        if (device.containsKey(name)) {
            System.out.println("duplicate device name");
            return;
        }

        if (!(protocol.equals("Bluetooth") || protocol.equals("WiFi"))) {
            System.out.println("invalid input");
            return;
        }

        Device d;
        if(type.equals("light")) {
            d = new Light(name, protocol);
        } else if (type.equals("thermostat")) {
            d = new Thermostat(name, protocol);
        } else {
            System.out.println("invalid input");
            return;
        }

        device.put(name,d);
        System.out.println("device added successfully");
    }

    public void setDevice(String name, String property, String value) {

        if (!device.containsKey(name)) {
            System.out.println("device not found");
            return;
        }
        try {
            device.get(name).setProperty(property, value);
            System.out.println("device updated successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeDevice(String name) {
        if (!device.containsKey(name)) {
            System.out.println("device not found");
            return;
        }
        device.remove(name);
        System.out.println("device removed successfully");

    }

    public void listDevices() {
        if (device.isEmpty()) {
            System.out.println("");
            return;
        }
        for (Device d : device.values()) {
            System.out.println(d.toString());
        }
    }

    public void addRule(String name,String time, String action) {
        if (!device.containsKey(name)) {
            System.out.println("device not found");
            return;
        }

        LocalTime timeChecker;
        try {
            timeChecker = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            System.out.println("invalid time");
            return;
        }

        if (!(action.equals("on") || action.equals("off"))) {
            System.out.println("invalid action");
            return;
        }

        for (Rule r : rule) {
            if (r.getName().equals(name) && r.getTime().equals(time)) {
                System.out.println("duplicate rule");
                return;
            }
        }
        rule.add(new Rule(name, time, action));
        System.out.println("rule added successfully");

    }

    public void checkRule(String time) {

        LocalTime timeChecker;
        try {
            timeChecker = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            System.out.println("invalid time");
            return;
        }

        for (Rule r : rule) {
            if (r.getTime().equals(time)) {
                device.get(r.getName()).setStatus(r.getAction());
            }
        }

        System.out.println("rules checked");
    }

    public void listRule() {
        if (rule.isEmpty()) {
            System.out.println();
            return;
        }
        for (Rule r : rule) {
            System.out.println(r.toString());
        }
    }
}
