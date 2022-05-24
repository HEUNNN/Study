<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- 상대경로 사용(ex. save), [현재 URL이 속한 계층 경로 + /save] -->
<!-- http://localhost:8080/servlet-mvc/members/new-form 에서 이름, 나이 입력 후 전송 버튼을 누르면 -->
<!-- http://localhost:8080/servlet-mvc/members/save 로 변화한다. -->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
