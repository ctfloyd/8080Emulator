package emulator.instructions;

import emulator.Emulator;

public class CPE implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getParity())
            new CALL().operate(state);
        else
            state.setPC((short)(state.getPC() + 2));
    }
}
