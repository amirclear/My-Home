package src.Device;

public abstract class Device {
    private String name;
    private String protocol;
    private String status;

    public Device(String name, String protocol) {
        this.name = name;
        this.protocol = protocol;
        this.status = "off";
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getStatus() {
        return  status;
    }

    public void setStatus(String status) {
        if (!status.equalsIgnoreCase("on") && !status.equalsIgnoreCase("off")) {
            throw new IllegalArgumentException("invalid value");
        }
        this.status = status.toLowerCase();
    }

    public abstract boolean setProperty(String property, String value);

}



