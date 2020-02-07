<?php
	include_once($_SERVER['DOCUMENT_ROOT']."/files/scripts/php/json-data.php");
	function getMenuBar($currentid) {
		$json = getData(); $menuBarItems = $json['site']['menu-bar']; $corestring = "";
		foreach ($menuBarItems as &$item){$link = $item['link']; $string = $item['string']; $id = $item['id']; $addition = ""; if ($currentid == strtolower($id)) {$addition = "<li id='" . $id . "' class='current'><a href='" . $link . "' class='current'>" . $string . "</a></li>"; } else {$addition = "<li><a id='" . $id . "' href='" . $link . "' class='item'>" . $string . "</a></li>"; } $corestring .= $addition; unset($item); unset($addition); unset($link); unset($string); unset($id);}
		echo "
<script type='text/javascript'>function toggle() {
	if (false == $('#more-div').is(':visible')) {
		$('#more-div').slideDown();
    } else {
		$('#more-div').slideUp();
	}
}
</script>";
		echo "
<ul id='bar-items'>" . $corestring . "<a id='more' onclick='' href='javascript:void(0);'><svg id='more' style='float:right;margin-top:10px;margin-right:16px' height='36px' version='1.1' viewBox='0 0 24 24' width='36px' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'><title/><desc/><defs/><g fill='none' fill-rule='evenodd' id='miu' stroke='none' stroke-width='1'><g id='Artboard-1' transform='translate(-251.000000, -479.000000)'><g id='slice' transform='translate(215.000000, 119.000000)'/><path d='M254.5,493 C255.880712,493 257,491.880712 257,490.5 C257,489.119288 255.880712,488 254.5,488 C253.119288,488 252,489.119288 252,490.5 C252,491.880712 253.119288,493 254.5,493 L254.5,493 Z M263,493 C264.380712,493 265.5,491.880712 265.5,490.5 C265.5,489.119288 264.380712,488 263,488 C261.619288,488 260.5,489.119288 260.5,490.5 C260.5,491.880712 261.619288,493 263,493 L263,493 Z M271.5,493 C272.880712,493 274,491.880712 274,490.5 C274,489.119288 272.880712,488 271.5,488 C270.119288,488 269,489.119288 269,490.5 C269,491.880712 270.119288,493 271.5,493 L271.5,493 Z'/></g></g></svg></a></ul><div id='more-div' style='display:none'>test</div>";
	}
?>