<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>


        <form action="calculatecarport" method="post">
            <div class="container light-grey">
                <h1>Vælg mål for din carport</h1>
                <div class="row">
                    <div class="col  form-group  mt-5 me-5 ms-5">
                        <select class="form-select" name="length">
                            <option selected>Længde</option>
                            <option> 700 </option>
                        </select>
                    </div>
                    <div class="col form-group  mt-5  me-5 ">
                        <select class="form-select" name="width">
                            <option selected>Bredde</option>
                            <option> 680 </option>
                        </select>
                    </div>

                    <div class="col-2 form-group mt-5 me-4">

                    </div>
                    <div class="row">
                        <div class="text-end mt-3 mb-3">
                            <button type="submit" value="calculate" class="btn btn-primary">Beregn
                            </button>
                        </div>
                    </div>
                </div>

            </div>
        </form>

    </jsp:body>

</t:pagetemplate>