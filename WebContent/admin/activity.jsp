<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>享悦管理</title>
<%-- 浏览器中的图标 --%>
    <link rel="Shortcut Icon" href="../images/xy.ico">
    <%-- 收藏夹中的图标 --%>
    <link rel="Bookmark" href="../images/xy.ico"/>
    <%-- 核心样式文件 --%>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
    <%-- 核心脚本文件 --%>
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <%-- 国际化脚本文件 --%>
    <script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
    <%-- 自定义样式 --%>
    <style type="text/css">
      a{color:blue;text-decoration:none}
      a:vlink{color:blue}
      a:hover{color:red}
    </style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
   <%@include file="inc/top_bottom.inc" %>
    </div>
    <!-- 左侧导航 -->
    <div data-options="region:'west'" style="width:200px;">
     <%@include file="inc/left.inc" %>
    </div>
    <!-- 主体部分 -->
    <div data-options="region:'center'">
      <!-- 用户数据表格 -->
<table id="dg_user" class="easyui-datagrid" style="width:100%;height:100%" data-options="toolbar:'#tb',singleSelect:true,fit:true,pagination:true,pageSize:20,pageList:[10,20,50],loadMsg:'数据正在努力加载，请稍后...'">
  <thead>
    <tr>
      <th data-options="field:'selector',checkbox:true"></th>
      <th data-options="field:'activity_id',width:40,align:'center'">活动编号</th>
      <th data-options="field:'use_id',width:100,align:'center'">发起人id</th>
      <th data-options="field:'joins',width:120,align:'center'">报名人数</th>
      <th data-options="field:'name',width:100,align:'center'">活动名称</th>
      <th data-options="field:'starttime',width:100,align:'center'">活动开始时间</th>
      <th data-options="field:'endtime',width:100,align:'center'">活动结束时间</th>
      <th data-options="field:'place',width:100,align:'center'">活动地点</th>
      <th data-options="field:'photo',width:100,align:'center'">活动照片</th>
      <th data-options="field:'intro',width:120,align:'center'">活动介绍</th>
      <th data-options="field:'school',width:120,align:'center'">学校</th>
      <th data-options="field:'nickName',width:120,align:'center'">发起人</th>
    </tr>
  </thead>
</table>
 
     <!-- 工具栏 -->
<div id="tb">
  <input id="txt_UserName" class="easyui-textbox" data-options="prompt:'请输入姓名',iconCls:'icon-man'"/>
  <a id="btn_Query" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
  <a id="btn_Add" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
  <a id="btn_Edit" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
  <a id="btn_Del" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</a>
</div>
      <!-- 添加|修改对话框 -->
<div id="dlg_user" class="easyui-dialog" data-options="title:'会员信息维护',buttons:'#bt_dlg_user',closed:true" style="width:270px;height:350px;padding:10px"  >
  <form id="fm_user" method="post">
    <input name="use_id" type="hidden">
    <div>
      <label>活动编号：</label>
      <input name="activity_id" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>发起人id：</label>
      <input name="use_id" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>报名人数：</label>
      <input name="joins" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>活动名称：</label>
      <input name="name" class="easyui-textbox" style="width:180px">
      </div>
    <div>
      <label>活动开始时间：</label>
      <input name="starttime" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>活动结束时间：</label>
      <input name="endtime" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>活动地点：</label>
      <input name="place" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>活动照片：</label>
      <input name="photo" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>活动介绍：</label>
      <input name="intro" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>学校：</label>
      <input name="school" class="easyui-textbox" style="width:180px">
    </div><br/>
    <div>
      <label>发起人：</label>
      <input name="nickName" class="easyui-textbox" style="width:180px">
    </div><br/>
  </form>
</div>
<!-- 对话框按钮 -->
<div id="bt_dlg_user">
  <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveRecord()">保存</a>
  <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="javascript:$('#dlg_user').dialog('close')">退出</a>
</div>
    </div>
  </div>
  <%-- 自定义脚本 --%>
  <script type="text/javascript" src="js/activity_option.js"></script>
</body>
</html>