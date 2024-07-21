<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <!-- give this isELIgnored="false" otherwise error is coming -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- we also do request.getAttribute and that value -->
<!-- Result is: ${result}  -->
 Result is: ${springMVCModel} 
 Wecome back ${name}
 
</form>
</body>
</html>