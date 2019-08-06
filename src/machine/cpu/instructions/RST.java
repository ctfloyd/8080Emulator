package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class RST implements Instruction {

    public static final int CYCLES = 11;
    private byte loc;

    public RST(byte loc){
        this.loc = loc;
    }

    @Override
    public void operate(Cpu8080 state) {
        new PUSH(new Register((byte)(state.getPC() >> 8)), new Register((byte)(state.getPC()))).operate(state);
        state.setPC(loc);
    }
}
