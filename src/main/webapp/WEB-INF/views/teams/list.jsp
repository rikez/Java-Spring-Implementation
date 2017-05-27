<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hypnobox - Teams List</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
            <tr class="text-center center">
                <th class="center">#</th>
                <th class="center">Name</th>
                <th class="center">ID Board Trello</th>
                <th class="center">Created At</th>
                <th class="center">Actions</th>
            </tr>
        </thead>
        <tbody class="text-center">
        <c:forEach items="${teams}" varStatus="status" var="team">
            <tr>
            <td>${team.idTeam }</td>
            <td>${team.teamName }</td>
            <td>${team.idBoardTeam }</td>
            <td><fmt:formatDate value="${team.createdAt.time }" type="date" dateStyle="medium"/></td>
            <td>
                <a class="anchor" href="${contextPath }/dashboard/reports/${team.idTeam}">Reports</a>
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
            <p class="error-text">Are you sure you want to delete the team</p>
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