<?php
$string = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
$string = str_replace('U', 'う', $string);
$string = str_replace('I', 'い', $string);
echo $string;
