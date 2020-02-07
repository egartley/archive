<?php
	// echo's required scripts for a changelog
	function getScripts() {
		echo "
<script type='text/javascript' src='/files/scripts/jquery.rotate.js'></script>
<script type='text/javascript'>function toggletext(textid,showid) {
	if (false == $(textid).is(':visible')) {
		$(showid + ' img').rotate({duration: 450,angle: 180,animateTo:0});
		$(textid).slideDown();
    } else {
    	$(showid + ' img').rotate({duration: 450,angle: 0,animateTo:180});
		$(textid).slideUp();
	}
}
</script>";
	}

	function getChangelog($title, $isPreRelease, $description, $listItems, $id, $showing) {
		$html = "
<div class='change-log'>
	<p><b style='color:#33a8ff'>" . $title . "</b>";
		$showId = $id . "_show";

		// add "pre-release" tag if $isPreRelease is true
		if ($isPreRelease) {
			$html .= " <img title='This is a pre-release build' src='/files/images/pre.gif'>";
		}

		// add toggle "arrow" and start of <ul>
		$html .= " <a id='" . $showId . "' href='javascript:void(0);' onclick=\"toggletext('#" . $id . "', '#" . $showId . "');\"><img id='toggle-img' src='/files/images/plus.gif' width='19' height='19' title='Show/hide this changelog'></a><br>" . $description . "</p>
<ul class='change-log' id='" . $id . "' ";

		// if the this function was called with $showing = false, then hide the changes, now only shows the description
		if ($showing == false) {$html .= "style='display:none;'";}
		$html .= ">";

		// loop through each "change" or list item
		$toAppend = "";
		foreach ($listItems as $item) {
			if (is_array($item)) {
				$toAppend .= "<li>" . $item[0] . "</li>
<ul class='change-log' type='disc'>
	";
				for ($i = 0; $i < count($item[1]); $i++) {
					$toAppend .= "<li>" . $item[1][$i] . "</li>";
				}
				$toAppend .= "
	</ul>";
				continue;
			}
			$toAppend .= "<li>" . $item . "</li>
";
		}
		$toAppend .= "</ul>
</div>";
		$html .= $toAppend;
		echo $html;

		// flip the toggle "arrow" if changes text is hidden, to make rotate function look nicer
		if (!$showing) echo "<script>$('#" . $showId . " img').rotate({angle:180});</script>";
	}
?>