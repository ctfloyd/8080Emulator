package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class RAL implements Instruction {

    public static final int CYCLES = 4;
    @Override
    public void operate(Cpu8080 state) {
        Register registerA = state.getRegisterA();
        byte registerData = registerA.getData();
        byte carryAsByte = state.getCarry() ? (byte)1 : (byte)0;
        registerA.setData((byte)((byte)(registerA.getData() << 1) | carryAsByte));
        state.setCarry((registerData & 0x80) == 0x80);
    }
}
