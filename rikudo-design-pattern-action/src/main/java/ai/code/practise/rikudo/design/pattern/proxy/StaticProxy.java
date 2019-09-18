package ai.code.practise.rikudo.design.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticProxy implements Subject {

    private Subject subject;

    public StaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void process() {
        log.info("static proxy process start.");
        this.subject.process();
    }

    public static void main(String[] args){
        Subject subject = new StaticProxy(new RealSubject());
        subject.process();
    }
}
