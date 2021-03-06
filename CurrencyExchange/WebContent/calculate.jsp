<%@page import="java.util.HashMap"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	RecordVO recordVO = (RecordVO) request.getAttribute("recordVO");
%>
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
    <select name="currency" id="DropDownList">
      <option value="USD">美金</option>
      <option value="TWD">台幣</option>
      <option value="JPY">日幣</option>
    </select>
    金額：<input name="price"  type="number" step="0.01" value="${recordVO.price}"/> - 折扣： <input type="number" step="0.01" name="discount"  value="${recordVO.discount}"/> = 台幣結果： ${recordVO.result} 
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$("#DropDownList option[value='${recordVO.currency}']").attr("selected","selected");
	</script>
</body>
</html>