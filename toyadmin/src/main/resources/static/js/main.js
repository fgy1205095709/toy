
function deletea(date) {
	var id = $(date).attr("id");
	$("#dele").val(id);
}

function deleteb(date) {
	var id = $(date).attr("id");
	$("#dele2").val(id);
}
function sendmessage(date) {
	var id = $(date).attr("id");
	$("#userid").val(id);
}

function updategrade(date) {
	var id = $(date).attr("id");
	$("#dId").val(id);
}
function sendideamessage(date) {
	var id = $(date).attr("id");
	var iid= $(date).attr("ideaid");
	$("#userid").val(id);
	$("#ideaid").val(iid);
	$("#mTitle").val("管理员消息提醒");
	$("#mContent").val("您的"+"http://localhost:8083/ideafindid?ciId="+iid+"出现问题");

}
function updatetype(date) {
	var id = $(date).attr("id");
	var bigid=$(date).attr("data-bigid");
	var name = $(date).attr("data-name");
	var describe = $(date).attr("data-describe");
	var count = $(date).attr("data-count");
	var scan  = $(date).attr("data-scan");
	var state = $(date).attr("data-state");
	var mark = $(date).attr("data-mark");
	var a=null;
	if(bigid==1){
		a="玩具种类";
	}if(bigid==2){
		a="年龄段";
	}if(bigid==3){
		a="玩具材质";
	}if(bigid==4){
		a="玩具功能";
	}
	$("#cBigid").val(a);
	$("#cName").val(name);
	$("#cDescribe").val(describe);
	$("#cCount").val(count);
	$("#cScan").val(scan);
	$("#cState").val(state);
	$("#cMark").val(mark);
	$("#cId").val(id);
}
function updateuser(date) {
	var id = $(date).attr("id");
	var username=$(date).attr("data-username");
	var name = $(date).attr("data-name");
	var sign = $(date).attr("data-sign");
	var describe = $(date).attr("data-describe");
	var state = $(date).attr("data-state");
	var mark = $(date).attr("data-mark");

	$("#uUsername").val(username);
	$("#uName").val(name);
	$("#uSignature").val(sign);
	$("#uDescribe").val(describe);
	$("#uState").val(state);
	$("#uMark").val(mark);
	$("#uId").val(id);
}
function updatemessage(date) {
	var id = $(date).attr("id");
	var title  = $(date).attr("data-title");
	var content = $(date).attr("data-content");
	var state = $(date).attr("data-state");
	var mark = $(date).attr("data-mark");

	$("#mTitle").val(title);
	$("#mContent").val(content);
	$("#mState").val(state);
	$("#mMark").val(mark);
	$("#mId").val(id);
}
function updatereport(date) {
	var id = $(date).attr("id");
    var userid = $(date).attr("userid");
    var buserid = $(date).attr("buserid");
    $("#reId").val(id);
    $("#userid").val(userid);
	$("#buserid").val(buserid);
}
function updatepassword(date) {
	var username = $(date).attr("username");
	var name = $(date).attr("name");
	var password = $(date).attr("password");
	var mark = $(date).attr("mark");
	$("#aUsername").val(username);
	$("#aName").val(name);
	$("#aPassword").val(password);
	$("#aMark").val(mark);
}
function updateadmin(date) {
	var id = $(date).attr("id");
	var username = $(date).attr("data-name");
	var mark = $(date).attr("data-mark");
	var name = $(date).attr("name");
	var password = $(date).attr("data-password");
	$("#aName1").val(name);
	$("#aUsername1").val(username);
	$("#aMark1").val(mark);
	$("#aPassword1").val(password);
	$("#aId").val(id);
}
function updatechecker(date) {
	var id = $(date).attr("id");
	$("#ciId").val(id);
}
function updateneedchecker(date) {
	var id = $(date).attr("id");
	$("#nId").val(id);
}
function updateorderchecker(date) {
	var id = $(date).attr("id");
	$("#oId").val(id);
}