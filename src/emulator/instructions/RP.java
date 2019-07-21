package emulator.instructions;

import emulator.Emulator;

public class RP implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(!state.getSign())
            new RET().operate(state);
    }
}
