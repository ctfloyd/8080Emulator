package machine;

import machine.cpu.Cpu8080;
import machine.cpu.instructions.UnimplementedInstructionError;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Machine {

    Cpu8080 state;

    boolean loadedROM;

    double lastInstructionTime;
    double nextInterruptTime;
    int whichInterrupt;

    ScheduledThreadPoolExecutor timer;

    public Machine() {
        this.state = new Cpu8080();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Machine mac = new Machine();
        mac.loadROMFromFile("invaders/cpudiag.bin");
        while (!mac.state.getStopped()) {
            mac.doCPUCycle();
        }

    }

    public long getCurrentTime() {
        return System.nanoTime();
    }

    private void loadROMFromFile(String src) throws FileNotFoundException {
        InputStream in = new FileInputStream(src);
        try {
            in.read(state.getMemory(), 0x100, 64000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        state.getMemory()[368] = 0x7;
        state.getMemory()[0] = (byte) 0xc3;
        state.getMemory()[1] = 0;
        state.getMemory()[2] = 0x01;

        //Skip DAA test
        state.getMemory()[0x59c] = (byte) 0xc3; //JMP
        state.getMemory()[0x59d] = (byte) 0xc2;
        state.getMemory()[0x59e] = (byte) 0x05;
        loadedROM = true;
    }

    private void doCPUCycle() {
        if (lastInstructionTime == 0) {
            lastInstructionTime = getCurrentTime();
            nextInterruptTime = lastInstructionTime + 16000.0f;
            whichInterrupt = 1;
        }
        // TODO: handle interrupts

        double deltaTime = getCurrentTime() - lastInstructionTime;
        int cyclesToCatchUp = (int) (2 * deltaTime);
        int cycles = 0;
        System.out.println("Cycles: " + cyclesToCatchUp);

        while (cyclesToCatchUp > cycles) {
            try {
                cycles += state.parseInstruction();
            } catch (UnimplementedInstructionError unimplementedInstructionError) {
                unimplementedInstructionError.printStackTrace();
            }
        }

        lastInstructionTime = getCurrentTime();
    }
}
