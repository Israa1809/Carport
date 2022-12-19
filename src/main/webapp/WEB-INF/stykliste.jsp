<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container-fluid">
            <h2 class="text-center mb-5"> Stykliste for carport ${sessionScope.carport.width} cm
                x ${sessionScope.carport.length} cm</h2>
            <div class="row">
                <div class="col-7">
                    <div class="text-center mb-2">
                        <p class="lead"><strong> Carport set fra siden</strong></p>
                            ${requestScope.svgCarportSideView}
                    </div>
                    <div class="text-center">
                        <p class="lead"><strong> Carport set oppefra</strong></p>
                            ${requestScope.svgCarportTopView}
                    </div>
                </div>
                <div class="col">
                    <div class="text-end">
                        <p class="lead">
                            Ordre #${sessionScope.carportId}
                        </p>
                    </div>
                    <table class="table table-striped ps-5">
                        <thead>
                        <tr>
                            <th>Mængde</th>
                            <th>Enhed</th>
                            <th>Materiale</th>
                        </tr>
                        </thead>
                        <c:forEach var="part" items="${sessionScope.partList}">
                            <tr>
                                <div class="row">
                                    <td class="col">
                                            ${part.partQuantity} x
                                    </td>
                                    <td class="col">
                                            ${part.material.materialQuantity}${part.material.unitType}
                                    </td>
                                    <td class="col">
                                            ${part.material.materialName}
                                    </td>
                                </div>
                            </tr>
                        </c:forEach>
                    </table>
                    <p class="lead text-end"><strong>I alt: ${sessionScope.carport.carportFullPrice} kr.</strong></p>
                </div>
            </div>
        </div>
    </jsp:body>
</t:pagetemplate>