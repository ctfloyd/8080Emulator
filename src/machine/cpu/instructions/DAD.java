package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class DAD implements Instruction {

    public static final int CYCLES = 10;

    private Register highRegister;
    private Register lowRegister;

    public DAD(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    public DAD(short stackPointer){
        this.highRegister = new Register((byte)((stackPointer & 0xFF00) >> 8));
        this.lowRegister = new Register((byte)(stackPointer & 0x00FF));
    }


    @Override
    public void operate(Cpu8080 state) {
        int inData = ((highRegister.getData() & 0xFF) << 8) | (lowRegister.getData() & 0xFF) ; // Combine two reigsters to make 16 bit number
        int hlData = state.getHL();
        int sum = inData + hlData;
        state.getRegisterH().setData((byte)((sum & 0xFF00) >> 8)); // Take the high bits, and make them into a java byte format
        state.getRegisterL().setData((byte)(sum & 0xFF));
        state.setCarry((sum & 0xffff0000) != 0); // check if any bits outside of 16-bit range is set, thus there was a carry
    }
}
