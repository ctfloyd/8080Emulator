package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class ADC implements Instruction {

    public static final int CYCLES = 4; // TODO: memory takes 7 cycles;
    private Register register;


    public ADC(Register register){
        this.register = register;
    }

    public ADC(){

    }

    @Override
    public void operate(Cpu8080 state) {
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
