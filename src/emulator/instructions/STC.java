package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class STC implements Instruction {

    @Override
    public void operate(Emulator state){
       state.setCarry(true);
    }

}
