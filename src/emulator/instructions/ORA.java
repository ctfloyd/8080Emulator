package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class ORA implements Instruction {

    private Register register;

    public ORA(Register register){
        this.register = register;
    }

    public ORA(){

    }

    @Override
    public void operate(Emulator state) {
        if(this.register == null)
        {
            state.getRegisterA().setData((byte)(state.getRegisterA().getData() | state.readMemory(state.getHL())));
        } else {
            state.getRegisterA().setData((byte)(state.getRegisterA().getData() | register.getData()));
        }

        state.setSZP(state.getRegisterA());
        state.setCarry(false);
    }
}
