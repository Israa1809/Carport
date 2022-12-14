<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container ">
            <div class="display-6 text-center mb-5">Stykliste</div>
            <div class="row">
                <div class="col-6">
                    <h4>
                        Her kommer der en tegning af carporten
                    </h4>

                </div>
                <div class="col-6">

                    <div class="card">
                        <th class="text-center">Stykliste for carport ${sessionScope.carport.width} cm
                            x ${sessionScope.carport.length} cm
                        </th>
                        <div class="card-body">

                            <table class="table table-striped ps-5">
                                <thead>
                                <tr>
                                    <th>Mængde</th>
                                    <th>Enhed</th>
                                    <th>Materiale</th>
                                    <th>Pris</th>
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
                                                    carport ${part.material.materialName}
                                                </td>
                                                <td class="col">
                                                        ${part.partPrice}kr
                                                </td>
                                            </div>
                                        </tr>
                                    </c:forEach>





                            </table>
                            <p class="lead text-end"> I alt ${sessionScope.carport.materialFullPrice} kr.</p>
                        </div>
                    </div>

                </div>
            </div>


        </div>


    </jsp:body>

</t:pagetemplate>