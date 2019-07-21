package emulator.instructions;

import emulator.Emulator;

public class JPE implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getParity())
            new JMP().operate(state);
        else
            state.setPC((short)(state.getPC() + 2));
    }
}
