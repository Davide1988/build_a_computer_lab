package device_management.input;

import behaviours.IInput;

public class Mouse extends InputDevice implements IInput {


    public Mouse(String type, int nButtons) {
        super(type, nButtons);
    }


    @Override
    public String sendData(String data) {
        return data;
    }
}



