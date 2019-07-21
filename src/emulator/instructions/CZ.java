package emulator.instructions;

import emulator.Emulator;

public class CZ implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getZero())
            new CALL().operate(state);
        else
            state.setPC((short)(state.getPC() + 2));
    }
}
