package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class CPI implements Instruction {

    public static final int CYCLES = 7;

    @Override
    public void operate(Cpu8080 state) {
        int result = (byte) (state.getRegisterA().getData() - state.readMemory(state.getPC()));
        state.setSZP(new Register((byte) result));
        state.setCarry((state.getRegisterA().getData() & 0xFF) < state.readMemory(state.getPC()));
        state.setPC((short) (state.getPC() + 1));
    }
}
