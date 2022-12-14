<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container ">
            <div class="display-6 text-center mb-5">Ordrevisning</div>


            <div class="row">
                <div class="col-8">
                    <h4>
                        Her kommer der en tegning af carporten
                    </h4>

                </div>
                <div class="col-4">
                    <div class="card">
                        <div class="card-body">
                            <p class="lead"> Længde ${sessionScope.carport.length}cm </p>
                            <p class="lead"> Bredde ${sessionScope.carport.width}cm </p>
                            <c:if test="${sessionScope.carport.offerStatus == true}">
                                <p class="lead"> Pris  ${sessionScope.totalCarportPrice}kr.</p>
                            </c:if>
                        </div>
                    </div>

                </div>
            </div>

            <div class="text-end mt-3 mb-3">
                <form action="togglepayment" method="post">
                    <c:if test="${sessionScope.carport.offerStatus == true}">
                        <button type="submit" class="btn btn-primary" name="carportId" value="${sessionScope.carportId}">Betal
                        </button>
                    </c:if>

                </form>
            </div>

        </div>


    </jsp:body>

</t:pagetemplate>