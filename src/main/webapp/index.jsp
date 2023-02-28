<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Cliente</title>
</head>
<body>
<div>
    <form action="cadastrar-cliente" method="post">
        <p>Informe o nome: <input name="nome" required />  </p>
        <p>Informe o CPF: <input name="cpf" required />  </p>
        <p><input type="submit" value="Cadastrar"></p>
    </form>
    <a href="historico.jsp">Listar Clientes</a>
</div>
</body>
</html>