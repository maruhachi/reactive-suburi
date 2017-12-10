package cf.zunda.reactivesuburi.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

/**
 * @author ykonno
 * @since 2017/12/10
 */
@RestController
public class ReactiveSuburiController {

    @GetMapping("/react")
    public Flux<Integer> react(){
        Stream<Integer> s = Stream.iterate(0, i -> i + 1);
        return  Flux.fromStream(s);
    }
}
