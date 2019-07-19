package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class DAD implements Instruction {

    private Register highRegister;
    private Register lowRegister;

    public DAD(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }


    @Override
    public void operate(Emulator state) {
        Register registerH = state.getRegisterH();
        Register registerL = state.getRegisterL();
        int inData = (highRegister.getData() << 8) | lowRegister.getData(); // Combine two reigsters to make 16 bit number
        int hlData = (registerH.getData() << 8) | registerL.getData();
        int sum = inData + hlData;
        registerH.setData((byte)((sum & 0xFF00) >> 8)); // Take the high bits, and make them into a java byte format
        registerL.setData((byte)(sum & 0x00FF));
        state.setCarry((sum & 0xffff0000) != 0); // check if any bits outside of 16-bit range is set, thus there was a carry
    }
}
