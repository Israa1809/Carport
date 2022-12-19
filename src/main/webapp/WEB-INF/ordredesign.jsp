<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container ">
            <div class="display-6 text-center">Ordredesign</div>
            <div class="row">
                <div class="col">
                    <form action="tocustomerorders">
                        <div class="text-left mt-3 mb-3">
                            <button type="submit" class="btn btn-primary">Tilbage
                            </button>
                        </div>
                    </form>
                </div>
                <div class="col">
                    <form action="toeditcarport" method="post">
                        <div class="text-end mt-3 mb-3">
                            <button type="submit" class="btn btn-primary" name="carportId" value="${carport.carportId}">
                                Rediger carport
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">

                <div class="card col-6 mb-4">
                    <div class="card-body">
                            ${requestScope.customer.customerName} <br>

                            ${requestScope.customer.address} <br>

                            ${requestScope.customer.postalCode} ${requestScope.customer.city} <br>

                            ${requestScope.customer.email} <br>

                            ${requestScope.customer.phoneNumber} <br>
                    </div>
                </div>

                    ${requestScope.svgCarportTopView}
            </div>


            <div class="col-6">
                <table class="table table-striped ps-5">
                    <thead>
                    <div class="text-center">

                        Stykliste for carport ${requestScope.carport.width} cm
                        x ${requestScope.carport.length} cm
                    </div>
                    </thead>

                    <thead>
                    <tr>
                        <th>Materiale</th>
                        <th>Pris</th>

                    </tr>
                    </thead>

                    <c:forEach var="part" items="${requestScope.partlist}">
                        <tr>
                            <div class="row">
                                <td class="col">
                                        ${part.partQuantity}
                                    x ${part.material.materialName} ${part.material.materialQuantity}${part.material.unitType}
                                </td>

                                <td class="col">
                                        ${part.partPrice}kr
                                </td>
                            </div>
                        </tr>
                    </c:forEach>

                </table>
                <p class="lead text-end"> I alt ${requestScope.carport.carportFullPrice} kr.</p>
            </div>
        </div>
        </div>
    </jsp:body>

</t:pagetemplate>