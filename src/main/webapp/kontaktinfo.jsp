<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <div class="display-6 mb-5">Indtast dine kontakt oplysninger</div>

        <form action="requestcarportoffer" method="post">
            <div class="container">
                <div class="form-group col-md-6">
                    <label class="mb-2 mt-2" for="inputName">Fulde Navn</label>
                    <input type="text" class="form-control" id="inputName" name="name" required>
                </div>
                <div class="form-group col-md-6">
                    <label class="mb-2 mt-2" for="inputAddress">Adresse</label>
                    <input type="text" class="form-control" id="inputAddress" name="address" required>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="mb-2 mt-2" for="inputZip">Post Nr</label>
                        <input type="text" class="form-control" id="inputZip" name="zipcode" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="mb-2 mt-2" for="inputCity">By</label>
                        <input type="text" class="form-control" id="inputCity" name="city" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="mb-2 mt-2" for="PhoneNumber">Telefon Nr</label>
                        <input type="number" class="form-control" id="PhoneNumber" name="phonenumber" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="mb-2 mt-2" for="Email">Email</label>
                        <input type="email" class="form-control" id="Email" name="email" required>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input mt-4" type="checkbox" value="" id="invalidCheck2" required>
                        <label class="form-check-label mt-4" for="invalidCheck2">
                            <a href="#">Accepter vilkår og betingelser</a>
                        </label>
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