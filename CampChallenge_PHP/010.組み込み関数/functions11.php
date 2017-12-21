<?php
$fp = fopen('phplog.txt', 'a');
if ($fp != false) {
  $stamp = date('Y/m/d H:i:s');
    fwrite($fp, $stamp.'array_push関数を使います。');
}
//array_push関数を使って新しいプロフィールを追加する
$array  =   array(
                array('ID' => 1,
                'Name' => 'fujita',
                'birthday' =>'0616',
                'adress' => 'shinjuku' ),
                array('ID' => 2,
                'Name' => 'suzuki',
                'birthday' =>'0522',
                'adress' => 'kudanshita' ),
                array('ID' => 3,
                'Name' => 'takeuchi',
                'birthday' =>'1201',
                'adress' => 'tokyo' ),
              );
if (array_push ( $array , array('ID' => 4,
'Name' => 'hironaka',
'birthday' =>'0704',
'adress' => 'ichigaya' ))){
  if ($fp != false) {
    $stamp = date('Y/m/d H:i:s');
      fwrite($fp, $stamp.'array_push関数の実行成功');
  }
}else{
  if ($fp != false) {
    $stamp = date('Y/m/d H:i:s');
      fwrite($fp, $stamp.'array_push関数の実行失敗');
  }
}
fclose($fp);
$fp = fopen('phplog.txt', 'r');
if ($fp != false) {
    echo fgets($fp);
    fclose($fp);
}
