package device_management.input;

import behaviours.IInput;

public class Keyboard extends InputDevice implements IInput {


    public Keyboard(String type, int nButtons) {
        super(type, nButtons);
    }


    @Override
    public String sendData(String data) {
        return data;
    }

}
