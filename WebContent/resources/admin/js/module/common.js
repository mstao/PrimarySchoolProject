//判断用户是否保存信息  ，提示
var hasSaved = false;//是否有输入的内容未保存标志，初始值为false
function CheckUnsave(){
if(hasSaved==false){
//alert("您上传的东西尚未保存，请保存后再离开页面");
return "您上传的东西尚未保存，请保存后再离开页面";}
}

//保存了则改变状态
function ChangeState()
{
hasSaved = true;
} 