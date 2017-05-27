<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hypnobox - parametereters List</title>
<c:url value="/assets" var="cssPath" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="${cssPath }/css/default.css" rel="stylesheet"/>
</head>
<body>
	 <div class="container margin-top">
    <div class="btn-toolbar">
        <button class="btn btn-danger" disabled="disabled">Import</button>
        <button class="btn btn-primary" disabled="disabled">Export</button>
    </div>
    <div class="well">
        <table class="table table-responsive">
        <thead>
            <tr class="text-center">
                <th>#</th>
                <th>Parameter</th>
                <th>Description</th>
                <th class="text-center" style="text-align:center !important;">Value</th>
                <th>Created At</th>
            </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach items="${params}" varStatus="param" var="parameter">
            <tr>
            <td>${parameter.idParam }</td>
            <td>${parameter.paramName }</td>
            <td>${parameter.description }</td>
            <td>${parameter.value }</td>
            <td><fmt:formatDate value="${parameter.createdAt.time }" type="date" dateStyle="medium"/></td>
            <td>
                <a href="parameter.html"><i class="icon-pencil"></i></a>
                <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
    </div>
    <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Delete Confirmation</h3>
        </div>
        <div class="modal-body">
            <p class="error-text">Are you sure you want to delete the parameter?</p>
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
            <button class="btn btn-danger" data-dismiss="modal">Delete</button>
        </div>
    </div>
</div>
<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
</body>
</html>