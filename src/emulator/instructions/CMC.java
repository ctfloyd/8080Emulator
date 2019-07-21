package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class CMC implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.setCarry(!state.getCarry());
    }
}
