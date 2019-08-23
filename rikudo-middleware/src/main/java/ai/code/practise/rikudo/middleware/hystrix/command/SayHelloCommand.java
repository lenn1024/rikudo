package ai.code.practise.rikudo.middleware.hystrix.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixObservableCommand;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import sun.rmi.runtime.Log;

/**
 * HystrixObservableCommand 示例
 */
@Slf4j
public class SayHelloCommand extends HystrixObservableCommand<String> {

    public static void main(String[] args){
        SayHelloCommand sayHelloCommand = new SayHelloCommand(new String[]{"lenn", "niuniu", "pony ma", "jack ma"});

        sayHelloCommand.observe().subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                log.info("Command is compeleted.");
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("Command error occur.");
            }

            @Override
            public void onNext(String s) {
                // process
                log.info(s);
            }
        });
    }


    String[] names;

    protected SayHelloCommand(String[] names) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("StockService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("queryStock")));
        this.names = names;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if(!subscriber.isUnsubscribed()){
                        for(String name: names){
                            subscriber.onNext("Hello " + name + "!");
                        }
                        subscriber.onCompleted();
                    }
                }catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }

    @Override
    protected Observable<String> resumeWithFallback(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello niu niu!");
                subscriber.onCompleted();
            }
        });
    }
}
