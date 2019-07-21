package emulator.instructions;

import emulator.Emulator;

public class RNC implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(!state.getCarry())
            new RET().operate(state);
    }
}
