## W3C ch.2


### 可安裝的網頁app

* 最常使用 manifest 的 case 是給使用者安裝一個 web app，
（還有其他 case 可以從 manifest 去做，
例如 [web share target](https://wicg.github.io/web-share-target/#usage-example)、
[Google Cloud Messaging](https://developers.google.com/cloud-messaging)，
manifest 中文意思有"貨單"，之前我一直誤解他是一個只會應用在 PWA 的 json，
錯了! 只要 user agent -以下簡稱 UA- 有支援其他 wab application 都可以用這個表單。）
* `top-level browsing context` : 類似網頁樹狀圖的 root，往上沒有親代 parent browsing context。
* 安裝後的 web app 讓使用者難以區別 native applications 和 web app 的差異。
而因為 manifest 裡面設定的值，也能讓 web app 與一般書籤之間做出差別，
比如沒有 manifest，點擊 Google Chrome 右上角選單-> add to Home screen，
產生的只會是一個一般書籤。啟動 web app 時 UA 會在讀取 start URL 之前，
先把 manifest 裡面要求的東西應用在 top-level browsing context，例如做出改變 dispaly mode 等操作
* 在任何時候 UA 有 **可能** 去執行 **[steps to determine installability of the document]** 
（document的可安裝性的確認步驟 的程式碼）
	1. 把 manifest、manifest URL 丟進去 [obtaining the manifest](https://www.w3.org/TR/appmanifest/#dfn-obtaining-the-manifest) 這套流程獲取結果。（原文的表達方式像是 用英文這個語言來寫的程式碼）
	2. 如果發生錯誤，UA 有 **可能** 會把 top-level browsing context Document's metadata 的值作為備案填進去 manifest 裡面，然後評斷 [document](https://dom.spec.whatwg.org/#document) 是可以安裝的；或者 直接認定 document 是不可以安裝的。
	3. 如果沒有發生錯誤， document 有可能被認為可以安裝的。（**等於一切都取決於使用者用的 UA ，即瀏覽器**）
	
	
[steps to determine installability of the document]: https://www.w3.org/TR/appmanifest/#dfn-steps-to-determine-installability-of-the-document


### 2.4 觸發 install web application 的方法

* 使用者手動透過 UA 的 UI 添加（例如 chrome 右上角選單 - add to Home screen）
* **automated install prompt**： 由 UA 自動提示安裝，需要滿足 [installability signals]的條件，Google 釋出的[教學影片](https://youtu.be/yQhFmPExcbs) 裡面有提到使用者在這個網站上有比較頻繁的互動後，符合條件([installability signals])後，UA 會跳出安裝提示。
* **site-triggered install prompt**： 透過編程的方式讓 UA 提出安裝要求，有可能因為 UA 的權限設定被擋下來，需要滿足 [installability signals]的條件。

[installability signals]: https://www.w3.org/TR/appmanifest/#dfn-installability-signal

在任何情況下，如果 document 不能安裝（跑過 [steps to determine installability of the document] 這段程式碼的結果），UA 就不能跳出安裝提示，
任何安裝之前必須由 UA 跳出是否安裝的提示，才可以安裝。

（接下來的 2.4 和 2,5 應該是寫給 UA 開發人員看的，跳過）


### 2.6 Installability signals (This section is non-normative)

* 有 `<link rel="manifest" href="manifest.json">`，而且 manifest.json 裡最少有 name 這個 member，和一個合適的 icon。
* 必須 served 在 HTTPS （原文只有說 secure network connection，除了HTTPS還有沒有其他種我不知道XD）
* 有 sensible content security policy
* 有做適應於不同螢幕大小的設置（RWD）
* 可以離線工作
* 使用者會在某一長度的時間內重複使用
* 被使用者標記為 *可以信任 / 重視* 的，例如將網站加入書籤。

上述並不詳盡，而且可能無法適用於所有 UA，如何使用這些信號是 UA 的 implementers 在決定的。（ **依舊是取決於使用者用的 UA** ）
