package Exam1.util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

public class MusicEvent extends ApplicationEvent {
    public MusicEvent(Object source) {
        super(source);
    }

    public void test(){
        System.out.println("已经监听到了");
    }
}
