package emulator.instructions;

import emulator.Emulator;

public class LDA implements Instruction {

    @Override
    public void operate(Emulator state) {
        short addr = (short)((state.readMemory(state.getPC() + 1) << 8) | (state.readMemory(state.getPC())));
        state.getRegisterA().setData((byte)(state.readMemory(addr)));
        state.setPC((short)(state.getPC() + 2));
    }
}
