<% String panelIndex=request.getParameter("panelIndex");%>
<div class="easyui-accordion" style="width:100%;">
  <div title="用户管理" <%if("0".equals(panelIndex)){%> data-options="selected:true"<%}%>>
    <a id="user" href="user.jsp?panelIndex=0" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" style="width:100%;text-align:left;">用户管理</a>
  </div>
  <div title="分享管理" <%if("1".equals(panelIndex)){%> data-options="selected:true"<%}%>>
    <a id="talk" href="talk.jsp?panelIndex=1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" style="width:100%;text-align:left;">分享管理</a>
  </div>
  <div title="图片管理" <%if("2".equals(panelIndex)){%> data-options="selected:true"<%}%>>
    <a id="view" href="view.jsp?panelIndex=2" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" style="width:100%;text-align:left;">图片管理</a>
  </div>
  <div title="活动管理" <%if("3".equals(panelIndex)){%> data-options="selected:true"<%}%>>
    <a id="activity" href="activity.jsp?panelIndex=3" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" style="width:100%;text-align:left;">活动管理</a>
  </div>
</div>