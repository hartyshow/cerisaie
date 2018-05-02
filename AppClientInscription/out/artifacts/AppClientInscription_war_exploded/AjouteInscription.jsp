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
<script>
    function Chargement()
    {
        var obj = document.getElementById("id_erreur");
        if (obj.value!='')
            alert('Erreur signalée  : "'+obj.value+"'");
    }
</script>
<script src="js/js_verif.js" type="text/javascript"></script>

<form   action='Controleur?action=envoiInscription'  method='post' onsubmit="return verif(this);">
<div>
    <div class="container">
        <div class="well">

            <h1>S'inscrire à une activité</h1>
            <div class="form-group">
                <label for="codesport">Code du sport</label>
                <input type="text" class="form-control" name="codesport" id="codesport">
            </div>

            <div class="form-group">
                <label for="nbloc">Nombre de blocs</label>
                <input type="number" class="form-control" name="nbloc" id="nbloc" min="1">
            </div>

            <div class="form-group">
                <label for="numsejour">Numéro séjour</label>
                <input type="number" name="numsejour" id ="numsejour" class="form-control" min="0">
            </div>

            <div class="form-group">
                <label for="datejour">Adresse</label>
                <input type="text" class="form-control" name="datejour" id="datejour" value="">
            </div>
            <script>$( "#datejour" ).datepicker();</script>

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
