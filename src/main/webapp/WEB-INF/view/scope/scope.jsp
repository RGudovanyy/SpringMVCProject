<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags"%>

<page:template>
	<jsp:body>
		 <!-- Page Content -->
        <div class="container">
        	<!-- Page Heading/Breadcrumbs -->
        	<div class="row">
        		<div class="col-lg-12">
        			<h1 class="page-header">JSTL в Spring
        				<small>JSTL Example</small>
        			</h1>
        			<ol class="breadcrumb">
        				<li><a href="index.html">Home</a>					
        				</li>
        				<li class="active">Java Standard Tag Library</li>	
        			</ol>
        		</div>
        	</div>
        	<!-- /.row -->


        	<c:url value="/scopeSession" var="scopeSession"/>
        	<c:url value="/invalidateSession" var="invalidateSession"/>
        	<c:url value="/scopeRequest" var="scopeRequest"/>
        	<c:url value="/file.html" var="file"/>

        	<!-- Content Row-->
        	<div class="row">
        		<div class="col-lg-12">
        			<p>Объект в сессии</p>
        			<p><a href="${scopeSession}">Set object in a session</a></p>
        			<p><a href="${invalidateSession}">Invalidate session</a></p>
        			<p><b>Session scope attribute:</b>${sessionScope.sessionObject}</p>
        			<br/>

        			<p>Объект в области видимости</p>
        			<a href="${scopeRequest}">Set object in request</a>
        			<p><b>Request attribute:</b>${requestScope.requestObject}</p>
        			<br/>

        			<p><a href="${file}">Проверить на другой странице</a></p>
        		</div>

        	</div>
        	<!-- /.row -->
        	<hr>


        </div>
	</jsp:body>
</page:template>



