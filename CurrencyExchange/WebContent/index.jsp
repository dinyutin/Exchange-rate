<%@page import="java.util.HashMap"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>即時匯率轉換器</title>
  </head>

  <body>  
    <div id = "app">
    <h2>即時匯率轉換器</h2>
    幣別：
    <form METHOD="post" ACTION="calculate" name="form1">
    <select name="currency" id="DropDownList1">
      <option value="USD">美金</option>
      <option value="TWD">台幣</option>
      <option value="JPY">日幣</option>
    </select>
    金額：<input name="price"  type="number" step="0.01" value="0"/> - 折扣： <input type="number" step="0.01" name="discount" value="0" /> = 台幣結果： 0 
    <br/>
    <br/>
    <input type="hidden" name="action" value="insert">
    <button type="submit">計算</button>
    <ul>
      <li style="color:red">注意：幣別為美金或日幣時，折扣功能無效.</li>
      <li style="color:red">注意：幣別為台幣時，需有折扣功能.</li>
    </ul>
    </form>
    </div>

<c:if test="${not empty errorMsgs}">
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

</body>
</html>