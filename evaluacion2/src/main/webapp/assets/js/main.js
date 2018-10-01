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

$("#television").change(function(){
	var e = document.getElementById("television");
	var tv = e.options[e.selectedIndex].value;
	
	if (tv == '') {
		document.getElementById("instalaciones").value = '0';
		document.getElementById("instalaciones").setAttribute("disabled", "disabled");
	} else {
		document.getElementById("instalaciones").removeAttribute("disabled");
		document.getElementById("instalaciones").setAttribute("required");
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
document.getElementById("fecInstalacion").setAttribute("min", minDate.toFormatString());

$("form").submit(function(event) {
	var e = document.getElementById("television");
	var tv = e.options[e.selectedIndex].value;
	
	var e1 = document.getElementById("telefonia");
	var tel = e1.options[e1.selectedIndex].value;
	
	if (tv == "" && tel == "") {
		alert('Debe seleccionar al menos un plan de telefonía y/o televisión.');
		return false;
	} else {
		return true;
	}
});


