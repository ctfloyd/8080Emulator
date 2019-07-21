package emulator.instructions;

import emulator.Emulator;

public class RZ implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getZero())
            new RET().operate(state);
    }
}
