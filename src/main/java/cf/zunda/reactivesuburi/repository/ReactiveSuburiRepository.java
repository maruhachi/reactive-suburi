package cf.zunda.reactivesuburi.repository;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author ykonno.
 * @since 2017/12/27.
 */
@Repository
public class ReactiveSuburiRepository {

    public Flux<String> getReactive(){

        // refer: https://goo.gl/bgDNo1
        WebClient client = WebClient.create("http://localhost:8080");

        Flux<String> flux = client.get()
                .uri("/reactive2")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class);

        return flux;
    }
}
