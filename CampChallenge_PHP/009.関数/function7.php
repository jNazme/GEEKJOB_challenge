<?php
function search($profile,$string){
  foreach ($profile as $key => $value) {
    # code...
    if ($profile[$key]["Name"]==$string) {
      # code...
      return $profile[$key];
    }
  }
}
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
$profile = search($array,"suzuki");
foreach ($profile as $key => $value) {
  # code...
  if($key=="ID"){
    continue;
  }
  echo $key.":".$value."<br>";
}
