/**
 * Hereda mediante prototype a la clase Date
 * la función de agregar días.
 * 
 * @param (integer) days
 * @return Date
 */
Date.prototype.addDays = function(days) {
    var date = new Date(this.valueOf());
    date.setDate(date.getDate() + days);
    return date;
}

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

/**
 * Carga el valor por defecto, mínimo y
 * máximo para un campo inputtext de tipo date.
 * 
 * @param id del elemento
 * @param fecha min
 * @param fecha max
 */
function loadDateField(id, inicio, final) {
	document.getElementById(id).value = inicio;
	document.getElementById(id).setAttribute("min", inicio);
	
	if (final != null) {
		document.getElementById(id).setAttribute("max", final);
	}
}

/**
 * Carga el elemento de fecha de regreso de 
 * manera dinámica.
 */
function loadFechaVuelta() {
	var inicio = document.getElementById("fIda").value;
	loadDateField("fRegreso", inicio, null);
}

/**
 * Carga los vuelos mediante consumo de servicio REST.
 */
var request = new XMLHttpRequest();
request.open('GET', '/evaluacion1/vuelo/retrieve', true);

request.onload = function() {
  if (request.status == 200) {
    var jsonList = JSON.parse(request.responseText);
    var selectItem = '<option selected value="">Seleccione...</option>';
    
    for (var i in jsonList) {
      var nombre = jsonList[i].nombre;
      var valor = jsonList[i].valor;
      selectItem += '<option value="' + valor + '">' + nombre + '</option>';
    }

    document.getElementById("vuelo").innerHTML = selectItem;

  } else {
    alert('Error al consultar los vuelos.');
  }
};

request.onerror = function() {
  alert('Error al consultar los vuelos.');
};

request.send();

/**
 * Captura el evento de cambio de valor para el
 * elemento 'vuelo', permitiendo la modificación
 * dinámica del precio en un inputtext deshabilitado.
 */
$("#vuelo").change(function() {
	var e = document.getElementById("vuelo");
	var valor = e.options[e.selectedIndex].value;
	document.getElementById("precio").value = valor;
});

/**
 * Se cargan los valores asociados a las fecha de ida,
 */
var minDate = new Date();
var maxDate = new Date();
minDate = minDate.addDays(30);
maxDate = maxDate.addDays(120);
loadDateField("fIda", minDate.toFormatString(), maxDate.toFormatString());

/**
 * Captura el evento de cambio de valor para la
 * fecha de ida. En caso de estar habilitado, 
 * esconde el elemento <div> de fechaRegreso.
 */
$("#ida").change(function() {
	var ida = document.getElementById("ida").value;
	
	if (ida) {
		document.getElementById("fechaRegreso").required = false;
		document.getElementById("fechaRegreso").className = 'rendered';
	}
});

/**
 * Captura el evento de cambio de valor para la
 * fecha de regreso. En caso de estar habilitado, 
 * habilita el elemento <div> de fechaRegreso y
 * carga la fecha de manera dinámica.
 */
$("#idaVuelta").change(function() {
	var ida = document.getElementById("idaVuelta").value;
	
	if (ida) {
		document.getElementById("fechaRegreso").className = 'form-group';
		document.getElementById("fechaRegreso").required = true;
		loadFechaVuelta();
		
		$("#fIda").change(function() {
			loadFechaVuelta();
		});
	}
});