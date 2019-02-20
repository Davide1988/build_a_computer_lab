package device_management.sound;

public class Radio extends SoundDevice {

    public Radio(int maxVolume) {
        super(maxVolume);
    }

    public String tune(String station) {
        return playSound(station);
    };
}
