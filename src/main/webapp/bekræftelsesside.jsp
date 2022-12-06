<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <div class="display-6 text-center mb-4">Tak for din bestilling</div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col">
                <div class="card">
                    <div class="card-body">
<%--                        Ordrenummer skal erstattes fra db--%>
                        <p class="lead"> Ordrenummer #4321 </p>

                        <p class="lead"> Tak for din bestilling. </p>

                        <p class="lead">Du vil blive ringet op af en af vores rådgivere indenfor 3 arbejdsdage.</p>

                        <p class="lead">Du modtager en bekræftelsesmail, husk at tjekke dit spamfilter.</p>

                        <p class="lead">Mvh.</p>

                        <p class="lead">Johannes Fog</p>
                    </div>
                </div>
            </div>
            <div class="col-3"></div>
        </div>


    </jsp:body>

</t:pagetemplate>