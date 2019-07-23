package emulator.instructions;

import emulator.Emulator;

public class LHLD implements Instruction{

    @Override
    public void operate(Emulator state) {
        short location = (short)((state.readMemory(state.getPC() + 1) << 8) | (state.readMemory(state.getPC())));
        state.getRegisterL().setData((byte)(state.readMemory(location)));
        state.getRegisterH().setData((byte)(state.readMemory(location + 1)));
        state.setPC((short)(state.getPC() + 2));
    }

}
