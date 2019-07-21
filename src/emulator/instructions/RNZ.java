package emulator.instructions;

import emulator.Emulator;

public class RNZ implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(!state.getZero())
            new RET().operate(state);
    }
}
