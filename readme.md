# Reactive すぶり

## 始め方
いつもの[SpringInitializr](https://start.spring.io/) 

入れた依存
* コアモジュール
  * Reactive web
  * Reactive MongoDB
  * Thymeleaf
* 開発用
  * DevTools
  * Actuator 
  * lombok
  
## How to boot
`# ./gradlew bootRun`

## reactiveのreq/resを試す
**cURLから**
```bash
# curl localhost:8080/mugen -H "accept: text/event-stream"
data:1

data:2

data3
…以降無限
```

**WebBrowserから**  
[http://localhost:8080/reactive](http://localhost:8080/reactive)にアクセスすると確認出来ます。

## reactiveなWebClientを試す
[Client] -> [suburi:8090] -> [suburi:8080] なFluxの流れ

**起動方法**
```bash
$ ./gradlew bootJar
(ターミナルその1)
$ java -jar ./build/libs/reactive-suburi-0.0.1-SNAPSHOT.jar
(ターミナルその2)
$ java -jar ./build/libs/reactive-suburi-0.0.1-SNAPSHOT.jar --spring.profiles.active=client

$ curl localhost:8090/reactclient -H "accept: text/event-stream"
  data:0 fixed.
  
  data:1 fixed.
…以下77まで
```

各データ(0,1,..)に「fixed」という編集を加えてレスポンスしています。  

標準出力にてしっかりWebClientが8080にあがっている/slowlyへ  
リクエストを飛ばしているのがわかります。