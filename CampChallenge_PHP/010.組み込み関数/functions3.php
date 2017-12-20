<?php
$stump = mktime(10,0,0,4,11,2016);
$today = date('Y/m/d His',$stump);
echo $today;
