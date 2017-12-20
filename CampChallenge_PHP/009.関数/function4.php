<?php
function profile(){
  echo "私の名前は藤田です<br>";
  echo "好きな音楽はジャズ<br>";
  echo "趣味はゲームと投資です<br>";
  return true;
}
for ($i=0 ;$i<10; $i++){
  if(profile();==true){
    echo "この処理は正しく実行できました";
  }else{
    echo "正しく実行できませんでした";
  }
}
