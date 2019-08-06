package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class RAR implements Instruction {

    public static final int CYCLES = 4;
    @Override
    public void operate(Cpu8080 state) {
        Register registerA = state.getRegisterA();
        byte registerData = registerA.getData();
        byte carryAsByte = (byte)((state.getCarry() ? (byte)1 : (byte)0) << 7);
        registerA.setData((byte)((byte)(registerA.getData() >> 1) | carryAsByte));
        state.setCarry((registerData & 0x1) == 0x1);
    }
}
