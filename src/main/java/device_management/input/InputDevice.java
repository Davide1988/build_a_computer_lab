package device_management.input;

public abstract class InputDevice {

    private String type;
    private int nButtons;

    public InputDevice(String type, int nButtons) {
        this.type = type;
        this.nButtons = nButtons;
    }

    public String getType() {
        return type;
    }

    public int getnButtons() {
        return nButtons;
    }
}
