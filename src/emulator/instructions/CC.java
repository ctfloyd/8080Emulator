package emulator.instructions;

import emulator.Emulator;

public class CC implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getCarry()) {
            new CALL().operate(state);
        } else {
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
