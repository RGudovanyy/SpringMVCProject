<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="title" fragment="true" %>

<head>
    <title><jsp:invoke fragment="title"/></title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <link href="${bootstrap}" rel="stylesheet" />

    <!-- Custom CSS -->
    <spring:url value="resources/css/modern-business.css" var="startertemplate"/>
    <link href="${startertemplate}" rel="stylesheet" />

    <!-- Custom Fonts -->
    <spring:url value="resources/css/font-awesome.min.css" var="fontawesome"/>
    <link href="${fontawesome}" rel="stylesheet" />

    <!-- jQuery -->
    <spring:url value="resources/js/jquery.js" var="jqueryjs"/>
    <script src="${jqueryjs}"></script>

    <!-- Bootstrap Core JavaScript -->
    <spring:url value="resources/js/bootstrap.min.js" var="js"/>
    <script src="${js}"></script>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Main page</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <c:url value="/about.html" var="about"/>
                <li><a href="${about}">About</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <c:url value="/file.html" var="file"/>
                        <li>
                            <a href="${file}">Загрузка файла PDF и Excel</a>
                        </li>
                        <c:url value="/jdbc.html" var="jdbc"/>
                        <li>
                            <a href="${jdbc}">Работа с JDBC</a>
                        </li>
                        <c:url value="/email.html" var="email"/>
                        <li>
                            <a href="${email}">Отправка письма через Spring Mail API</a>
                        </li>
                        <c:url value="/orm.html" var="orm"/>
                        <li>
                            <a href="${orm}">Работа с ORM Hibernate</a>
                        </li>
                        <c:url value="/runtimeException.html" var="runtimeException"/>
                        <li>
                            <a href="${runtimeException}">Exception</a>
                        </li>
                        <c:url value="/jstl.html" var="jstl"/>
                        <li>
                            <a href="${jstl}">JSTL</a>
                        </li>
                        <c:url value="/redirectExample" var="redirectExample"/>
                        <li>
                            <a href="${redirectExample}">Redirect Example</a>
                        </li>
                        <c:url value="/scope.html" var="scope"/>
                        <li>
                            <a href="${scope}">Session Object Example</a>
                        </li>
                        <c:url value="/cookie.html" var="cookieView" />
                        <li>
                            <a href="${cookieView}">Cookie Example</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>


<jsp:doBody/>


<div class="container">
    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright © Your Website 2014</p>
            </div>
        </div>
    </footer>
</div>

</body>

</html> 