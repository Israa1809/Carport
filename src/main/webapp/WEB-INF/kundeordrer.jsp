<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container ">
            <div class="display-6 text-center">Kundeordrer</div>

            <form action="todesign" method="post">
            <div class="text-end mt-3 mb-3">
                <button type="submit" class="btn btn-primary">Se design
                </button>
            </div>
            </form>


            </div>


        </div>

    </jsp:body>

</t:pagetemplate>