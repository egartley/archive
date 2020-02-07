<?php
/*
Original script from "phpeasycode.com", modified by author(s) of "egartley.net"
*/
$domain=$_GET['domain'];
$errorString="Invalid query. Make sure it's not a sub-domain and doesn't include any characters other than A-Z, 0-9 or \"-\"";
$whoisservers=array(
	"ac"=>"whois.nic.ac",
	"ae"=>"whois.nic.ae","aero"=>"whois.aero","af"=>"whois.nic.af","ag"=>"whois.nic.ag","ai"=>"whois.ai","al"=>"whois.ripe.net","am"=>"whois.amnic.net","arpa"=>"whois.iana.org","as"=>"whois.nic.as","asia"=>"whois.nic.asia","at"=>"whois.nic.at","au"=>"whois.aunic.net","ax"=>"whois.ax","az"=>"whois.ripe.net","be"=>"whois.dns.be","bg"=>"whois.register.bg","bi"=>"whois.nic.bi","biz"=>"whois.biz","bj"=>"whois.nic.bj","bn"=>"whois.bn","bo"=>"whois.nic.bo","br"=>"whois.registro.br","bt"=>"whois.netnames.net","by"=>"whois.cctld.by","bz"=>"whois.belizenic.bz","ca"=>"whois.cira.ca","cat"=>"whois.cat","cc"=>"whois.nic.cc","cd"=>"whois.nic.cd","ch"=>"whois.nic.ch","ci"=>"whois.nic.ci","ck"=>"whois.nic.ck","cl"=>"whois.nic.cl","cn"=>"whois.cnnic.net.cn","co"=>"whois.nic.co","com"=>"whois.verisign-grs.com","coop"=>"whois.nic.coop","cx"=>"whois.nic.cx","cz"=>"whois.nic.cz","de"=>"whois.denic.de","dk"=>"whois.dk-hostmaster.dk","dm"=>"whois.nic.dm","dz"=>"whois.nic.dz","ec"=>"whois.nic.ec","edu"=>"whois.educause.edu","ee"=>"whois.eenet.ee","eg"=>"whois.ripe.net","es"=>"whois.nic.es","eu"=>"whois.eu","fi"=>"whois.ficora.fi","fo"=>"whois.nic.fo","fr"=>"whois.nic.fr","gd"=>"whois.nic.gd","gg"=>"whois.gg","gi"=>"whois2.afilias-grs.net","gl"=>"whois.nic.gl","gov"=>"whois.nic.gov","gs"=>"whois.nic.gs","gy"=>"whois.registry.gy","hk"=>"whois.hkirc.hk","hn"=>"whois.nic.hn","hr"=>"whois.dns.hr","ht"=>"whois.nic.ht","hu"=>"whois.nic.hu","ie"=>"whois.domainregistry.ie","il"=>"whois.isoc.org.il","im"=>"whois.nic.im","in"=>"whois.inregistry.net","info"=>"whois.afilias.net","int"=>"whois.iana.org","io"=>"whois.nic.io","iq"=>"whois.cmc.iq","ir"=>"whois.nic.ir","is"=>"whois.isnic.is","it"=>"whois.nic.it","je"=>"whois.je","jobs"=>"jobswhois.verisign-grs.com","jp"=>"whois.jprs.jp","ke"=>"whois.kenic.or.ke","kg"=>"www.domain.kg","ki"=>"whois.nic.ki","kr"=>"whois.kr","kz"=>"whois.nic.kz","la"=>"whois.nic.la","li"=>"whois.nic.li","lt"=>"whois.domreg.lt","lu"=>"whois.dns.lu","lv"=>"whois.nic.lv","ly"=>"whois.nic.ly","ma"=>"whois.iam.net.ma","md"=>"whois.nic.md","me"=>"whois.nic.me","mg"=>"whois.nic.mg","mil"=>"whois.nic.mil","ml"=>"whois.dot.ml","mn"=>"whois.nic.mn","mo"=>"whois.monic.mo","mobi"=>"whois.dotmobiregistry.net","mp"=>"whois.nic.mp","ms"=>"whois.nic.ms","mu"=>"whois.nic.mu","museum"=>"whois.museum","mx"=>"whois.mx","my"=>"whois.domainregistry.my","na"=>"whois.na-nic.com.na","name"=>"whois.nic.name","nc"=>"whois.nc","net"=>"whois.verisign-grs.net","nf"=>"whois.nic.nf","ng"=>"whois.nic.net.ng","nl"=>"whois.domain-registry.nl","no"=>"whois.norid.no","nu"=>"whois.nic.nu","nz"=>"whois.srs.net.nz","om"=>"whois.registry.om","org"=>"whois.pir.org","pe"=>"kero.yachay.pe","pf"=>"whois.registry.pf","pl"=>"whois.dns.pl","pm"=>"whois.nic.pm","post"=>"whois.dotpostregistry.net","pr"=>"whois.nic.pr","pro"=>"whois.dotproregistry.net","pt"=>"whois.dns.pt","pw"=>"whois.nic.pw","qa"=>"whois.registry.qa","re"=>"whois.nic.re","ro"=>"whois.rotld.ro","rs"=>"whois.rnids.rs","ru"=>"whois.tcinet.ru","sa"=>"whois.nic.net.sa","sb"=>"whois.nic.net.sb","sc"=>"whois2.afilias-grs.net","se"=>"whois.iis.se","sg"=>"whois.sgnic.sg","sh"=>"whois.nic.sh","si"=>"whois.arnes.si","sk"=>"whois.sk-nic.sk","sm"=>"whois.nic.sm","sn"=>"whois.nic.sn","so"=>"whois.nic.so","st"=>"whois.nic.st","su"=>"whois.tcinet.ru","sx"=>"whois.sx","sy"=>"whois.tld.sy","tc"=>"whois.meridiantld.net","tel"=>"whois.nic.tel","tf"=>"whois.nic.tf","th"=>"whois.thnic.co.th","tj"=>"whois.nic.tj","tk"=>"whois.dot.tk","tl"=>"whois.nic.tl","tm"=>"whois.nic.tm","tn"=>"whois.ati.tn","to"=>"whois.tonic.to","tp"=>"whois.nic.tl","tr"=>"whois.nic.tr","travel"=>"whois.nic.travel","tv"=>"tvwhois.verisign-grs.com","tw"=>"whois.twnic.net.tw","tz"=>"whois.tznic.or.tz","ua"=>"whois.ua","ug"=>"whois.co.ug","uk"=>"whois.nic.uk","us"=>"whois.nic.us","uy"=>"whois.nic.org.uy","uz"=>"whois.cctld.uz","vc"=>"whois2.afilias-grs.net","ve"=>"whois.nic.ve","vg"=>"whois.adamsnames.tc","wf"=>"whois.nic.wf","ws"=>"whois.website.ws","yt"=>"whois.nic.yt","yu"=>"whois.ripe.net");

