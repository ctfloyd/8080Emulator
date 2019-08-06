package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class SUI implements Instruction {


    public static final int CYCLES = 7;
    @Override
    public void operate(Cpu8080 state) {
        int res = (state.getRegisterA().getData() & 0xFF) - state.readMemory(state.getPC());
        state.getRegisterA().setData((byte)res);
        state.setSZP(state.getRegisterA());
        state.setCarry((res & 0xFFFFFF00) != 0);
        // TODO: set aux carry
        state.setPC((short) (state.getPC() + 1));
    }
}
