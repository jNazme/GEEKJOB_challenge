<?php
$fp = fopen('php.txt', 'w');
if ($fp != false) {
    fwrite($fp, '私の名前は藤田篤史です。');
    fclose($fp);
}
