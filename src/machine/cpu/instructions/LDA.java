package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class LDA implements Instruction {

    public static final int CYCLES = 13;

    @Override
    public void operate(Cpu8080 state) {
        short addr = (short)((state.readMemory(state.getPC() + 1) << 8) | (state.readMemory(state.getPC())));
        state.getRegisterA().setData((byte)(state.readMemory(addr)));
        state.setPC((short)(state.getPC() + 2));
    }
}
