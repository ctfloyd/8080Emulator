package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class ADD implements Instruction {

    private Register register;

    public ADD(Register register){
        this.register = register;
    }

    public ADD(){

    }

    @Override
    public void operate(Emulator state) {
        int registerData;
        if(this.register == null)
        {
            registerData = (state.readMemory(state.getHL()) + (state.getRegisterA().getData() & 0xFF));
        } else {
            registerData = (state.getRegisterA().getData() & 0xFF) + (register.getData() & 0xFF);
        }
        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        state.setCarry((registerData & 0xFFFFFF00) != 0);
        //TODO: Auxillary Carry
    }
}
