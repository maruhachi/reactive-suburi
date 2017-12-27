package cf.zunda.reactivesuburi.app;

import cf.zunda.reactivesuburi.repository.ReactiveSuburiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    /** ものすごい速さでカウントアップした数値をレスポンスしつづける */
    @GetMapping("/mugen")
    public Flux<Integer> react(){
        Stream<Integer> s = Stream.iterate(0, i -> i + 1);
        return  Flux.fromStream(s);
    }

    /** 0.3秒間隔で77までカウントアップ */
    @GetMapping("/slowly")
    public Flux<Integer> react2(){
        System.out.println("ReactiveSuburiController : react2()");

        Stream<Integer> is = IntStream.range(0, 77).boxed();
        return  Flux.fromStream(is).delayElements(Duration.ofMillis(300));
    }

    /** 8080で上がっている自分へRepositoryを経由してFluxな1ルートを通る */
    @GetMapping("/reactclient")
    public Flux<String> reactclient(){

        // reactiveなWebClientを経由して上のreact2を取得
        Flux<String> stringFlux = suburiRepository.getReactive();

        // Fluxの1要素ずつ加工する refer:http://musigma.org/java/2016/11/21/reactor.html
        return stringFlux.flatMap(s -> Mono.defer(() -> Mono.just(s.concat(" fixed. "))));
    }
}
