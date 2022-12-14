<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <div class="container ">
            <div class="display-6 text-center">Ordredesign</div>

            <div class="row">
                <div class="col">

                    <form action="calculatecarport">
                        <div class="text-left mt-3 mb-3">
                            <button type="submit" value="recalculate" class="btn btn-primary">Genberegn
                            </button>
                        </div>
                    </form>
                </div>
                <div class="col">
                    <form action="approvecarport" method="post">
                        <div class="text-end mt-3 mb-3">
                            <button type="submit" value="approve" class="btn btn-primary">Godkend
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <div class="text-center">
            <p class="lead"><strong> Carport set fra siden</strong></p>
            <div class="card mb-5">
                <div class="card-body">
                        ${requestScope.svgCarportSideView}
                        ${requestScope.svgCarportSideViewWithShed}

                </div>
            </div>
        </div>

        <div class="text-center">
            <p class="lead"><strong> Carport set oppefra</strong></p>
            <div class="card">
                <div class="card-body">
                        ${requestScope.svgCarportTopView}
                        ${requestScope.svgCarportTopViewWithShed}
                </div>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>