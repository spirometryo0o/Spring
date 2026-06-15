package org.example.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dell")
public class Computer {

    // 필드주입
    @Autowired
    private CPU cpu;

    // 생성자 주입
    private RAM ram;

    @Autowired
    public Computer(RAM ram){
        this.ram = ram;
    }

    // 세터주입
    private SSD ssd;

    @Autowired
    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public Computer(CPU cpu, RAM ram, SSD ssd){
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
    }

    public void show() {
        cpu.show();
        ram.show();
        ssd.show();
    }
}
