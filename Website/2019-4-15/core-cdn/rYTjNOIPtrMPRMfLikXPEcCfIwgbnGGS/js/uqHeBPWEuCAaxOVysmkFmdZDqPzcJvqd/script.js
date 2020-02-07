// http://ditio.net/2010/05/02/javascript-date-difference-calculation/
var DateCalc = {
	inDays: function(d1, d2) {
		var t2 = d2.getTime();
		var t1 = d1.getTime();
		return parseInt((t2 - t1) / 86400000);
	},
	inWeeks: function(d1, d2) {
		var t2 = d2.getTime();
		var t1 = d1.getTime();
		return parseInt((t2 - t1) / 604800000);
	},
	inMonths: function(d1, d2) {
		var d1Y = d1.getFullYear();
		var d2Y = d2.getFullYear();
		var d1M = d1.getMonth();
		var d2M = d2.getMonth();
		return (d2M + 12 * d2Y) - (d1M + 12 * d1Y);
	},
	inYears: function(d1, d2) {
		return d2.getFullYear() - d1.getFullYear();
	}
}

function daysWithoutArrests() {
	return DateCalc.inDays(new Date(2017, 0, 20, 12, 0, 0, 0), new Date());
}

function navigate(url) {
	if (url.indexOf("/") == 0) {
		// link is relative, assume internal navigation
		window.location = "https://egartley.net" + url
	} else {
		// does not start with "/", so it is probably another domain
		window.location = url
	}
}

function submitQuery() {
	// submit query by navigating to search page with the query as parameter
	navigate("/search/?q=" + $('.widget-search-textbox').val())
}

function getURLParameter(parameter) {
	// returns given url "parameter", or null if it is not there
	return decodeURIComponent((new RegExp('[?|&]' + parameter + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
}

function press(e) {
	var key = e.keyCode || e.which;
	if (13 == key) {
		// enter/return was pressed
		submitQuery()
	}
}

$(document).ready(function() {
	if ($('span#days-since-inaug').length) {
		$('span#days-since-inaug').html(daysWithoutArrests());
	}
});