<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h3>hello MVC</h3>
    ${test} 
    
    ${testi18n} 
    <spring:message code="language"/><br>
    
    <a href="?language=vi">VI</a> || <a href="?language=en">EN</a>
    
    <form action="/spring/upload" enctype="multipart/form-data" method="post">
          <input type="file" name="file">
          <input type="submit" value="submit">
    </form>
    
    
    <form action="testmodelattribute" method="get">
           <input type="text" name="name"/>
           <input type="text" name="age"/>
           <input type="text" name="id"/>
           <input type="submit" value = "submit">
    </form>
    <br>
    modelAtributeMethod: ${modelAtributeMethod}
    <br>
    
    <form action="testsessionattributes" method="post">
       <input type="text" name="testsessionattributes">
       <input type="submit" value="testsessionattributes">
    </form>
    <br>
    testsessionattributes: ${testsessionattributes} 
</body>
</html>