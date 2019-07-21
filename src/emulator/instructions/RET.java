package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RET implements Instruction {

    @Override
    public void operate(Emulator state) {
        System.out.println("Stack Pointer: " + state.getSP());

        Register registerHigh = new Register();
        Register registerLow = new Register();
        new POP(registerHigh, registerLow).operate(state);
        System.out.println(registerHigh.getData() + " : " + registerLow.getData());
        state.setPC((short)((registerHigh.getData() & 0xFF) << 8 | (registerLow.getData() & 0xFF) + 1));
    }
}
