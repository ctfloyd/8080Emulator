package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RC implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getCarry())
            new RET().operate(state);
    }
}
