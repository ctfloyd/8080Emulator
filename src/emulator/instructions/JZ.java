package emulator.instructions;

import emulator.Emulator;

public class JZ implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getZero()){
            new JMP().operate(state);
        } else {
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
