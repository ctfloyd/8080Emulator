package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RLC implements Instruction {


    @Override
    public void operate(Emulator state){
        Register a = state.getRegisterA();
        byte highBit = (byte)((a.getData() & 0x80) >> 7);
        byte setByte = (byte)(highBit | (a.getData() << 1));
        state.getRegisterA().setData(setByte);
        state.setCarry((byte)(a.getData() & 0x80) == 0x80);
    }

}
