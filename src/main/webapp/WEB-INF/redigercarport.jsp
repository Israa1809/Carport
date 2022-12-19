<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="container ">

        <form action="tocustomerorders">
            <div class="text-left mt-3 mb-3">
                <button type="submit" class="btn btn-primary">Tilbage
                </button>
            </div>
        </form>

        <div class="display-6 text-center mb-5">Rediger carport</div>

        <form action="editcarportmeasurements" method="post">

            <h3>Vælg nye mål for carporten</h3>
            <div class="row">
                <div class="col  form-group  mt-2 me-5 ms-0">
                    <select class="form-select" name="length">
                        <option selected>Længde</option>
                        <option> 780</option>
                        <option> 1000</option>
                        <option> 1300</option>
                        <option> 1560</option>
                    </select>
                </div>
                <div class="col form-group  mt-2  me-5 ">
                    <select class="form-select" name="width">
                        <option selected>Bredde</option>
                        <option> 600</option>
                        <option> 610</option>
                        <option> 800</option>
                        <option> 900</option>
                        <option> 1200</option>
                    </select>
                </div>
                <div class="col form-group mt-2 me-5">
                    <div class="text-left mb-3">
                        <button type="submit" class="btn btn-primary" name="carportId"
                                value="${carport.carportId}">Opdater carportdesign
                        </button>
                    </div>
                    <p class="mt-3"><small>
                            ${requestScope.errormessage}
                    </small></p>
                </div>

            </div>
        </form>

        <div class="row">
            <div class="col-sm-6">
                <div class="card" style="border: none">
                    <div class="card-body">
                        <table class="table table-striped ps-5">
                            <thead>
                            <p class="lead text-center mb-3">
                                Stykliste for carport <b>${requestScope.carport.width} cm
                                x ${requestScope.carport.length} cm</b>
                            </p>
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

                            <div class="row">
                                <td class="col">
                                    Samlet materialepris
                                </td>

                                <td class="col">
                                        ${requestScope.carport.materialFullPrice}kr
                                </td>
                            </div>

                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card" style="border: none">
                    <div class="card-body mt-4">
                        <hr>
                        <form action="editfeeprice" method="post">
                            <p class="text-center">
                            Ønsker du at redigere rådgivningshonoraret, så indtast den nye pris her:
                            <br>

                            <input class="text-center mt-3" style="font-weight: bold;" type="text" id="feePrice" name="feePrice" value="${requestScope.carport.feePrice}"
                                   minlength="4"
                                   maxlength="8" size="10">
                            <input type="hidden" id="carportId" name="carportId" value="${carport.carportId}">
                            </p>


                            <div class="text-center mt-3 mb-3">
                                <button type="submit" class="btn btn-primary" name="feePrice" value="feePrice">Opdater
                                    honorarpris
                                </button>
                            </div>

                            <p class="text-center">
                                Samlet materialepris: <b>I alt ${requestScope.carport.materialFullPrice} kr.</b>
                            </p>


                            <p class="text-center">
                            Rådgivningshonorar: <b>I alt ${requestScope.carport.feePrice} kr.</b>
                            </p>
                            <hr>
                            <p class="text-center">
                            SAMLET PRIS: <b>I alt ${requestScope.carport.carportFullPrice} kr.</b>
                            </p>

                        </form>
                    </div>
                </div>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>