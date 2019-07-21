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
            tempRegister.setData((byte)(state.getMemory()[state.getHL()] - state.getRegisterA().getData()));
        } else {
            tempRegister.setData((byte)(register.getData() - state.getRegisterA().getData()));
        }

        state.setSZP(tempRegister);
        if(tempRegister.getData() > 0){
            state.setCarry(true);
        } else {
            state.setCarry(false);
        }
    }
}
