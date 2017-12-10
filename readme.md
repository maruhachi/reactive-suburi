# Reactive すぶり

## 始め方
いつもの[]SpringInitializr](https://start.spring.io/)  
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
`# gradle bootRun`

## reactiveのリクエストを試す
```bash
# curl localhost:8080/reactive -H "accept: text/event-stream"
data:1

data:2

data3
…以降無限
```

* 上記をCtrl+Cすると何故かサーバも一緒に死ぬ