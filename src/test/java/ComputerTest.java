import behaviours.IInput;
import behaviours.IOutput;
import device_management.Computer;
import device_management.input.Keyboard;
import device_management.input.Mouse;
import device_management.video.Monitor;
import device_management.print.Printer;
import device_management.sound.Speaker;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ComputerTest {

    Computer computer;
    Monitor monitor;
    Keyboard keyboard;
    Mouse mouse;


    @Before
    public void before() {
        monitor = new Monitor(22, 786432);
        keyboard = new Keyboard("Wired", 104);

        computer = new Computer(8, 512, monitor, keyboard);
    }

    @Test
    public void hasRam() {
        assertEquals(8, computer.getRam());
    }

    @Test
    public void hasHddSize() {
        assertEquals(512, computer.getHddSize());
    }

//    @Test
//    public void hasMonitor() {
//        assertEquals(22, computer.getMonitor().getScreenSize());
//        assertEquals(786432, computer.getMonitor().getPixels());
//    }

    @Test
    public void hasOutputDevice() {
        IOutput outputDevice = computer.getOutputDevice();
        assertNotNull(outputDevice);
    }

    @Test
    public void hasInputDevice() {
        IInput inputDevice = computer.getInputDevice();
        assertNotNull(inputDevice);
    }


    @Test
    public void canOutputData() {
        assertEquals("space invaders is now on screen", computer.outputData("space invaders"));
    }

    @Test
    public void canInputDataFromKeyboard() {
        assertEquals("neckbeard", computer.inputData("neckbeard"));
        assertEquals("neckbeard", computer.outputDataStream());
    }

    @Test
    public void canInputDataFromMouse(){
        Mouse mouse =  new Mouse("wireless", 3);
        computer = new Computer(8, 512, monitor, mouse);
        assertEquals("click", computer.inputData("click"));
    }


    @Test
    public void canOutputDataViaPrinter(){
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        keyboard = new Keyboard("Wired", 104);
        Computer computer = new Computer(8, 512, printer, keyboard);
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

    @Test
    public void canOutputDataViaSpeaker(){
        Speaker speaker = new Speaker(100);
        Computer computer = new Computer(8, 512, speaker, keyboard);
        assertEquals("playing: Beep!", computer.outputData("Beep!"));
    }

    @Test
    public void canSetOutputDevice(){
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        computer.setOutputDevice(printer);
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

}
