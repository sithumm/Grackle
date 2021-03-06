<%-- 
    Document   : index
    Created on : Nov 9, 2013, 9:26:10 PM
    Author     : sithum
--%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <%@include file="WEB-INF/jspf/head.jspf" %>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row-fluid">

                <div class="row-fluid">
                    <div class="span12 center login-header">
                        <h2><fmt:message key="grackle.welcome" /></h2>
                    </div><!--/span-->
                </div><!--/row-->

                <div class="row-fluid">
                    <div class="well span5 center login-box">
                        <div class="alert alert-info">
                            <fmt:message key="grackle.welcome.instruction" />
                        </div>
                        <form class="form-horizontal" action="dashboard.jsp" method="post">
                            <fieldset>
                                <div class="input-prepend" title="Username" data-rel="tooltip">
                                    <span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10" name="username" id="username" type="text" value="admin" />
                                </div>
                                <div class="clearfix"></div>

                                <div class="input-prepend" title="Password" data-rel="tooltip">
                                    <span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="password" id="password" type="password" value="admin123456" />
                                </div>
                                <div class="clearfix"></div>

                                <div class="input-prepend">
                                    <label class="remember" for="remember"><input type="checkbox" id="remember" /><fmt:message key="grackle.welcome.remember" /></label>
                                </div>
                                <div class="clearfix"></div>

                                <p class="center span5">
                                    <button type="submit" class="btn btn-primary"><fmt:message key="grackle.login" /></button>
                                </p>
                            </fieldset>
                        </form>
                    </div><!--/span-->
                </div><!--/row-->
            </div><!--/fluid-row-->

        </div><!--/.fluid-container-->
    </body>
</html>
