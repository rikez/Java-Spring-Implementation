<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hypnobox - Reports</title>
<c:url value="/assets" var="cssPath" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="${cssPath }/css/default.css" rel="stylesheet"/>
<link href="${cssPath }/css/sprint-report.css" rel="stylesheet" />
</head>
<body>
<h2 class="white-color text-center padding-top margin-top">Sprints ${team} Reports</h2>             
        <!-- PRICING TABLE STYLE 4-->
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-6 col-xs-12 float-shadow">        
                    <div class="price_table_container">
                        <div class="price_table_heading">Starter</div>
                        <div class="price_table_body">
                            <div class="price_table_row cost dark-text"><strong>Sprint</strong><span> 1</span></div>
                            <div class="price_table_row">12 Tarefas Planejadas</div>
                            <div class="price_table_row">5 Hotfix</div>
                            <div class="price_table_row">69 Pontos</div>
                            <div class="price_table_row">6 Tarefas da Gafisa</div>                                              
                        </div>
                        <a href="#" class="btn btn-dark btn-lg btn-block"></a>
                    </div>
                </div>
        
            </div>
        </div>
        <!-- PRICING TABLE STYLE 4-->        
        <div class="spacer"></div>
<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
<script>

</script>
</body>
</html>