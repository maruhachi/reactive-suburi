package cf.zunda.reactivesuburi.app;

import cf.zunda.reactivesuburi.repository.ReactiveSuburiRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ReactiveSuburiRepository suburiRepository;

    @GetMapping("/mugen")
    public Flux<Integer> react(){
        Stream<Integer> s = Stream.iterate(0, i -> i + 1);
        return  Flux.fromStream(s);
    }

    @GetMapping("/slowly")
    public Flux<Integer> react2(){
        Stream<Integer> is = IntStream.range(0, 100).boxed();
        return  Flux.fromStream(is).delayElements(Duration.ofMillis(500));
    }

    @GetMapping("/reactclient")
    public Flux<String> reactclient(){

        // reactive ver.なWebClientを経由して上のreact2を取得
        return suburiRepository.getReactive();
    }
}
