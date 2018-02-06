<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery-easyui-1.4.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery-easyui-1.4.5/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery-easyui-1.4.5/demo/demo.css">
<body>
<table id="dg"></table>  
</body>
<script>
$('#dg').datagrid({    
    url:'<%=request.getContextPath()%>/goods/queryGoods.do',    
    columns:[[    
        {field:'goodsId',title:'商品ID',width:100,align:'center'},    
        {field:'goodsName',title:'商品名称',width:100,align:'center',
        	formatter:function(value,row,index){
        		
        		return "<a target='_blank' href='${pageContext.request.contextPath}/goods/toGoodsInfo.do?goodsId="+row.goodsId+"'>"+value+"</a>"
        	}	
        },     
        {field:'goodsPrice',title:'商品价格',width:100,align:'center'},    
        {field:'goodsCount',title:'商品库存',width:100,align:'center'},    
        {field:'goodsTime	Str',title:'出厂时间',width:100,align:'center'},    
        {field:'typeId',title:'商品类型',width:100,align:'center'}  
    ]],
	//singleSelect为true选中一行
	singleSelect:true,
	//定义分页工具栏
	pagePosition:'bottom',
	//设置每页条数
	pageSize:5,
	//初始化页面选择条数的列表
	pageList:[5,10,15,20,25],
	loadMsg:"正在请求数据，请稍后！",
	pagination:true
});  
</script>
</html>