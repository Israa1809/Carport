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


            <div class="display-6 text-center">Ordredesign</div>
            <form action="toeditcarport" method="post">
                <div class="text-end mt-3 mb-3">
                    <button type="submit" class="btn btn-primary">Rediger carport
                    </button>
                </div>
            </form>

        </div>


        </div>

    </jsp:body>

</t:pagetemplate>