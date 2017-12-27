(function() {
    // 上記のようにすることで名前空間を限定できる
  
    'use strict';
 
    // ---------------------------------------------------------------------------
    // 共通変数定義
    // ---------------------------------------------------------------------------
 
    var evtSource = new EventSource("slowly");

    var eventList = document.getElementById("eventList");
 
 
    // ---------------------------------------------------------------------------
    // イベントハンドラ関数定義
    // ---------------------------------------------------------------------------

    /** ServerSentEvent メッセージのハンドラ */
     evtSource.onmessage = function(e) {
       var newElement = document.createElement("li");

       newElement.innerHTML = "message: " + e.data;

       var eventList = document.getElementById("eventList");
       eventList.insertBefore(newElement, eventList.firstChild);
     }

    /**
     * イベントハンドラ
     */
    var handlers = {
 
      /**
       * your button ががクリックされた際のイベントハンドラ。
       * コンソールにクリックされたことをログ出力し、クリック回数をインクリメントする。
       */
      onClickClose: function(e) {
        console.log('clicked');
        evtSource.close();
      }
    };
 
    // ---------------------------------------------------------------------------
    // 初期化関数定義 (ページの DOM ツリー構築完了後に行う初期処理)
    // ---------------------------------------------------------------------------
 
    /**
     * 初期化関数。
     * - イベントハンドラを設定する。
     * - アラートを表示する。
     */
    $(function init() {
 
      // イベントハンドラを設定する。
      $('#close').on('click', handlers.onClickClose);
 
    });
 
 
    // ---------------------------------------------------------------------------
    // 関数定義 (イベントハンドラ以外)
    // ---------------------------------------------------------------------------
 
    // 何かあれば。
 
  }());