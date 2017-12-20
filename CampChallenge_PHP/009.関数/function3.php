<?php
function multiple($x,$y=5,$z=false){
  $var =$x*$y;
  if($z){
    $var **=2;
  }
  echo $var;
}
multiple(22);
multiple(22,3,true);
