
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    <title>Peças</title>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
<body>
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"></a>
     <div class="topnav">
  <a type="button" class="btn btn-light" href="PecaController?action=listPeca">PEÇAS</a>
  <a type="button" class="btn btn-light" href="TipoController?action=listTipos">CATEGORIAS</a>
	</div>
    </div>
    
  </div>
</nav>

    <!--Table-->
<table id="tablePreview" class="table table-sm table-striped table-bordered">
<!--Table head-->
  <thead>
     <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descricao</th>
                <th>Tipo</th>
                <th>Valor</th>
                <th colspan=2>Ação</th>
            </tr>
  </thead>
  <!--Table head-->
  <!--Table body-->
 <tbody>
            <c:forEach items="${pecas}" var="peca">
                <tr>
                    <td><c:out value="${peca.id}" /></td>
                    <td><c:out value="${peca.nome}" /></td>
                    <td><c:out value="${peca.desc}" /></td>
                    <td><c:out value="${peca.tipo}" /></td>
					<td><c:out value="${peca.valor}" /></td>
                    <td><a href="PecaController?action=edit&pecaId=<c:out value="${peca.id}"/>">Alterar</a></td>
                    <td><a href="PecaController?action=delete&pecaId=<c:out value="${peca.id}"/>">Deletar</a></td>
                </tr>
            </c:forEach>            
     

  		          

        </tbody>
        
        
        
  <!--Table body-->
</table>
<a class="btn btn-primary" href="PecaController?action=insert" role="button" class="btn btn-success">Cadastrar Peça</button>  
<!--Table-->
</body>
</html>