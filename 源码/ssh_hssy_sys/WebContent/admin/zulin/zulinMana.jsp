<%@ page language="java" pageEncoding="UTF-8"%>
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
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
        <script language="javascript">
           function zulinDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/zulinDel.action?id="+id;
               }
           }
           
           function zulinAdd()
           {
                 var url="<%=path %>/admin/zulin/zulinAdd.jsp";
				 window.location.href=url;
           }
           
           function zulinHuan(id)
           {
               if(confirm('您确定归还吗？'))
               {
					var strUrl = "<%=path %>/admin/zulin/zulinHuan.jsp?id="+id;
					var ret = window.showModalDialog(strUrl,"","dialogWidth:600px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
                    window.location.reload();
               }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="42" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="20%">婚纱信息</td>
					<td width="10%">客户姓名</td>
					<td width="10%">身份证号</td>
					
					<td width="10%">起租时间</td>
					<td width="5%">押金信息</td>
					<td width="10%">备注信息</td>
					<td width="5%">是否归还</td>
					
					<td width="10%">归还时间</td>
					<td width="10%">租赁费用</td>
					<td width="8%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.zulinList}" var="zulin" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF">
					<td bgcolor="#FFFFFF" align="center">${sta.index+1}</td>
					<td bgcolor="#FFFFFF" align="center">${zulin.goods.goodsName}</td>
					<td bgcolor="#FFFFFF" align="center">${zulin.kehuming}</td>
					<td bgcolor="#FFFFFF" align="center">${zulin.shenfenzheng}</td>
					
					<td bgcolor="#FFFFFF" align="center">${zulin.kaishishijian}</td>
					<td bgcolor="#FFFFFF" align="center">${zulin.yajin}</td>
					<td bgcolor="#FFFFFF" align="center">${zulin.beizhu}</td>
					<td bgcolor="#FFFFFF" align="center">${zulin.shifouhuan}</td>
					
					<td bgcolor="#FFFFFF" align="center">${zulin.jieshushijian}</td>
					<td bgcolor="#FFFFFF" align="center">
					   <c:if test="${zulin.feiyong==0}">
					       &nbsp;
					   </c:if>
					   <c:if test="${zulin.feiyong !=0}">
					       ${zulin.feiyong}
					   </c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <input type="button" value="删除" onclick="zulinDel(${zulin.id})"/>
					   <input type="button" value="归还" onclick="zulinHuan(${zulin.id})"/>
				    </td>
				</tr>
				</c:forEach>
			</table>
			
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加租赁信息" style="width: 80px;" onclick="zulinAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
