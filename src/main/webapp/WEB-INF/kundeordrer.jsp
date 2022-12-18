<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <div class="container ">
            <div class="display-6 text-center mb-5">Kundeordrer</div>
            <div class="row">
                <div class="col-1"></div>
                <div class="col">
            <table class="table table-striped ps-5">
                <thead>
                <tr>
                    <th>Ordre Nummer</th>
                    <th>Carport</th>
                    <th>Pris</th>
                    <th>Design</th>
                    <th>Tilbud</th>
                    <th>Status</th>
                </tr>

                </thead>
                <c:forEach var="carport" items="${sessionScope.carportList}">
                <tr>
                    <div class="row">
                        <td class="col">
                            <p class="lead">
                                    ${carport.carportId}
                            </p>
                        </td>

                        <td class="col">
                            <p class="lead">
                                carport ${carport.length}cm x ${carport.width}cm
                            </p>
                        </td>

                        <td class="col">
                            <p class="lead">
                                    ${carport.carportFullPrice}kr.
                            </p>
                        </td>
                        <td class="col">
                            <form action="todesign" method="post">
                                <button type="submit" class="btn btn-primary" name="carportId" value="${carport.carportId}" >Se design
                                </button>
                            </form>
                        </td>

                        <td class="col">
                            <form action="toggleoffer" method="post">
                                <c:if test="${carport.offerStatus == false}">
                                    <button type="submit" class="btn btn-primary" name="carportId"
                                            value="${carport.carportId}">Send tilbud
                                    </button>
                                </c:if>
                                <c:if test="${carport.offerStatus == true}">
                                    <p class="lead greenColor"> Tilbud sendt </p>
                                </c:if>
                            </form>
                        </td>

                        <td class="col">
                            <c:if test="${carport.paymentStatus == false}">
                                <p class="lead redColor"> Ikke betalt </p>

                            </c:if>
                            <c:if test="${carport.paymentStatus == true}">
                                <p class="lead greenColor"> Betalt </p>
                            </c:if>

                        </td>

                        </c:forEach>
                    </div>

                </tr>

            </table>

                <div class="col-1"></div>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>