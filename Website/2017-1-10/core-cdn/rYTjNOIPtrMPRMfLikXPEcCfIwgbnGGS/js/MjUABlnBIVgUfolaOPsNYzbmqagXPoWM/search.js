function buildResult(e) {
	return "<div id='result-container'><a id='title' href='https://egartley.net/" + e.url + "/?via=searchresulttitle'>" + e.title + "</a><br><a href='https://egartley.net/" + e.url + "/?via=searchresulturl'>https://egartley.net/" + e.url + "</a><br>" + e.desc + "</div>"
}

function out(e) {
	$("p#results").html(e).fadeIn()
}

function pushResults(e, t) {
	if (0 == e.length) return void out('No results were found for "' + t + '"');
	if (1 == e.length) return void out(buildResult(e[0]));
	for (var n = "", s = 0; s < e.length; s++) n += buildResult(e[s]), n += "<br><br>";
	out(n)
}

function query(e) {
	if (!pagesStored) {
		for (var t = 0; t < json.pages.length; t++) {
			var n = json.pages[t];
			pages.push({
				terms: n.keywords,
				title: n["display-title"],
				url: n.url,
				desc: n.desc,
				matched: !1
			})
		}
		pagesStored = !0
	}
	for (var s = [], t = 0; t < pages.length; t++) {
		for (var n = pages[t], r = n.terms, o = 0; o < r.length; o++) r[o].toLowerCase().startsWith(e.toLowerCase()) && (n.matched || (s.push(n), n.matched = !0));
		n.matched = !1
	}
	pushResults(s, e), $(".spin").hide()
}

function fetchIndex(e) {
	var t = new XMLHttpRequest,
		n = "https://core-cdn.egartley.net/VLtaWYvbJvGxIWtRVzWXiwQBdZBvBRnE/json/bQBFSuMcCghdoubpglcbfDJtvHrkJlSs/search.json";
	t.onload = function() {
		200 == t.status ? (json = JSON.parse(t.responseText), query(e)) : console.log("There was an error while fetching the search index!")
	}, t.open("GET", n, !0), t.send()
}

function go(e) {
	return $(".spin").show(), $("p#results").hide(), null == json ? void fetchIndex(e) : void query(e)
}

function press(e) {
	var t = e.keyCode || e.which;
	if (13 == t) {
		var n = $("input#query").val();
		"" != n && go(n)
	}
}
var json = null,
	pages = [],
	pagesStored = !1;
$(document).ready(function() {
	var e = gup("q");
	null != e && "" != e && (go(e), $("input#query").val(e))
});