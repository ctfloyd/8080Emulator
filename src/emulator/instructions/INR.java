package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class INR implements Instruction {

    private Register register;

    public INR(Register register){
        this.register = register;
    }

    public INR(){

    }

    @Override
    public void operate(Emulator state){
        if(register == null){
            int location = state.getHL();
            state.getMemory()[location] += 1;
            state.setSZP(new Register(state.getMemory()[location]));
        } else {
            register.setData((byte) (register.getData() + 1));
            state.setSZP(register);
        }
    }

}
