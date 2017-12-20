<?php
function profile(){
  $array  = array('ID' => 1,
                'Name' => 'fujita',
                'birthday' =>'0616',
                'adress' => 'shinjuku' );
  return $array;
}
$profile = profile();
foreach ($profile as $key => $value) {
  # code...
  if($key=="ID"){
    continue;
  }
  echo $key.":".$value."<br>";
}
