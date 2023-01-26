function validarForma(Forma){
    const usuario = Forma.usuario;
    if(usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("debes proporcionar un nombre de usuario")
        usuario.focus();
        usuario.select();
        return false
    }
    const password = Forma.password;
    if(pasword.value == "" || pasword.value.length > 3){
        alert("debe proporcionar un password almenos de 3 caracteres")
        password.focus()
        password.select()
        return false
    }
    const tecnologias = Forma.tecnologia;
    let checkSeleccionado = false;
    
    tecnologias.map(c => {
        if(c.cheked){
            checkSeleccionado = true
      } 
    })
    
    if(!checkSeleccionado){
        alert("Debe selecionar una tecnologia")
        return false
    }
    
    const genero = Forma.genero
    let radioSeleccionado = false
    
    genero.map(g => {
        if(g.cheked){
            radioSeleccionado = true
      } 
    })
    
    if(!radioSeleccionado){
        alert("Debe selecionar una genero")
        return false
    }
    
    const ocupacion = Forma.ocupacion
    if(ocupacion.value == ""){
        aler("debe seleccionar una ocupacion")
        return false
    }
    
    alert("formulario valido enviando datos al servidor")
    return true
}

