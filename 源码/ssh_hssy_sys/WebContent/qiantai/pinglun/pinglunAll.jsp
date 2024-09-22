<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<style rel="stylesheet" type="text/css">
			.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
			.f-right{float:right}
			.f-left{float:left}
			.clear{clear:both}
		</style>
		
        <script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%"  border="0" cellpadding="2" cellspacing="1"  align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/images/tbg.gif">&nbsp;评论信息&nbsp;</td>
				</tr>
				<tr align="center"  height="22">
					<td width="100%" height="100%">
					    <c:forEach items="${requestScope.pinglunList}" var="pinglun">
						   <div class="c1-bline" style="padding:7px 0px;">
						       <div class="f-left">
							     <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> 
						         ${pinglun.neirong}
						       </div>
						       <div class="f-right">${pinglun.shijian}</div>
						       <div class="clear"></div>
						   </div>
						</c:forEach>
                    </td>
		        </tr>	
			</table>
	</body>
</html>
