<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <h1>Skriv dine kontakt oplysninger</h1>

        <form action="requestcarportoffer" method="post">
        <div class="row">
            <div class="text-end mt-3 mb-3">
                <button type="submit" value="recalculate" class="btn btn-primary">Bestil tilbud
                </button>
            </div>
        </div>
        </form>



    </jsp:body>

</t:pagetemplate>