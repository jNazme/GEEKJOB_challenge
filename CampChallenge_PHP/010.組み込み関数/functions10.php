<?php
$fp = fopen('php.txt', 'r');
if ($fp != false) {
    echo fgets($fp);
    fclose($fp);
}
