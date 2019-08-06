package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public interface Instruction {
    void operate(Cpu8080 state);
}
