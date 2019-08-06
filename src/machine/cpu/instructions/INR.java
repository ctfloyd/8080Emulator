package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class INR implements Instruction {


    public static final int CYCLES = 10;
    private Register register;

    public INR(Register register){
        this.register = register;
    }

    public INR(){

    }

    @Override
    public void operate(Cpu8080 state) {
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
