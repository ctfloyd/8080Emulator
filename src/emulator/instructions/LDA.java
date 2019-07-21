package emulator.instructions;

import emulator.Emulator;

public class LDA implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.getRegisterA().setData((byte)(state.readMemory(state.getPC()) << 8 | state.readMemory(state.getPC() + 1)));
        state.setPC((short)(state.getPC() + 2));
    }
}
