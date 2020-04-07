
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Adicionar Nova Categoria</title>
</head>
<body>
<form class="form-horizontal" method="POST" action='TipoController' name="frmAddTipo">
<fieldset>


<!-- Form Name -->
<legend>Cadastro de Categoria</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Categoria ID</label>  
  <div class="col-md-4">
  <input id="" type="text" placeholder="ID da Categoria" readonly="readonly" value="<c:out value="${tipo.id}" />" name="tipoId" class="form-control input-md">   
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Nome da Categoria</label>  
  <div class="col-md-4">
  <input id="textinput" name="categoria" type="text" placeholder="Nome" value="<c:out value="${tipo.categoria}" />" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="btn1"></label>
  <div class="col-md-4">
    <button id="btn1" name="btn1" type="submit" value="Submit" class="btn btn-primary">Cadastrar</button>
  </div>
</div>

</fieldset>
</form>

</body>
</html>