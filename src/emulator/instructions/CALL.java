package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class CALL implements Instruction {

    @Override
    public void operate(Emulator state) {
        if ((short) (state.readMemory(state.getPC() + 1) << 8 | state.readMemory(state.getPC())) == 5) {
            if (state.getRegisterC().getData() == 9) {
                int offset = (state.getRegisterD().getData() << 8 | state.getRegisterE().getData()) & 0xFF;
                int count = 0;
                System.out.println("OFFSET:" + offset);
                while (count < 10000) {
                    char str = (char)state.readMemory(offset + 3 + 0x100);
                    if(str == '$'){
                        break;
                    }
                    System.out.print(str);
                    offset++;
                    count++;
                }
                System.exit(1);
            } else if ((short) (state.readMemory(state.getPC() + 1) << 8 | state.readMemory(state.getPC())) == 0) {
                System.exit(0);
            }
        } else {

//            System.out.println("PUSHING : " + state.getPC());
//            System.out.println(Integer.toBinaryString(state.getPC()));
//            System.out.println("WHICH IS: " + ((state.getPC() & 0xFF00) >> 8) + " AND " + (state.getPC() & 0x00FF) + " AT: " + state.getSP());
            new PUSH(new Register((byte) ((state.getPC() & 0xFF00) >> 8)), new Register((byte)(state.getPC() & 0x00FF))).operate(state);
//            System.out.println("CONFIRM: " + state.getSP());
//            System.out.println("Confirming stack contents:" + state.readMemory(state.getSP() + 1) + " AND: " + state.readMemory(state.getSP()));
            new JMP().operate(state);
        }
    }
}
