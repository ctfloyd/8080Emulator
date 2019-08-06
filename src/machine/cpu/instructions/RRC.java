package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class RRC implements Instruction{

    public static final int CYCLES = 4;
    @Override
    public void operate(Cpu8080 state) {
        Register a = state.getRegisterA();
        byte aDat = a.getData();
        state.getRegisterA().setData((byte)((byte)((aDat >>> 1) & 0x7F) | ((aDat & 0x01) << 7)));
        state.setCarry((state.getRegisterA().getData() & 0x80) > 0); // carry set depending on last bit
    }

}
