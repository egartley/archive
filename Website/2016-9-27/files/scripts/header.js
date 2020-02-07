function go(e){isMobile()&&(mobile="<link rel='stylesheet' type='text/css' href='/files/stylesheets/mobile.css'>"),$("head").append('<base href="'+e.site["base-url"]+'" /><meta name="author" content="'+e.site.author+'" /><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1" /><meta name="application-name" content="egartley.net" /><meta name="msapplication-TileColor" content="#33a8ff" /><meta name="msapplication-square70x70logo" content="/files/images/msTile_small.png" /><meta name="msapplication-square150x150logo" content="/files/images/msTile_medium.png" /><meta name="msapplication-wide310x150logo" content="/files/images/msTile_wide.png" /><meta name="msapplication-square310x310logo" content="/files/images/msTile_large.png" /><link rel="apple-touch-icon" href="/files/images/apple-touch-icon.png" /><link rel="apple-touch-icon" sizes="57x57" href="/files/images/apple-touch-icon-57x57.png" /><link rel="apple-touch-icon" sizes="72x72" href="/files/images/apple-touch-icon-72x72.png" /><link rel="apple-touch-icon" sizes="76x76" href="/files/images/apple-touch-icon-76x76.png" /><link rel="apple-touch-icon" sizes="114x114" href="/files/images/apple-touch-icon-114x114.png" /><link rel="apple-touch-icon" sizes="120x120" href="/files/images/apple-touch-icon-120x120.png" /><link rel="apple-touch-icon" sizes="144x144" href="/files/images/apple-touch-icon-144x144.png" /><link rel="apple-touch-icon" sizes="152x152" href="/files/images/apple-touch-icon-152x152.png" /><link rel="apple-touch-icon" sizes="180x180" href="/files/images/apple-touch-icon-180x180.png" /><link rel="stylesheet" type="text/css" href="/files/stylesheets/style.css">'+mobile),menubar(e),footer(e),sizecheck(),$("h2").each(function(){var e=$(this).text();$(this).html(e.toUpperCase())})}function getData(){var e={site:{build:{major:"152",minor:63},"menu-bar":[{string:"<img src='/files/images/home.svg' style='width:auto;height:auto;margin-bottom:-6px'>",link:"/"},{string:"About",link:"/about/"},{string:"Contact",link:"/contact/"},{string:"Projects",link:"/projects/"},{string:"Choice 2016",link:"/choice-2016/"},{string:"WHOIS",link:"/whois/"}],footer:[{string:"#SpeakFreely",link:"https://go.egartley.net/gab/",title:"Speak freely on Gab.ai"},{string:"Privacy",link:"/privacy/",title:"Privacy Policy"}],author:"egartley.net","base-url":"https://egartley.net","base-url-nohttp":"egartley.net"}};go(e)}function isMobile(){return!!(navigator.userAgent.match(/Android/i)||navigator.userAgent.match(/webOS/i)||navigator.userAgent.match(/iPhone/i)||navigator.userAgent.match(/iPod/i)||navigator.userAgent.match(/BlackBerry/i)||navigator.userAgent.match(/Windows Phone/i))}function sizecheck(){var e=736;$(window).width()<e&&0==$("#mcss").length?$("head").append('<link rel="stylesheet" href="/files/stylesheets/mobile.css" id="mcss" type="text/css" />'):$(window).width()>=e&&$("#mcss").remove()}function menubar(e){var i="",t="",n=window.location.pathname.replace(/^\/([^\/]*).*$/,"$1");0==n.length&&(n="home");for(var a=e.site["menu-bar"],l=0;l<a.length;l++){var o="",s=a[l].link.indexOf(n)!==-1;s&&"home"!==n?o=' class="current"':"home"==n&&"/"==a[l].link&&(o=' class="current"'),t+="<li"+o+'><a href="'+a[l].link+'"'+o+">"+a[l].string+"</a></li>"}i+="\n<ul id='bar-items'>"+t+"</ul>",$("body").prepend(i)}function footer(e){for(var i=e.site.footer,t="2016",n=e.site.build,a="<div id='footer'><a title='View copyright information' href='/privacy/'>© "+t+"</a> • <a title='View recent changes and additions' href='/changelog/'>Build "+n.major+"."+n.minor+"</a> • ",l=0;l<i.length;l++){var o=i[l];a+="<a href='"+o.link+"' title='"+o.title+"'>"+o.string+"</a>",void 0!==i[l+1]&&(a+=" • ")}a+="</div>",$("html").append(a)}function getProject(e,i,t,n,a,l){var o="none"!==e,s="<h2 class='proj'>"+a;t&&(s+=" <img id='pre' title='This is a pre-release build' src='/files/images/pre.gif' alt='pre-release'>");var r="";r=o?"<br><br><a href='"+e+"'>Learn more</a>":"<br><br><b>Coming Soon!</b>",s+="</h2>\n<p class='proj'>"+n+" "+r+"</p><br>",$("span#"+l).html(s)}function toggletext(e,i){0==$(e).is(":visible")?($(i+" img").rotate({duration:450,angle:180,animateTo:0}),$(e).slideDown()):($(i+" img").rotate({duration:450,angle:0,animateTo:180}),$(e).slideUp())}function getChangelog(e,i,t,n,a,l){var o="<div class='change-log'>\n<p><b style='color:#33a8ff'>"+e+"</b>",s=a+"_show";i&&(o+=" <img title='This is a pre-release build' src='/files/images/pre.gif' alt='pre-release'>"),o+="<a id='"+s+"' href='javascript:void(0);' onclick=\"toggletext('ul#"+a+"', 'a#"+s+"');\"><img id='toggle-img' src='/files/images/plus.gif' width='19' height='19' title='Show/hide this changelog' alt='show/hide'></a><br>"+t+"</p>\n<ul class='change-log' id='"+a+"' ",l||(o+="style='display:none;' "),o+=">";for(var r="",c=0;c<n.length;c+=1){var p=n[c];if(p instanceof Array){r+="<li>"+p[0]+"</li>\n<ul class='change-log' type='disc'>\n";for(var g=0;g<p[1].length;g+=1)r+="<li>"+p[1][g]+"</li>";r+="\n</ul>"}else r+="<li>"+p+"</li>\n"}r+="</ul>\n</div>",o+=r,$("span#"+a).html(o),$("head").append("<script>$(document).ready(function(){$('#"+s+" img').rotate({angle:180});});</script>")}function getButtonLink(e,i,t,n){$("span#"+n).html("\n<div id='button-div'><a href='"+e+"'><button type='button' style='margin-top:8px'>"+i+"</button></a>\n<p id='button-desc'><b>"+t+"</b></p></div>")}function getPageIcon(e){$("span#page-icon").html("<img id='page-icon' src='/files/images/"+e+"' alt='page-icon' title='Icon for this page'>")}function projectBackLink(e){$("span#"+e).html("<a href='/projects/?via=projectbacklink'>&#x27F2; Back to all projects</a>")}var mobile="";window.onresize=function(e){sizecheck()},$(document).ready(function(){getData(),$("div#overlay").delay(450).fadeOut("slow")});