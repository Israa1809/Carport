<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <h1>Skriv dine kontakt oplysninger</h1>


        <form action="requestcarportoffer" method="post">
            <div class="container">
                <div class="form-group col-md-6">
                    <label for="inputName">Fulde Navn</label>
                    <input type="text" class="form-control" id="inputName" name="name">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputAddress">Adresse</label>
                    <input type="text" class="form-control" id="inputAddress" name="address">
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputZip">Post Nr</label>
                        <input type="text" class="form-control" id="inputZip" name="zipcode">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputCity">By</label>
                        <input type="text" class="form-control" id="inputCity" name="city">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="PhoneNumber">Telefon Nr</label>
                        <input type="number" class="form-control" id="PhoneNumber" name="phonenumber">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="Email">Email</label>
                        <input type="email" class="form-control" id="Email" name="email">
                    </div>
                </div>
                <div class="text-end mt-3 mb-3 col-md-6">
                    <button type="submit" value="recalculate" class="btn btn-primary">Bestil tilbud
                    </button>
                </div>
            </div>
        </form>



    </jsp:body>

</t:pagetemplate>