package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class LHLD implements Instruction{

    public static final int CYCLES = 16;

    @Override
    public void operate(Cpu8080 state) {
        short location = (short)((state.readMemory(state.getPC() + 1) << 8) | (state.readMemory(state.getPC())));
        state.getRegisterL().setData((byte)(state.readMemory(location)));
        state.getRegisterH().setData((byte)(state.readMemory(location + 1)));
        state.setPC((short)(state.getPC() + 2));
    }

}
