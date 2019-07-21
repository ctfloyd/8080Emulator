package emulator.instructions;

import emulator.Emulator;

public class JNC implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(!state.getCarry()){
            new JMP().operate(state);
        } else {
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
