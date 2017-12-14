package cf.zunda.reactivesuburi.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ykonno
 * @since 2017/12/10
 */
@RestController
public class ReactiveSuburiController {

    @GetMapping("/mugen")
    public Flux<Integer> react(){
        Stream<Integer> s = Stream.iterate(0, i -> i + 1);
        return  Flux.fromStream(s);
    }

    @GetMapping("/slowly")
    public Flux<Integer> react2(){
        Stream<Integer> is = IntStream.rangeClosed(0, 100).boxed();
        return  Flux.fromStream(is).delayElements(Duration.ofMillis(500));
    }
}
