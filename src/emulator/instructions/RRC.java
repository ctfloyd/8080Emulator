package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RRC implements Instruction{

    @Override
    public void operate(Emulator state){
        Register a = state.getRegisterA();
        byte aDat = a.getData();
        System.out.println("RRC");
        System.out.println(aDat);
        System.out.println(( aDat & 0x01) << 7);
        System.out.println((byte)((byte)((aDat >>> 1) & 0xFF) | ((aDat & 0x01) << 7)));
        System.out.println(aDat >>> 1);
        state.getRegisterA().setData((byte)((byte)((aDat >>> 1) & 0xFF) | ((aDat & 0x01) << 7)));
        state.setCarry((state.getRegisterA().getData() & 0x80) > 0); // carry set depending on last bit
    }

}
