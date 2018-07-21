/**
 * <summary>基本增删改查导出相关脚本</summary>
 * <param name="searchRecord()">查询
 * <param name="saveRecord()">保存
*/

var url = null;//在请求远程数据的地址
var condition = null;//文本框的值，作为查询条件使用
var param = null;//拼接的查询条件，字符串型
var jsonParam = null;//转换后的查询条件，JSON型

//页面加载时查询
$(document).ready(function(){
  $("#btn_Query").click();
});

//用户单击查询按钮
$("#btn_Query").click(function(){
  url="/xy_ssh/admin_talk_get";
  condition = $("#txt_UserName").val();
  if(condition != null){
    param = "{\"condition\":\""+condition+"\"}";
  }else{
    param = null;
  }
  jsonParam = JSON.parse(param);
  searchRecord();
});

//用户查询记录
/**
* queryParams：在请求远程数据时发送额外的参数
* 格式：queryParams:{key1:value1,key2:value2}
* 参数类型：JSON对象
*/
function searchRecord(){
  $('#dg_user').datagrid({
    url:"/xy_ssh/Talk_adminGet",
    queryParams:jsonParam
  });
};

//用户单击添加按钮
$("#btn_Add").click(function(){
  $("#dlg_user").dialog("open");
  $("#fm_user").form("clear");
  url = "/xy_ssh/Talk_add";
});

//用户单击删除按钮
$("#btn_Del").click(function(){
  var row = $("#dg_user").datagrid("getSelected");
  if (row == null){
    alert("请选择需要删除的记录");
    return;
  }
  url = "/xy_ssh/Talk_delete";
  var talk_id = row.talk_id;
  $.messager.confirm('提示', '确认要删除吗?', function(data){
    if (data){
      $.post(
        url,
        {talk_id:talk_id},
        function(result){
          $("#dg_user").datagrid("reload");           
      });
    }
  });  
});
