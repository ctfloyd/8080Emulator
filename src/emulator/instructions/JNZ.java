package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class JNZ implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(!state.getZero()){
            new JMP().operate(state);
        } else {
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
