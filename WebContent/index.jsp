<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
<style type="text/css">
	.container {
	  padding-right: 15px;
	  padding-left: 15px;
	  margin-right: auto;
	  margin-left: auto;
	}
	@media (min-width: 768px) {
	  .container {
	    width: 750px;
	  }
	}
	@media (min-width: 992px) {
	  .container {
	    width: 970px;
	  }
	}
	@media (min-width: 1200px) {
	  .container {
	    width: 1170px;
	  }
	}
	.container-fluid {
	  padding-right: 15px;
	  padding-left: 15px;
	  margin-right: auto;
	  margin-left: auto;
	}
</style>
</head>
<body>
	  <div class="container">
	    <div class="span2">
	      <!--Sidebar content-->
	        <table class="table" >
				<thead><tr><td>名称</td><td>数量</td></tr></thead>
				<tbody id="flag" ></tbody>
			</table>
	    </div>
	    <div class="span10" >
	    	<table class="table" >
				<thead><tr><td id="flagN">详情</td></tr></thead>
				<tbody id="flagV" ></tbody>
			</table>
	    </div>
	 </div>
	

	<script type="text/javascript">
	function query1(name){
	 $.ajax({
         url:"<%=basePath%>/show/query",
		         type:"GET",
		         data:"key="+name,
		         success:function(result){
		         	var data=eval('(' + result + ')');
		         	console.log(data.value);
		         	var temp=data.value;
		         	$("#flagN").html("名称："+name);
		         	var str="";
		         	for(var i=0;i<temp.length;i++){
		         		if(i>30)break;
		         		str+="<tr>";
		         		str+="<td>"+temp[i]+"</td>";
						str+="</str>";			         	
		         	}
		         	$("#flagV").html(str);
		         	
		         }
		});
	}
	function query2(){
		$.ajax({
	         url:"<%=basePath%>/show/queryName",
			         type:"GET",
			         //data:"Key="+tel+"&code="+code,
			         success:function(result){
			        	 //console.log(result);
			        	 var data=eval('(' + result + ')');
			        	 console.log(data);
			        	 
			        	 /* var map = new Map(data);
			        	 console.log(map);
			        	 for(var i=0;i<map.size;i++){
			        		 console.log(map.get(i));
			        	 } */
			        	 var str="";
			        	 var key=data.key;
			        	 var value=data.value;
			        	 for(var i=0;i<key.length;i++){
			        		 str+="<tr>";
			        		 var r1=key[i];
			        		 var r2=value[i];
							 str+="<td style=\"cursor:pointer\" onclick=\"query1('"+r1+"')\">"+r1+"</td>";
							 str+="<td>"+r2+"</td>";
			        	 	 str+="</tr>";
			        	 }
			        	 
			        	 $("#flag").html(str);
			         }
		});	
	}
	
	query2();
	</script>
</body>
</html>