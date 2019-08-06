package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class RLC implements Instruction {


    public static final int CYCLES = 4;
    @Override
    public void operate(Cpu8080 state) {
        Register a = state.getRegisterA();
        byte aDat = (byte)(a.getData() & 0xFF);
        state.getRegisterA().setData((byte)(aDat << 1 | (byte)((aDat >>> 7) >>> 24)));
        state.setCarry((byte)((aDat >>> 7) >>> 24) > 0);
    }

}