function ValidateDomain($dom) {
	if(!preg_match("/^([-a-z0-9]{2,100})\.([a-z\.]{2,8})$/i", $dom)) {
		return false;
	}
	return true;
}
function queryDomain($dmn) {
	global $whoisservers;

	if (!ValidateDomain($dmn)) {
		return $errorString;
	}

	$domain_parts=explode(".",$dmn);
	$tld=strtolower(array_pop($domain_parts));
	$whoisserver=$whoisservers[$tld];
	if(!$whoisserver) {
		return $errorString;
	}
	$res=QueryWhoisServer($whoisserver,$dmn);
	if(!$res) {
		return $errorString;
	} else {
		while(strpos($res,"Whois Server:")!==false) {
			preg_match("/Whois Server: (.*)/",$res,$matches);
			$secondary=$matches[1];
			if($secondary) {
				$res=QueryWhoisServer($secondary,$dmn);
				$whoisserver=$secondary;
			}
		}
	}
	return $res;
}
function QueryWhoisServer($whoisserver,$dmain) {
	$port=43;
	$timeout=10;
	$fp=@fsockopen($whoisserver,$port,$errno,$errstr,$timeout) or die("Socket Error ".$errno." - ".$errstr);
	if($whoisserver=="whois.verisign-grs.com"){
		$dmain = "domain " . $dmain;
	}
	fputs($fp,$dmain."\r\n");
	$out="";
	while(!feof($fp)) {
		$out.=fgets($fp);
	}
	fclose($fp);
	$res = "";
	if((strpos(strtolower($out),"error")===false)&&(strpos(strtolower($out),"not allocated")===false)) {
		$rows=explode("\n",$out);
		foreach($rows as $row) {
			$row=trim($row);
			if(($row!='')&&($row{0}!='#')&&($row{0}!='%')) {
				$res.=$row."\n";
			}
		}
	}
	return $res;
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>WHOIS Lookup - egartley.net</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
    <link href="https://core-cdn.egartley.net/bjefIEeHYVukojSnIKdsIzjzdrqxcwOK/ico/ywMEqSTEafnLegSQzvPIXThEkMMhzYZj/favicon.ico" rel="icon">
    <link href="https://core-cdn.egartley.net/bjefIEeHYVukojSnIKdsIzjzdrqxcwOK/ico/ywMEqSTEafnLegSQzvPIXThEkMMhzYZj/favicon.ico" rel="shortcut icon" type="images/x-icon">
    <link href="https://core-cdn.egartley.net/hZDegfHVLKJvtRDhpPEaXUOGXKRdCnfl/css/fpJsilBptcKsEweFtaADyRjiwaASRPNF/design.css" rel="stylesheet" type="text/css">
    <script src="https://core-cdn.egartley.net/rYTjNOIPtrMPRMfLikXPEcCfIwgbnGGS/js/pdGNiFraWDvcwQltDGamAZyHIgfJBhJH/jquery.js"></script>
    <script type="text/javascript" src="https://core-cdn.egartley.net/rYTjNOIPtrMPRMfLikXPEcCfIwgbnGGS/js/uqHeBPWEuCAaxOVysmkFmdZDqPzcJvqd/script.js"></script>
</head>

<body>
    <div class="root-container">
        <div class="container navbar-container">
            <!-- LOGO AND TITLE !-->
            <div class="logo-container" onclick="navigate('/')">
                <img class="site-logo-img" src="https://core-cdn.egartley.net/ydfZIggolRifIIneoAGyBiyDvCAKOCpi/png/AUksgmgtMWgZzbeXZpLRAABCZCYZsFSp/logo_new.png">
            </div>
            <div class="navbar-title-container">
                <span class="navbar-title" onclick="navigate('/')">egartley.net</span>
                <br /><span class="secondary-text">Tech enthusiast and proud American</span>
            </div>
            <!-- NAVIGATION ITEMS !-->
            <div class="nav-items-container">
                <div class="nav-item-hitbox" onclick="navigate('/')">
                    <div class="nav-item">
                        <span>Home</span>
                    </div>
                </div>
                <div class="nav-item-hitbox" onclick="navigate('/about')">
                    <div class="nav-item">
                        <span>About</span>
                    </div>
                </div>
                <div class="nav-item-hitbox" onclick="navigate('/contact')">
                    <div class="nav-item">
                        <span>Contact</span>
                    </div>
                </div>
                <div class="nav-item-hitbox" onclick="navigate('/projects')">
                    <div class="nav-item">
                        <span>Projects</span>
                    </div>
                </div>
                <div class="nav-item-hitbox" onclick="navigate('/whois')">
                    <div class="nav-item active">
                        <span>WHOIS</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-container">
            <div class="container pagecontent-container">
            	<!-- PAGE CONTENT !-->
                <div class="page-title">
                    <span>WHOIS Lookup</span>
                </div>
                <div class="page-meta">
                    <span class="secondary-text">Last updated June 13, 2017 at 04:25 PM</span>
                </div>
                <div class="page-content">
                	<form action="/preview/whois" style="margin-top:48px">
						<p>
							<input type="text" placeholder="Domain to query" name="domain" maxlength="128" id="domain" value="<?=$domain;?>">
							<input type="submit" value="Lookup">
						</p>
					</form>
<?php
function hasWord($word, $txt) {
    $patt = "/(?:^|[^a-zA-Z])" . preg_quote($word, '/') . "(?:$|[^a-zA-Z])/i";
    return preg_match($patt, $txt);
}

function output($out, $valid, $dmn) {
	if ($valid !== false) {
		$out = "<pre style='text-align:left'>".$out."</pre>";
	}
	echo "<h2>Results for \"".$dmn."\"</h2><div style='overflow:auto;max-width:920px'>".$out."</p></div>";
}

if($domain) {
	$domain=trim($domain);
	if (substr(strtolower($domain),0,7) == "http://") {
		$domain=substr($domain,7);
	}
	if (substr(strtolower($domain),0,8) == "https://") {
		$domain=substr($domain,8);
	}
	if (substr(strtolower($domain),0,4) == "www.") {
		$domain=substr($domain,4);
	}
	$valid = ValidateDomain($domain);
	if (!$valid) {
		output($errorString, false, $domain);
	} else {
        output(queryDomain($domain), true, $domain);
    }

}
?>
                </div>
            </div>
            <div class="container sidebar-container">
            	<!-- SIDEBAR WIDGETS !-->
            	<div class="widget-container">
            		<div>
            			<div class="widget-title">
            				<span>Search</span>
            			</div>
            			<div class="widget-content widget-search">
            				<input class="widget-search-textbox" type="text" onkeyup="press(event)" name="search" placeholder="Looking for something?">
            				<img title="Search this site" alt="icon" src="https://core-cdn.egartley.net/JWbfagwmwYPKpNvyoopzzqtWodFrfELa/svg/jNenYVPzYOyGswLllGnuQhalhzcOLrHD/search.svg" onclick="search()">
            			</div>
            		</div>
            	</div>
            	<div class="widget-divider"></div>
            	<div class="widget-container">
            		<div>
            			<div class="widget-title">
            				<span>Social</span>
            			</div>
            			<div class="widget-content widget-social">
            				<div>
            					<div class="widget-social-container" onclick="navigate('https://go.egartley.net/t/?via=widgetsocial')" title="Twitter">
            						<span id="image-link"><img src="https://core-cdn.egartley.net/ydfZIggolRifIIneoAGyBiyDvCAKOCpi/png/eXegGgKSkqgBpzhzSnUxbtQfDZzBxOCM/twitter.png" alt="twitter"></span>
            						<span id="display-text">Twitter</span>
            					</div>
            					<div class="widget-social-container" onclick="navigate('https://go.egartley.net/github/?via=widgetsocial')" title="GitHub">
            						<span id="image-link"><img src="https://core-cdn.egartley.net/ydfZIggolRifIIneoAGyBiyDvCAKOCpi/png/eXegGgKSkqgBpzhzSnUxbtQfDZzBxOCM/github.png" alt="github"></span>
            						<span id="display-text">GitHub</span>
            					</div>
            				</div>
            			</div>
            		</div>
            	</div>
            </div>
        </div>
        <div class="container footer-container">
        	<!-- FOOTER !-->
            <span id="footer-text" class="secondary-text">
        		<span id="copyright-text" onclick="navigate('/privacy/?via=footer')">Copyright © 2017</span>
            	<span id="delimiter"></span>
            	<span id="build-text" onclick="navigate('/changelog/?via=footer')">Build 200.001</span>
            	<span id="delimiter"></span>
            	<span id="custom-link" onclick="navigate('https://go.egartley.net/github/?via=footer')">GitHub</span>
            	<span id="delimiter"></span>
            	<span id="custom-link" onclick="navigate('/privacy/?via=footer')">Privacy</span>
            </span>
        </div>
    </div>
</body>
</html>