<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>



        <c:forEach var="carport" items="${sessionScope.carport.partList}">

            Her er måske en stolpe:
            ${carport}


        </c:forEach>



        <h1>Her kommer din carport skitse!</h1>
        <form action="calculatecarport">
        <div class="row">
            <div class="text-end mt-3 mb-3">
                <button type="submit" value="recalculate" class="btn btn-primary">Genberegn
                </button>
            </div>
        </div>
        </form>

        <form action="approvecarport" method="post">
        <div class="row">
            <div class="text-end mt-3 mb-3">
                <button type="submit" value="approve" class="btn btn-primary">Godkend
                </button>
            </div>
        </div>
        </form>


    </jsp:body>

</t:pagetemplate>