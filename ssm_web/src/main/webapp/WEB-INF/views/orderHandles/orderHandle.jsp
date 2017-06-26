<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单处理</title>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div>
		订单号： <input type="text" id="orderId" size="20" onkeydown="if(event.keyCode == 13)searchUser()" />
		<a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>
		<a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doAllSearch()">查询全部订单</a>
	</div>
	<table id="tt" class="easyui-datagrid"
		style="width: 910px; height: 350px" title="订单" iconCls="icon-save"
		rownumbers="false" pagination="true">
	</table>
	<div id="dlg" class="easyui-dialog" style="width: 400px" closed="true"
			buttons="#dlg-buttons">
			<form id="fm" method="post" novalidate
				style="margin: 0; padding: 20px 50px">
				<div
					style="margin-bottom: 20px; font-size: 14px; border-bottom: 1px solid #ccc">订单信息</div>
				<div style="margin-bottom: 10px">
					<input name=id class="easyui-textbox" required="true" label="订单ID:"
						style="width: 100%">
				</div>
				<div style="margin-bottom: 10px">
					<input name="userId" class="easyui-textbox" required="true"
						label="用户ID:" style="width: 100%">
				</div>
				<div style="margin-bottom: 10px">
					<input name="number" class="easyui-textbox" required="true"
						label="订单号:" style="width: 100%">
				</div>
				<div style="margin-bottom: 10px">
					<input name="createtime" class="easyui-datetimebox" required="true"
						label="创建时间:" style="width: 100%">
				</div>
				<div style="margin-bottom: 10px">
					<input name="note" class="easyui-textbox" required="true"
						label="订单状态:" style="width: 100%">
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="saveOrder()" style="width: 90px">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width: 90px">取消</a>
		</div>

		<script type="text/javascript">
		var url;				
		function saveOrder(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(data){                	
                        $('#dlg').dialog('close');     
                        doAllSearch();
                }
            });
		}
		
		function destroyOrder(){
            var row = $('#tt').datagrid('getSelected');
            if (row){				            	
                $.messager.confirm('Confirm','Are you sure you want to destroy this order?',function(r){
                    if (r){
                        $.post('${pageContext.request.contextPath}/ordersController/deleteOrder.action',{id:row.id},function(result){                        	      
                        	//如何写。。。。
                        },'json');
                        doAllSearch();  
                    }
                });                
            }      
        }
     
		function editOrder() {
			$('#fm').form('clear');
			var row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit Order');
				$('#fm').form('load', row);
				url = '${pageContext.request.contextPath}/ordersController/editOrder.action';
			}
		}
		
		function doSearch(){
			var order_id=document.getElementById("orderId").value;  
			$('#tt').datagrid({
				url : '${pageContext.request.contextPath}/ordersController/queryOrder.action',
				pageSize : 5,
				queryParams:{id:order_id},
					
				columns : [ [ {
					field : 'id',
					title : '订单ID',
					width : 180,
					align : "center"
				}, {
					field : 'userId',
					title : '用户ID',
					width : 180,
					align : "center"
				}, {
					field : 'number',
					title : '订单号',
					width : 180,
					align : 'center'
				}, {
					field : 'createtime',
					title : '创建时间',
					width : 180,
					align : "center"
				},{
					field : 'note',
					title : '订单状态',
					width : 180,
					align : "center"
				}] ],
				toolbar : [ {
					text : '添加',
					iconCls : 'icon-add',				
					handler : function() {
						 $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加订单');
				         $('#fm').form('clear');
				         url='${pageContext.request.contextPath}/ordersController/addOrder.action';
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						editOrder();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						destroyOrder();
					}
				} ]
			});		
			
			//设置分页控件  
			var p = $('#tt').datagrid('getPager');
			p.pagination({
				pageSize : 5,//每页显示的记录条数，默认为10  
				pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表  
				beforePageText : '第',//页数文本框前显示的汉字  
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});			
			
			$('#tt').datagrid('reload');   
		}
		
		function doAllSearch(){
			$('#tt').datagrid({
				url : '${pageContext.request.contextPath}/ordersController/getAllOrders.action',
				pageSize : 5,

				columns : [ [ {
					field : 'id',
					title : '订单ID',
					width : 180,
					align : "center"
				}, {
					field : 'userId',
					title : '用户ID',
					width : 180,
					align : "center"
				}, {
					field : 'number',
					title : '订单号',
					width : 180,
					align : 'center'
				}, {
					field : 'createtime',
					title : '创建时间',
					width : 180,
					align : "center"
				},{
					field : 'note',
					title : '订单状态',
					width : 180,
					align : "center"
				}] ],
				toolbar : [ {
					text : '添加',
					iconCls : 'icon-add',				
					handler : function() {
						 $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加订单');
				         $('#fm').form('clear');
				         url='${pageContext.request.contextPath}/ordersController/addOrder.action';
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						editOrder();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						destroyOrder();
					}
				} ]
			});

			//设置分页控件  
			var p = $('#tt').datagrid('getPager');
			p.pagination({
				pageSize : 5,//每页显示的记录条数，默认为10  
				pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表  
				beforePageText : '第',//页数文本框前显示的汉字  
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});
		}
	</script>
</body>
</html>