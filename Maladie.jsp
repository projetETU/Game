<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "docteur.Docteur"  %>
<%@ page import = "medicament.Medicament"  %>
<%@ page import = "databases.DatabaseUtil"  %>
<%@ page import = "java.sql.ResultSet"  %>

<%
    Docteur docteur = new Docteur();
    Medicament medicament = new Medicament();
    DatabaseUtil data = new DatabaseUtil();

    medicament.setLoha(Integer.parseInt(request.getParameter("loha")));
    medicament.setLelo(Integer.parseInt(request.getParameter("lelo")));
    medicament.setTenda(Integer.parseInt(request.getParameter("tenda")));
    medicament.setKibo(Integer.parseInt(request.getParameter("kibo")));
    medicament.setCaca(Integer.parseInt(request.getParameter("caca")));
    medicament.setTemperature(Integer.parseInt(request.getParameter("temperature")));
    medicament.setFatigue(Integer.parseInt(request.getParameter("fatigue")));

    docteur.setLoha(Integer.parseInt(request.getParameter("loha")));
    docteur.setLelo(Integer.parseInt(request.getParameter("lelo")));
    docteur.setTenda(Integer.parseInt(request.getParameter("tenda")));
    docteur.setKibo(Integer.parseInt(request.getParameter("kibo")));
    docteur.setCaca(Integer.parseInt(request.getParameter("caca")));
    docteur.setTemperature(Integer.parseInt(request.getParameter("temperature")));
    docteur.setFatigue(Integer.parseInt(request.getParameter("fatigue")));
    docteur.setMaladie();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <title>Résultats du Test</title>
    
</head>
<body class="text-center">

<div class="container mt-5">

    <div class="card mx-auto" style="max-width: 400px;">
        <div class="card-body">
            <h2 class="card-title" id="test"> <%= docteur.getMaladie() %></h2>
        </div>
    </div>
</div>
<div class="container mt-5">
    <div class="table-responsive">
        <table class="table" id="medicamentTable">
            <thead>
                <tr>
                    <th scope="col">Medicament</th>
                    <!-- <th scope="col">Loha</th>
                    <th scope="col">Lelo</th>
                    <th scope="col">Tenda</th>
                    <th scope="col">Kibo</th>
                    <th scope="col">Caca</th>
                    <th scope="col">Fatigue</th>
                    <th scope="col">Temperature</th> -->
                    <th scope="col">Prix</th>

                </tr>
            </thead>
            <tbody>
                    <%   
                    Medicament m = new Medicament();
                    Medicament[] medicaments = m.medicament();
                    for (Medicament me: medicaments ) {
                    %>
                <tr>
                    
                    <td><%= me.getMedicament()  %></td>

                    <td><%= me.getPrix()  %> Ar</td>

                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

</body>
<style>
    .total{
        margin-left: 900px;
    }
</style>
<script>
    var table = document.getElementById("test");
    var test = document.getElementById("medicamentTable");
    if (table.innerText === "TSY MARARY") {
        tes.style.display = "none";
    }
    console.log(table.innerText);
</script>

</html>
