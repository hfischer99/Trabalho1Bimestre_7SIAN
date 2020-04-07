
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
<title>Adicionar nova peca</title>
</head>
<body>
<form class="form-horizontal" method="POST" action='PecaController' name="frmAddPeca">
<fieldset>


<!-- Form Name -->
<legend>Cadastro de Peças</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Peça ID</label>  
  <div class="col-md-4">
  <input id="" type="text" placeholder="ID da peça" readonly="readonly" value="<c:out value="${peca.id}" />" name="pecaId" class="form-control input-md">   
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Nome</label>  
  <div class="col-md-4">
  <input id="textinput" name="nome" type="text" placeholder="Nome" value="<c:out value="${peca.nome}" />" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Descrição</label>  
  <div class="col-md-4">
  <input id="textinput" name="descricao" type="text" placeholder="Descrição" value="<c:out value="${peca.desc}" />"  class="form-control input-md" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
        <label class="col-md-4 control-label" for="selectbasic">Tipo</label>
        <div class="col-md-4">
        <select name="cod_tipo" class="form-control">
    	<c:forEach items="${tipos}" var="tipos">
        <option value="<c:out value="${tipos.id}"/>"><c:out value="${tipos.categoria}" /></option>    
        </option>
     	</c:forEach>
		</select>
		</div>
		</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Valor</label>  
  <div class="col-md-4">
  <input id="textinput" name="valor" type="text" placeholder="Valor" value="<c:out value="${peca.valor}" />" class="form-control input-md" required="">
    
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