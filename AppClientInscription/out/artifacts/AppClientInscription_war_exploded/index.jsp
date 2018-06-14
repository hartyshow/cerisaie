<%--
  Created by IntelliJ IDEA.
  User: christian
  Date: 06/04/2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Header.jsp" %>
<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/foncControle.js"></script>

<div>
    <div class="container">
        <div class="form-group">
            <h4>Gestion des demandes d'inscription à des activités</h4>
            <BR> <BR>
            <b>Bienvenue sur la page d'accueil de gestion des demandes d'inscription à une prestation sportive du
                camping</b>
        </div>
        <div class="col-md-6">
            <img class="img-responsive imageAccueil" style="border:3px solid #f6f7ff;"
                 src="<c:url value="/resources/images/group-camping.jpg" />" alt="Logo Cerisaie"/>
        </div>
    </div>
</div>
</body>
</html>