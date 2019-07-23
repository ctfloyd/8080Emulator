package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class CMP implements Instruction {

    private Register register;

    public CMP(Register register){
        this.register = register;
    }

    public CMP(){

    }

    @Override
    public void operate(Emulator state) {
        Register tempRegister = new Register();
        if(this.register == null)
        {
            tempRegister.setData((byte)(state.getRegisterA().getData() - state.readMemory(state.getHL())));
        } else {
            tempRegister.setData((byte)(state.getRegisterA().getData() - (register.getData())));
        }
        state.setCarry(tempRegister.getData() < 0);
        state.setSZP(tempRegister);

    }
}
