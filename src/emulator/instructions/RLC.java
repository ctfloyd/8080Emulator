package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RLC implements Instruction {


    @Override
    public void operate(Emulator state){
        Register a = state.getRegisterA();
        byte aDat = (byte)(a.getData() & 0xFF);
        state.getRegisterA().setData((byte)(aDat << 1 | (byte)((aDat >>> 7) >>> 24)));
        state.setCarry((byte)((aDat >>> 7) >>> 24) > 0);
    }

}
