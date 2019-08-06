package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class XRI implements Instruction {

    public static final int CYCLES = 7;
    @Override
    public void operate(Cpu8080 state) {
        state.getRegisterA().setData((byte)(state.getRegisterA().getData() ^ state.readMemory(state.getPC())));
        state.setPC((short)(state.getPC() + 1));
    }
}
