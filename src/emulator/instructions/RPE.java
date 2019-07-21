package emulator.instructions;

import emulator.Emulator;

public class RPE implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getParity())
            new RET().operate(state);
    }
}
