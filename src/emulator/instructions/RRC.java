package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RRC implements Instruction{

    @Override
    public void operate(Emulator state){
        Register a = state.getRegisterA();
        byte highBit = (byte)((a.getData() & 0x01) << 7);
        byte setByte = (byte)(highBit | (a.getData() >> 1));
        state.setCarry((a.getData() & 1) == 1); // carry set depending on last bit
        state.getRegisterA().setData(setByte);
    }

}
