<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-secondary btn-block">
                    <i class="fa fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn bg-success btn-block">
                    <i class="fas fa-check"></i> Editar cliente
                </button>
            </div>
            <div class="col-md-3">
                <a class="btn btn-danger btn-block" href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}">
                    <i class="fa fa-trash"></i> Eliminar cliente
                </a>
            </div>
        </div>
    </div>
</section>