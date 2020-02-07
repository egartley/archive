<?php
	include_once($_SERVER['DOCUMENT_ROOT']."/files/scripts/php/ismobile.php");

	$html = "<link rel='stylesheet' type='text/css' href='/files/stylesheets/menubar.css'>
<link rel='stylesheet' type='text/css' href='/files/stylesheets/footer.css'>
<link rel='stylesheet' type='text/css' href='/files/stylesheets/style.css'>
";

	if (isMobile()) $html .= "<link rel='stylesheet' type='text/css' href='/files/stylesheets/menubar_mobile.css'>";

	echo $html;
?>