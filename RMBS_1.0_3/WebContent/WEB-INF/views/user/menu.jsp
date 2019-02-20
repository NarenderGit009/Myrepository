<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.user.resourceBean.roleBean.id == 1 }">
<jsp:include page="/WEB-INF/views/admin/adminMenu.jsp"></jsp:include>
</c:if>

<c:if test="${sessionScope.user.resourceBean.roleBean.id == 2 }">
<jsp:include page="/WEB-INF/views/organization/activeOrganization/activeOrganizationMenu.jsp"></jsp:include>
</c:if>

<c:if test="${sessionScope.user.resourceBean.roleBean.id == 3 }">
<jsp:include page="/WEB-INF/views/branch/activeBranch/activeBranchMenu.jsp"></jsp:include>
</c:if>

<c:if test="${sessionScope.user.resourceBean.roleBean.id == 4 }">
<jsp:include page="/WEB-INF/views/outlet/activeOutlet/activeOutletMenu.jsp"></jsp:include>
</c:if>

</body>
</html>