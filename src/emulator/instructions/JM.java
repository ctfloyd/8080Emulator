package emulator.instructions;

import emulator.Emulator;

public class JM implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getSign()){
            new JMP().operate(state);
        } else {
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
