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

                <h1>Visualiser le planning des activités déjà réservées</h1>

                <div class="form-group">
                    <label for="code_sport">Activité :</label>
                    <select class="form-control" id="code_sport" name="codeSport">
                        <c:forEach items="${sports}" var="sport">
                            <option value="${sport.codesport}">${sport.libellesport} - ${sport.unitetpssport}
                                (${sport.tarifunite}€/u)
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <script>$("#code_sport").change(function () {
                    var code = $("#code_sport").val();
                    $.ajax({
                        url: 'Controleur?action=getActivites',
                        data: {codeSport : code},
                        type: 'GET',

                        success : function (response) {

                            $("#tableau").empty();

                            $("#tableau").append("<tr><th>Date</th><th>NumeroSejour</th><th>nombreSeance</th><th>Prix</th></tr>");

                            for(var i = 2; i <= response.length-1; i++)
                            {
                                $("#tableau").append("<tr><td>"+response[i].datejour+"</td><td>"+response[i].numsej+"</td><td>"+response[i].nbloc+ " X " + response[1] +"</td><td>"+response[0] * response[i].nbloc+"</td></tr>");
                            }
                        },
                        error : function(){
                            console.log("erreur requete ajax");
                        }
                    });


                })</script>

                <div class="form-group">
                    <table id="tableau" class="table">



                    </table>
                </div>


            </div>
        </div>
    </div>
</form>
</body>
</html>
