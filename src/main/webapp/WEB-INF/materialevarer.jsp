<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container ">
            <div class="display-6 text-center">Materialeliste</div>

            <div class="row">

                <div class="col-2"></div>
                <div class="col-8">
                    <table class="table table-striped ps-5">
                        <thead>
                        <tr>
                            <th>Produkt</th>
                            <th>Mængde</th>
                            <th>Pris</th>
                            <th></th>
                        </tr>
                        <div class="text-end mt-3 mb-3">
                            <form action="toaddmaterial">
                                <button type="submit" value="addNewMaterial" class="btn btn-primary">Opret nyt materiale
                                </button>
                            </form>
                        </div>
                        </thead>
                        <c:forEach var="material" items="${sessionScope.materialArrayList}">
                            <tr>
                                <div class="row">
                                    <td class="col-3">
                                            ${material.materialName}
                                    </td>

                                    <td class="col-3">
                                            ${material.materialQuantity}${material.unitType}
                                    </td>

                                    <td class="col-3">
                                            ${material.materialPrice}kr.
                                    </td>

                                    <td class="col">
                                        <form action="deletematerial" method="post">
                                            <button type="submit" value="${material.materialId}" class="btn btn-primary"
                                                    name="material_id">Slet
                                            </button>
                                        </form>
                                    </td>


                                </div>

                            </tr>
                        </c:forEach>


                    </table>
                    <div class="text-end mt-3 mb-3">
                        <form action="toaddmaterial">
                            <button type="submit" value="addNewMaterial" class="btn btn-primary">Opret nyt materiale
                            </button>
                        </form>
                    </div>

                </div>


                <div class="col-2"></div>

            </div>


        </div>

    </jsp:body>

</t:pagetemplate>