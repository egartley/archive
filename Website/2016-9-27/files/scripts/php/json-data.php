<?php

	function getData() {

		return json_decode(file_get_contents('http://egartley.net/files/min-data.json'), true);

	}

?>