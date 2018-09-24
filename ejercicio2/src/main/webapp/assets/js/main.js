/**
 * Valida el RUT bajo formato XXXXXX-X
 * 
 * Cortesía de: http://cesarg.cl/validador-de-rut-chileno-con-javascript/
 */
var Fn = {
    validaRut : function (rutCompleto) {
        rutCompleto = rutCompleto.replace("‐","-");
        if (!/^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test( rutCompleto ))
            return false;
        var tmp     = rutCompleto.split('-');
        var digv    = tmp[1]; 
        var rut     = tmp[0];
        if ( digv == 'K' ) digv = 'k' ;
        
        return (Fn.dv(rut) == digv );
    },
    dv : function(T){
        var M=0,S=1;
        for(;T;T=Math.floor(T/10))
            S=(S+T%10*(9-M++%6))%11;
        return S?S-1:'k';
    }
}

/**
 * Valida el rut al momento de cambiar un valor.
 */
$("#rut").change(function(){
	var rut = document.getElementById("rut");
	
    if (rut.value != '' && !Fn.validaRut(rut.value)){
    	rut.value = '';
    	alert('¡El RUT ingresado no es válido!');
    }
});

/**
 * Hereda mediante prototype a la clase Date
 * la función que retorna un String bajo 
 * el formato 'yyyy-mm-dd'.
 * 
 * @return String
 */
Date.prototype.toFormatString = function() {
	 var date = new Date(this.valueOf());
	 
	 var dd = date.getDate();
	 var mm = date.getMonth() + 1;
	 var yyyy = date.getFullYear();

	 if(dd < 10){
		dd ='0'+ dd;
	 } 
	 
	 if(mm < 10){
		 mm ='0'+ mm;
	 } 

	 return yyyy + '-' + mm + '-' + dd;
}

var minDate = new Date();
document.getElementById("fIinicio").setAttribute("min", minDate.toFormatString());

/**
 * Captura el evento de cambio de valor para el
 * elemento 'capacitacion', permitiendo la modificación
 * dinámica del precio en un inputtext deshabilitado.
 */
$("#capacitacion").change(function() {
	var e = document.getElementById("capacitacion");
	var valor = e.options[e.selectedIndex].value;
	document.getElementById("precio").value = valor;
});

