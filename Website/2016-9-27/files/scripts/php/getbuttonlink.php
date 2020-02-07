<?php

	function getButtonLink($url, $text, $desc) {
		echo "
<div id='button-div'><a href='" . $url . "'><button type='button' style='margin-top:8px'>" . $text . "</button></a>
<p id='button-desc'><b>" . $desc . "</b></p></div>";
	}
	
?>