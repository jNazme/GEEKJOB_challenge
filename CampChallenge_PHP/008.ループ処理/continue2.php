<?php
$array = array(1,2,3,4,5,6,7,8,9);
$var = 0;

foreach ($array as $valueColumn) {
  if($valueColumn == 7){
    break;
  }
  foreach ( $array as  $valueRow) {
    # code...
    echo $valueRow*$valueColumn.",";
  }
  echo "<br>";
}
