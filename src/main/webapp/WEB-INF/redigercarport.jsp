<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container ">

            <form action="toeditcarport">
                <div class="text-left mt-3 mb-3">
                    <button type="submit" class="btn btn-primary">Tilbage
                    </button>
                </div>
            </form>

            <div class="display-6 text-center">Rediger carport</div>


            HER STARTER DET NYE
            <form action="editcarportmeasurements" method="post">
                <div class="container light-grey">
                    <h1>Vælg mål for din carport</h1>
                    <div class="row">
                        <div class="col  form-group  mt-5 me-5 ms-5">
                            <select class="form-select" name="length">
                                <option selected>Længde</option>
                                <option> 780 </option>
                                <option> 1000 </option>
                                <option> 1300 </option>
                                <option> 1560 </option>
                            </select>
                        </div>
                        <div class="col form-group  mt-5  me-5 ">
                            <select class="form-select" name="width">
                                <option selected>Bredde</option>
                                <option> 600 </option>
                                <option> 610 </option>
                                <option> 800 </option>
                                <option> 900 </option>
                                <option> 1200 </option>
                            </select>
                        </div>

                        <div class="col-2 form-group mt-5 me-4">

                        </div>
                        <div class="row">
                            <div class="text-end mt-3 mb-3">
                                <button type="submit" class="btn btn-primary" name="carportId" value="${carport.carportId}" >Opdater carportdesign
                                </button>
                            </div>
                        </div>
                    </div>

                </div>
            </form>
            HER SLUTTER DET NYE

            HER STARTER DET ALLERNYESTE
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

                    <c:forEach var="part" items="${requestScope.partList}">
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
            HER SLUTTER DET ALLERNYESTE




            <div class="text-end mt-3 mb-3">
                <button type="submit" class="btn btn-primary">Opdater honorarpris
                </button>
            </div>


        </div>


        </div>

    </jsp:body>

</t:pagetemplate>