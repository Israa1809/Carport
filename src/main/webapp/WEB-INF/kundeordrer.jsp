<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        her!
        ${requestScope.size()}

        <div class="container ">
            <div class="display-6 text-center">Kundeordrer</div>
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
                <c:forEach var="carport" items="${requestScope.carportList}">
                    <tr>
                        <div class="row">
                            <td class="col">
                                    ${carport.carportId}
                            </td>

                            <td class="col">
                                carport ${carport.length}cm x ${carport.width}cm
                            </td>

                            <td class="col">
                                    ${carport.materialFullPrice}
                            </td>
                            <td class="col">
                                <form action="todesign" method="post">
                                    <button type="submit" class="btn btn-primary">Se design
                                    </button>
                                </form>
                            </td>

                            <td class="col">
                                tiny int tilbud
                            </td>

                            <td class="col">
                                tiny int betalt
                            </td>


                        </div>

                    </tr>
                </c:forEach>

            </table>
        </div>

    </jsp:body>

</t:pagetemplate>