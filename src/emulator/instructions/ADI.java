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
        if((registerData & 0xFFFFFF00) > 0)
            state.setCarry(true);
        else
            state.setCarry(false);
        // TODO: set aux carry
        state.setPC((short) (state.getPC() + 1));
    }

    //FFF7
    //FFF5
}
