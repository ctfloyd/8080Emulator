package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class ADC implements Instruction {

    private Register register;

    public ADC(Register register){
        this.register = register;
    }

    public ADC(){

    }

    @Override
    public void operate(Emulator state) {
        byte carryByte = state.getCarry() ? (byte)1 : (byte)0;
        int registerData;
        if(this.register == null)
        {
            registerData = (state.getRegisterA().getData() & 0xFF) + state.readMemory(state.getHL()) + carryByte;
        } else {
            registerData = (state.getRegisterA().getData() & 0xFF) + (register.getData() & 0xFF) + carryByte;
        }
        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        state.setCarry((registerData & 0xFFFFFF00) != 0);
        //TODO: Auxillary Carry
    }
}
