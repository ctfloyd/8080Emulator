package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class JMP implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.setPC((short) (state.readMemory(state.getPC() + 1) << 8 | state.readMemory(state.getPC())));
    }
}
