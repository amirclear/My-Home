package src.Device;

public class Light extends Device {
    private int brightness = 50;
    public Light(String name, String protocol) {
        super(name, protocol);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public boolean setProperty(String property, String value) {
        switch (property) {
            case "status":
                setStatus(value);
                return true;
            case "brightness":
                int b = Integer.parseInt(value);
                if (b < 0 || b > 100)
                    throw new IllegalArgumentException("invalid value");
                brightness = b;
                return true;
            default:
                throw new IllegalArgumentException("invalid property");
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getStatus() + " " + getBrightness() + "% " + getProtocol();
    }

}
