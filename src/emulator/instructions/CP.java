package emulator.instructions;

import emulator.Emulator;

public class CP implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(!state.getSign())
            new CALL().operate(state);
        else
            state.setPC((short)(state.getPC() + 2));
    }
}
