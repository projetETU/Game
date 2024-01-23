<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
    }

    .container {
      max-width: 600px;
    }

    .form-group {
      margin-bottom: 20px;
    }
  </style>
  <title>Maladie</title>
</head>
<body>

<div class="container mt-5">
  <form method="post" action="Maladie.jsp">
    <div class="form-group">
      <label for="input1" class="form-label">Loha</label>
      <input type="number" class="form-control"  value="0"  name="loha" placeholder="Entrez un nombre entre 0 et 10" min="0" max="10">
    </div>
    
    <div class="form-group">
      <label for="input2" class="form-label">Tenda</label>
      <input type="number" class="form-control"  value="0"  name="tenda" placeholder="Entrez un nombre entre 0 et 10" min="0" max="10">
    </div>

    <div class="form-group">
      <label for="input2" class="form-label">Lelo</label>
      <input type="number" class="form-control"  value="0"  name="lelo" placeholder="Entrez un nombre entre 0 et 10" min="0" max="10">
    </div>
    
    <div class="form-group">
      <label for="input3" class="form-label">Caca</label>
      <input type="number" class="form-control"  value="0"  name="caca" placeholder="Entrez un nombre entre 0 et 10" min="0" max="10">
    </div>
    
    <div class="form-group">
      <label for="input4" class="form-label">Kibo</label>
      <input type="number" class="form-control"  value="0"  name="kibo" placeholder="Entrez un nombre entre 0 et 10" min="0" max="10">
    </div>
    
    <div class="form-group">
      <label for="input5" class="form-label">Fatigue</label>
      <input type="number" class="form-control"  value="0"  name="fatigue" placeholder="Entrez un nombre entre 0 et 10" min="0" max="10">
    </div>

    <div class="form-group">
      <label for="input6" class="form-label">Temperature</label>
      <input type="number" class="form-control"  value="0"  name="temperature" placeholder="Entrez un nombre entre 0 et 10" min="0" max="10">
    </div>
    
    <button type="submit" class="btn btn-success">Valider</button>
  </form>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
