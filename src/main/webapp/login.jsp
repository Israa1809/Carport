<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>


        <form action="login" method="post">
        <div class="container shadow min-vh-100 py-2 pt-4">
            <div class="container mt-3">
                <div class="row d-flex justify-content-center">
                    <div class="col-md-6">
                        <div class="card px-5 py-5" id="form1">
                            <form action="login" method="post">
                                <div class="mb-3">
                                    <label for="username" class="form-label">Ordrenummer</label>
                                    <input type="text" class="form-control" id="username" name="username">
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Telefonnummer</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                <div class="text-center">
                                    <button type="submit" value="log-in " class="btn btn-primary">Log på</button>
                                </div>
                            </form>
                            <p class="text-center mt-3"><small>
                                    ${requestScope.errormessage}
                            </small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>

<%--        <h3>Log på</h3>--%>

<%--        <div class="text-center">--%>
<%--        <form action="login" method="post">--%>
<%--            <input type="text"  class="mx-4" id="username" name="username" placeholder="Ordrenummer"/>--%>
<%--            <input type="password" class="mx-4"  id="password" name="password" placeholder="Telefonnummer"/>--%>
<%--            <input type="submit" class="btn btn-primary"  value="Log in"/>--%>
<%--        </form>--%>
<%--        </div>--%>
    </jsp:body>
</t:pagetemplate>