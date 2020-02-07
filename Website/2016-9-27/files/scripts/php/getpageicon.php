<?php
	function getPageIcon($parm) {
		$html = "<img src=";
		if ($parm == "default") {
			$html .= "'/files/images/logo.png'";
		} else if ($parm == "marketplace") {
			$html .= "'/files/images/marketplace_icon.png'";
		} else if ($parm == "trump") {
			$html .= "'/files/images/trump.png' style='margin-top:32px'";
		} else {
			$html .= "'" . $parm . "'";
		}
		$html .= " alt='page-icon'>";
		echo $html;
	}
	function getCustomPageIcon($file_name, $width, $height, $style){
		$html = "<img src='/files/images/" . $file_name . "' ";
		if (!$style === 'none') {
			$html .= "style='" . $style . "' ";
		}
		$html .= "width='" . $width . "'";
		if ($height === 'auto') {
			$html .= " height='auto'";
		} else {
			$html .= " height='" . $height . "'";
		}
		$html .= " alt='page-icon'>";
		echo $html;
	}
?>