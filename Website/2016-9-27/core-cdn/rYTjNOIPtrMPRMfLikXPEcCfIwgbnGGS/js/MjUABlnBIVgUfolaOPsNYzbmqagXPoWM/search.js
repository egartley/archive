var json = null;
var pages = [];
var pagesStored = false;

function buildResult(match) {
	return "<div id='result-container'><a href='https://egartley.net/" + match.url + "'>" + match.title + "</a><br>https://egartley.net/" + match.url + "<br>" + match.desc + "</div>";
}

function out(s) {
	$('p#results').html(s).fadeIn('fast')
}

function pushResults(matches, term) {
	if (matches.length == 0) {
		out('No results were found for \"' + term + '\"!');
		return;
	}
	// there were matches, display them
	if (matches.length == 1) {
		// only one match, don't bother with for loop
		out(buildResult(matches[0]));
		return;
	} else {
		// more than one match, cycle through them
		var s = "";
		for (var i = 0; i < matches.length; i++) {
			s += buildResult(matches[i]);
			s += '<br><br>'
		}
		out(s)
	}
}

function query(term) {
	// build pages index if not already built
	if (!pagesStored) {
		for (var i = 0; i < json['pages'].length; i++) {
			var p = json['pages'][i];
			pages.push({
				terms: p['keywords'],
				title: p['display-title'],
				url: p['url'],
				matched: false
			})
		}
		pagesStored = true
	}
	// search through keywords with query
	var matches = [];
	for (var i = 0; i < pages.length; i++) {
		var p = pages[i];
		var keywords = p.terms;
		for (var ii = 0; ii < keywords.length; ii++) {
			if (keywords[ii].indexOf(term) != -1) {
				// match found, check if already matched
				if (!p.matched) {
					// not already matched, push to matches
					matches.push(p);
					p.matched = true
				}
			}
		}
		// ready for next query
		p.matched = false;
	}
	console.log("Matches found for \""+term+"\": "+matches.length),pushResults(matches, term),$('.spin').hide()
}

function fetchIndex(term) {
	var xhttp = new XMLHttpRequest();
	var url = "https://core-cdn.egartley.net/VLtaWYvbJvGxIWtRVzWXiwQBdZBvBRnE/json/bQBFSuMcCghdoubpglcbfDJtvHrkJlSs/search.json";
	xhttp.onload = function() {
		if (xhttp.status == 200) {
			json = JSON.parse(xhttp.responseText), query(term)
		} else {
			console.log('There was an error while fetching the search index!')
		}
	}
	xhttp.open('GET', url, true);
	xhttp.send()
}

function go(term) {
	$('.spin').show();
	$('p#results').hide();
	if (json == null) {
		// search index hasn't been fetched yet, fetch with ajax
		fetchIndex(term)
		return;
	}
	query(term)
}

function s() {
	alert('Working on it!')
}

function press(e) {
	var key = e.keyCode || e.which;
	if (key == 13) {
		var v = $('input#query').val();
		if (v != "") {
			go(v)
		}
	}
}
$(document).ready(function(){var q=gup('q');if(q!=null&&q!=""){go(q),$('input#query').val(q)}})