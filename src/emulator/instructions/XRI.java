package emulator.instructions;

import emulator.Emulator;

public class XRI implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.getRegisterA().setData((byte)(state.getRegisterA().getData() ^ state.readMemory(state.getPC())));
        state.setPC((short)(state.getPC() + 1));
    }
}
