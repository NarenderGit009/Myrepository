<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<html id="">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


  <title><tiles:insertAttribute name="title" ignore="true" /></title>


</head>
<body>
    
  
    <div>
	<div><tiles:insertAttribute name="menu" /></div>
	<div><tiles:insertAttribute name="body" /></div>		
    </div>
    
</body>
</html>