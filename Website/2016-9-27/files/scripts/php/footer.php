<?php
	include_once($_SERVER['DOCUMENT_ROOT']."/files/scripts/php/json-data.php");
	$json = getData();
	$author = $json['site']['base-url-nohttp'];
	$buildItem = $json['site']['build'];
	$footerItems = $json['site']['footer'];
	$dd = getdate(date("U"));
	$year = $dd['year'];

	$html = "<div id='footer'><a title='View copyright information' href='/privacy/'>© " . $year . "</a> • <a title='View the site changelog' href='" . $buildItem['link'] . "'>Build " . $buildItem['string'] . " (" . (string)$buildItem['double'] . ")</a> • ";

	for ($i = 0; $i < count($footerItems); $i++) {
		$item = $footerItems[$i];
		$html .= "<a href='" . $item['link'] . "' title='" . $item['title'] . "'>" . $item['string'] . "</a>";

		if (array_key_exists($i + 1, $footerItems)) {$html .= " • ";}
	}
	$html .= "</div>
";
	echo $html;
?>