<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>
        <form action="addmaterial" method="post">
        <div class="container ">
            <div class="display-6 text-center">Tilføj materiale</div>

            <div class="row">

                <div class="col-2"></div>
                <div class="col-8">
                    <table class="table table-striped ps-5">
                        <thead>
                        <tr>
                            <th>Produkt</th>
                            <th>Mængde</th>
                            <th>Enhed</th>
                            <th>Produktvariant</th>
                            <th>Pris</th>
                        </tr>
                        </thead>
                            <tr>
                                <div class="row">
                                    <td class="col-3">
                                        <input type="text" class="form-control" name="name">
                                    </td>

                                    <td class="col-2">
                                        <input type="number" class="form-control" name="quantity">
                                    </td>

                                    <td class="col-2">
                                        <input type="text" class="form-control" name="unit">
                                    </td>

                                    <td class="col-3">
                                        <input type="text" class="form-control" name="variant">
                                    </td>

                                    <td class="col-2">
                                        <input type="text" class="form-control" name="price">
                                    </td>


                                </div>

                            </tr>



                    </table>
                    <div class="text-end mt-3 mb-3">
                            <button type="submit" class="btn btn-primary">Opret
                            </button>
                    </div>

                </div>


                <div class="col-2"></div>

            </div>


        </div>
        </form>
    </jsp:body>

</t:pagetemplate>