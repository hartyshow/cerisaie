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
<script>
    function Chargement()
    {
        var obj = document.getElementById("id_erreur");
        if (obj.value!='')
            alert('Erreur signalée  : "'+obj.value+"'");
    }
</script>

<form action='Controleur?action=envoiInscription'  method="post">
    <div>
        <div class="container">
            <div class="well">

                <h1>S'inscrire à une activité</h1>

                <div class="form-group">
                    <label for="code_sport">Activité à réserver</label>
                    <select class="form-control" id="code_sport" name="codeSport">
                        <c:forEach items="${sports}" var="sport">
                            <option value="${sport.codesport}">${sport.libellesport} - ${sport.unitetpssport}
                                (${sport.tarifunite}€/u)
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="num_emplacement">Numéro de votre séjour</label>
                    <select class="form-control" id="num_emplacement" name="numSejour">
                        <c:forEach items="${sejours}" var="sejour">
                            <option value="${sejour.numsej}">N°${sejour.numsej} - Emplacement ${sejour.numempl} - Numéro
                                Client ${sejour.numcli}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="datejour">Date de réservation</label>
                    <input type="text" class="form-control" name="datejour" id="datejour" value="">
                </div>
                <script>$("#datejour").datepicker({dateFormat: 'yy-mm-dd'});</script>

                <div class="form-group">
                    <label for="unite">Combien d'unité de temps</label>
                    <input type="number" class="form-control" name="unite" id="unite" min="1" value="1">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                        Valider
                    </button>
                    <button type="button" class="btn btn-default btn-primary"
                            onclick="{ window.location = 'index.jsp'; }">
                        <span class="glyphicon glyphicon-remove"></span> Annuler
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
