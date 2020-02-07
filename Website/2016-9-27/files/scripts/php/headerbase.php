<?php

	include_once($_SERVER['DOCUMENT_ROOT']."/files/scripts/php/json-data.php");
	$json = getData();

	$author = $json['site']['author'];
	$baseUrl = $json['site']['base-url'];

	$html = "<meta name='author' content='" . $author . "'>
<base href='" . $baseUrl . "'>
<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1'>
<meta charset='UTF-8'>
<link rel='icon' href='/files/images/favicon.ico' />
<link rel='shortcut icon' href='/files/images/favicon.ico' type='image/x-icon' />
<meta name='application-name' content='egartley.net'/>
<meta name='msapplication-TileColor' content='#33a8ff'/>
<meta name='msapplication-square70x70logo' content='/files/images/msTile_small.png'/>
<meta name='msapplication-square150x150logo' content='/files/images/msTile_medium.png'/>
<meta name='msapplication-wide310x150logo' content='/files/images/msTile_wide.png'/>
<meta name='msapplication-square310x310logo' content='/files/images/msTile_large.png'/>
";

	echo $html;
?>