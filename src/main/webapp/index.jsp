<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <div class="containerlight-grey">

            <div class="row">
                <div class="display-6 mb-5"> Skrædersy din carport ud fra dine egne mål
                </div>

                <div class="col-6">
                    <div class="card">
                        <div class="card-body">
                            <p class="lead"><small>
                                Drømmer du om, at bilen holder i tørvejr?
                                Vil du gerne undgå frost på ruderne om vinteren?
                                Har du måske brug for et redskabsrum til dæk, græsslåmaskine, haveredskaber, grill m.m.?
                                Gør drømmen til virkelighed her i foråret.
                                Der er mange fordele ved selv at bygge en carport.
                                Du sparer både penge og får en lækker carport, der kan beskytte bilen.
                                Men hvilke behov har du? Hvad bør du i det hele taget overveje, inden du går i gang?
                            </small></p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <form action="calculatecarport" method="post">
                        <div class="row">
                            <h4 class="text-center">Vælg mål for din carport</h4>

                            <div class="col form-group  mt-5 me-5 ms-5">
                                <select class="form-select" name="length">
                                    <option selected>Længde</option>
                                    <option> 470</option>
                                    <option> 780</option>
                                    <option> 1090</option>
                                </select>
                            </div>

                            <div class="col form-group  mt-5  me-5 ">
                                <select class="form-select" name="width">
                                    <option selected>Bredde</option>
                                    <option> 300</option>
                                    <option> 600</option>
                                    <option> 900</option>
                                    <option> 1200</option>
                                </select>

                            </div>
                            <div class="text-end mt-3 mb-3">
                                <button type="submit" value="calculate" class="btn btn-primary">Beregn
                                </button>
                            </div>


                        </div>

                    </form>
                </div>


            </div>




        </div>

    </jsp:body>

</t:pagetemplate>