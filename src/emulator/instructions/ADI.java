package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class ADI implements Instruction {

    @Override
    public void operate(Emulator state) {
        int registerData = ((short)state.getRegisterA().getData() &0xFFFF)+ (short)(state.readMemory(state.getPC()) & 0xFFFF);
        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        System.out.println(Integer.toBinaryString(registerData));
        state.setCarry((registerData & 0xFFFFFF00) > 0);
        // TODO: set aux carry
        state.setPC((short) (state.getPC() + 1));
    }

    //FFF7
    //FFF5
}
