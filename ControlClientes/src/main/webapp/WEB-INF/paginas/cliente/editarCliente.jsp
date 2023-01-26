<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <title>Editar cliente</title>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="../comunes/cabecero.jsp" />

        <form class="was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}" method="post">

            <!-- botones de navegacion -->
            <jsp:include page="../comunes/botonesNavegacionEdicion.jsp" />

            <section id="details" >
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar cliente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="modal-body">
                                        <div class="form-gruop">
                                            <label for="nombre">Nombre</label>
                                            <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                        </div>
                                        <div class="form-gruop">
                                            <label for="apellido">Apellido</label>
                                            <input type="tel" class="form-control" name="apellido" required value="${cliente.apellido}">
                                        </div>
                                        <div class="form-gruop">
                                            <label for="email">email</label>
                                            <input type="email" class="form-control" name="email" required value="${cliente.email}">
                                        </div>
                                        <div class="form-gruop">
                                            <label for="telefono">telefono</label>
                                            <input type="text" class="form-control" name="telefono" required value="${cliente.telefono}">
                                        </div>
                                        <div class="form-gruop">
                                            <label for="saldo">saldo</label>
                                            <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}" step="any">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <!-- Footer -->
        <jsp:include page="../comunes/piePagina.jsp" />
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/86e3524465.js" crossorigin="anonymous"></script>
</html>

