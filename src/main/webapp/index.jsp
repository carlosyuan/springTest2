<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="templates/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#testJson").click(function(){
                var url = this.href;
                var args = {};
                $.post(url, args, function(data){
                    for(var i=0; i<data.length; i++){
                        var id = data[i].id;
                        var lastName = data[i].lastName;
                        alert(id + ": " + lastName);
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>

<a href="helloworld">hello world</a>

<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value= "PUT"/>
    <input type="submit" value="testRestPut"/>
</form><br/><br/>

<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="TestRest DELETE"/>
</form><br><br>

<form action="testRest" method="post">
    <input type="submit" value="testRestPost">
</form><br/><br/>

<a href="testRest/1">testRest</a><br/><br/>

<a href="emps">list all employees</a><br/>
<a href="jquerytest">jquerytest</a><br/>

<a href="testJson" id="testJson">testJson</a>

<a href="fileuploadpage" >fileupload test</a><br/>
<a href="testResponseEntity" id="testJson1">testResponseEntity</a><br/><br/>
</body>
</html>