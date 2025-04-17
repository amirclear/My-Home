package src.Device;

public class Thermostat extends Device{
    private int temperature = 20;
    public Thermostat(String name, String protocol) {
        super(name,protocol);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public boolean setProperty(String property, String value) {
        switch (property) {
            case "status":
                setStatus(value);
                return true;
            case "temperature":
                int t = Integer.parseInt(value);
                if (t < 10 || t > 30)
                    throw new IllegalArgumentException("invalid value");
                setTemperature(t);
                return true;
            default:
                throw new IllegalArgumentException("invalid property");
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getStatus() + " " + getTemperature() + "C " + getProtocol();
    }
}
