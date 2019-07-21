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
            state.getMemory()[state.getHL()] = (byte)(state.getRegisterA().getData() | state.getMemory()[state.getHL()]);
        } else {
            register.setData((byte)(register.getData() | state.getRegisterA().getData()));
        }

        state.setSZP(state.getRegisterA());
        state.setCarry(false);
    }
}
