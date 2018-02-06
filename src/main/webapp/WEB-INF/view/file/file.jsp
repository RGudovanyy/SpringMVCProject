<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags"%>

<page:template>
	<jsp:attribute name="title">Spring MVC project</jsp:attribute>

	<jsp:body>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Пример загрузки файла
						<small>pdf или excel</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">Пример загрузки файла</li>
					</ol>
				</div>
				<!--/. row -->

				<c:url value="/uploadFile" var="fileUploadControllerURL"/>
				<div class="row">
					<div class="col-lg-12">
						<p>Пример загрузки файла с помощью Spring MVC</p>
						<form action="${fileUploadControllerURL}" method="post" enctype="multipart/form-data">
							<table>
								<tr>
									<td><b>File:</b></td>
									<td><input type="file" name="file"></td>
									<td>input type="submit" value="Загрузить файл"</td>
								</tr>
							</table>
						</form>
						<br/>
						<c:url value="/excel" var="excelController">
						<c:url value="/pdf" var="pdfController">
						<a href="${excelController}">Excel</a>
						<br/>
						<a href="${pdfController}">PDF</a>

					</div>
				</div>

			</div>
			<!--/. row -->

		</div>
		<!--/. container -->
	</jsp:body>
</page:template>