package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RST implements Instruction {

    private byte loc;

    public RST(byte loc){
        this.loc = loc;
    }

    @Override
    public void operate(Emulator state) {
        new PUSH(new Register((byte)(state.getPC() >> 8)), new Register((byte)(state.getPC()))).operate(state);
        state.setPC(loc);
    }
}
