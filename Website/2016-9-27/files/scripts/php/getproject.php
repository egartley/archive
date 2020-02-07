<?php

	// make sure page has required CSS file(s)
	echo "
<link rel='stylesheet' type='text/css' href='/files/stylesheets/proj.css'>";

	function getPreConfiguredProj($id) {
		if ($id == "marktplace" || $id == "mrkt") {
			getProj('/projects/marketplace/', 'marketplace', true, 'Currently being revamped! Check back later, please!', 'The Marketplace');
		}
	}

	function getProj($url, $id, $isprerelease, $description, $displayname) {
		// if released or not (available)
		$released = $url != 'none';

		// start html output
		$html = "<h2 class='proj'>" . $displayname;

		// released, but not "fully"
		if ($isprerelease) {
			$html .= " <img id='pre' src='/files/images/pre.gif' alt='pre-release'>";
		}

		// set $linkText to string
		$linkText = '';

		// not released, say coming soon, else say learn more with link to project page
		if ($released) {
			$linkText = '<a href="' . $url . '">Learn more</a>';
		} else {
			$linkText = '<br><br><b>Coming soon!</b>';
		}

		// finish up
		$html .= "</h2>
	<p class='proj'>" . $description . " " . $linkText . "</p><br>";

		echo $html;
	}
?>